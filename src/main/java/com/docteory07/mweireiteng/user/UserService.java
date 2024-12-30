package com.docteory07.mweireiteng.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User create(String username, String password, String email) {
        User user = new User(
                username,
                passwordEncoder.encode(password),
                email
        );

        return userRepository.save(user);
    }

}
