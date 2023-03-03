package com.plantit.config.auth;


import com.plantit.DATA.dal.entities.User;
import com.plantit.DATA.dal.repositories.UserRepository;
import com.plantit.DATA.dal.repositories.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository personneRepository;
    private final PasswordEncoder passwordEncoder;
    //private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserTypeRepository roleRepository;
    private User currentUser;
    private String jwtToken;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        jwtToken = jwtToken;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

//    public AuthenticationResponse register(RegisterRequest request) {
//        Date date = new Date();
//        User user = User.builder()
//                .nom(request.getLastname())
//                .prenom(request.getFirstname())
//                .email(request.getEmail())
//                .mdp(passwordEncoder.encode(request.getPassword()))
//                .role(roleRepository.findById(1).get())
//                .build();
//        personneRepository.save(user);
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
//    }

//    public AuthenticationResponse authenticate(AuthenticationRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getEmail(),
//                        request.getPassword()
//                )
//        );
//        User user = personneRepository.findByLogin(request.getEmail()).orElseThrow();
//        if (new BCryptPasswordEncoder().matches(request.getPassword(), user.getPassword()) && user.isEnabled()) {
//            jwtToken = null;//jwtService.generateToken(user);
//            currentUser = user;
//            return AuthenticationResponse.builder()
//                    .token(jwtToken)
//                    .idUser(currentUser.getIdUser().intValue())
//                    .role(currentUser.getUserType().getIdUserType().intValue())
//                    .build();
//        }
//        return null;
//    }

    public void disconnect(User portalUser) {
        CompletableFuture.delayedExecutor(30, TimeUnit.SECONDS).execute(() -> {

        });
    }
}
