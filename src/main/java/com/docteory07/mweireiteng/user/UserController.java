package com.docteory07.mweireiteng.user;

import com.docteory07.mweireiteng.user.dto.CreateUserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }

    @GetMapping("/create")
    public String signup() {
        if (isAuthenticated()) {
            return "redirect:/";
        }
        return "user/signup";
    }

    @PostMapping("/create")
    public String signup(@RequestBody @Valid CreateUserDto dto, RedirectAttributes redirectAttributes) {
        User user = userService.create(dto);

        redirectAttributes.addAttribute("user", user);
        return "redirect:/user/login";
    }
}