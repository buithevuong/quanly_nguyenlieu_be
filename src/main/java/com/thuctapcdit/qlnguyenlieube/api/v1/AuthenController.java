package com.thuctapcdit.qlnguyenlieube.api.v1;

import com.thuctapcdit.qlnguyenlieube.dto.AuthenRequest;
import com.thuctapcdit.qlnguyenlieube.dto.AuthenResponse;
import com.thuctapcdit.qlnguyenlieube.dto.SuccessRestDto;
import com.thuctapcdit.qlnguyenlieube.dto.UserDto;
import com.thuctapcdit.qlnguyenlieube.exception.AuthenException;
import com.thuctapcdit.qlnguyenlieube.utils.JwtUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.thuctapcdit.qlnguyenlieube.security.MyUserDetailsService;

import java.util.Optional;


@RestController
@RequestMapping("")
@CrossOrigin("*")
public class AuthenController {
    private static final Logger logger = LogManager.getLogger(AuthenController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenRequest authenticationRequest) throws Exception {
        logger.info("Login request by {} " , authenticationRequest.getUsername());

        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new AuthenException(e.getMessage());
        }

        //SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        Optional<AuthenResponse> res = userDetailsService.reponseAccount(jwt,authenticationRequest.getUsername());

        return ResponseEntity.ok(res.get());
    }

    @PostMapping("/registration")
    public ResponseEntity<SuccessRestDto> createAccount(@RequestBody UserDto userDto){
        logger.info("registration by {} " , userDto.getEmail());
        UserDto account = userDetailsService.save(userDto);


        return ResponseEntity.ok(new SuccessRestDto("Sign up Succeess" , account));

    }

//    @PostMapping("/logoutToken")
//    public ResponseEntity<ResponseData> logOut(@RequestBody String token) {
//        jwtTokenUtil.extractExpiration(token);
//
//        return ResponseEntity.ok(ResponseData.reponseSuccess("Logout Success" , token));
//    }



}
