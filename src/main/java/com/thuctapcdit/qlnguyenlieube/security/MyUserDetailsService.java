package com.thuctapcdit.qlnguyenlieube.security;

import com.thuctapcdit.qlnguyenlieube.dao.UserRepo;
import com.thuctapcdit.qlnguyenlieube.dto.AuthenResponse;
import com.thuctapcdit.qlnguyenlieube.dto.UserDto;
import com.thuctapcdit.qlnguyenlieube.exception.NotFoundException;
import com.thuctapcdit.qlnguyenlieube.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByEmail(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found : " + userName));

        return user.map(CustomUserDetails::new).get() ;
    }

    public UserDto save(UserDto userDto) {
        User user = modelMapper.map(userDto , User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(1);
        User saveAcc = userRepo.save(user);

        UserDto dto = modelMapper.map(saveAcc, UserDto.class);
        dto.setPassword(null);
        return dto;
    }

    public Optional<AuthenResponse> reponseAccount(String jwt , String username) {
        if(username == null) {
            return Optional.empty();
        }else {

            User user = userRepo.findByEmail(username).orElseThrow(
                    () -> new NotFoundException("Not found account")
            );

            AuthenResponse res = AuthenResponse.builder()
                    .jwt(jwt)
                    .email(user.getEmail())
                    .id(user.getId())
                    .build();

            return Optional.of(res);
        }

    }

}
