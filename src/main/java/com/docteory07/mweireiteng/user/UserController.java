package com.docteory07.mweireiteng.user;

import com.docteory07.mweireiteng.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signup(CreateUserDto dto) {
        return "user/signup";
    }

    @PostMapping("/signup")
    public String signup( @Valid CreateUserDto dto, BindingResult bs) {
        if (bs.hasErrors()) {
            return "user/signup";
        }
        if (!dto.getPassword().equals(dto.getPasswordC())) {
            bs.rejectValue("passwordC", "passwordIncorrect", "비밀번호가 일치하지 않습니다.");
            return "user/signup";
        }
        try {
            userService.create(
                    dto.getUsername(),
                    dto.getPassword(),
                    dto.getEmail()
            );
        } catch (DataIntegrityViolationException e) {
            bs.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "user/signup";
        } catch (Exception e) {
            bs.reject("signupFailed", e.getMessage());
            return "user/signup";
        }
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }
}