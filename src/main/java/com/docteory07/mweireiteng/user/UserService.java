package com.docteory07.mweireiteng.user;

import com.docteory07.mweireiteng.user.dto.CreateUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User create(CreateUserDto dto) {
        User user = new User(
                dto.getUsername(),
                dto.getPassword(),
                dto.getEmail()
        );

        return userRepository.save(user);
    }

}
