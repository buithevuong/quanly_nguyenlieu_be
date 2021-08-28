package com.thuctapcdit.qlnguyenlieube.security;

import com.thuctapcdit.qlnguyenlieube.config.RabbitMqConfig;
import com.thuctapcdit.qlnguyenlieube.dao.UserRepo;
import com.thuctapcdit.qlnguyenlieube.dto.AuthenResponse;
import com.thuctapcdit.qlnguyenlieube.dto.MessageSendPassword;
import com.thuctapcdit.qlnguyenlieube.dto.UserDto;
import com.thuctapcdit.qlnguyenlieube.exception.InvalidParameterException;
import com.thuctapcdit.qlnguyenlieube.exception.NotFoundException;
import com.thuctapcdit.qlnguyenlieube.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class MyUserDetailsService implements UserDetailsService {

    public static final int TIME_EXPIRED_TOKEN_RESET_PASSWORD = 60*60*60;

    @Autowired
    private RabbitTemplate rabbitTemplate;

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
        Optional<User> userByEmail = userRepo.findByEmail(userDto.getEmail());

        if(userByEmail.isPresent()){
            throw new InvalidParameterException("Account is Present");
        }
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
    @Transactional
    public Boolean sendTokenResetPassword(String email) {
        User userByEmail = userRepo.findByEmail(email).orElseThrow(() -> {
            throw new NotFoundException("not found user");
        });

        String tokenResetPassword = generateTokenResetPassword().toString();

        Date expiredForgotPassword = new Date(((new Date().getTime()) + TIME_EXPIRED_TOKEN_RESET_PASSWORD));
        String linkResetPassword = email + tokenResetPassword;

        userByEmail.setToken(passwordEncoder.encode(linkResetPassword));
        userByEmail.setTokenExpired(expiredForgotPassword);

        User user = userRepo.save(userByEmail);


        MessageSendPassword message = MessageSendPassword.builder()
                .token(tokenResetPassword)
                .address(user.getEmail())
                .build();

            rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE2, RabbitMqConfig.ROUTING_KEY2, message);
        return true;
    }

    @Transactional
    public Map<String, Object> resetPassword(String email, String password, Integer tokenResetPassword) {
        if (!validateTokenResetPassword(email, tokenResetPassword)) {
            throw new InvalidParameterException("Token not valid");
        }

        User userByEmail = userRepo.findByEmail(email).orElseThrow(() -> {
            throw new NotFoundException("not found user");
        });

        userByEmail.setPassword(passwordEncoder.encode(password));
        userByEmail.setTokenExpired(new Date());
        User user = userRepo.save(userByEmail);

        Map<String, Object> map = new HashMap<>();
        map.put("email", user.getEmail());
        return map;
    }

    private Boolean validateTokenResetPassword(String email, Integer token) {
        User userByEmail = userRepo.findByEmail(email).orElseThrow(() -> {
            throw new NotFoundException("not found user");
        });

        String link = email + token;

        Date date = userByEmail.getTokenExpired();
        String linkDb = userByEmail.getToken();

        boolean checkToken = passwordEncoder.matches(link, linkDb);
        int checkTimeExpired = (int) (date.getTime() - new Date().getTime()) / 1000;
        if (checkTimeExpired >= 0) {
            return checkTimeExpired <= TIME_EXPIRED_TOKEN_RESET_PASSWORD && checkToken;
        }
        throw new InvalidParameterException("Time not valid");

    }


    private Integer generateTokenResetPassword() {
        return ThreadLocalRandom.current().nextInt(100000, 999999);
    }


}
