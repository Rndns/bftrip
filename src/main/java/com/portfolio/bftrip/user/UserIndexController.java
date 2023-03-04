package com.portfolio.bftrip.user;

import com.portfolio.bftrip.user.custom.CustomUserDetailsService;
import com.portfolio.bftrip.user.custom.LoginUser;
import com.portfolio.bftrip.user.validator.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class UserIndexController {

    @Autowired
    UserService userService;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @GetMapping("/auth/join")
    public String join() { return "/user/user-join"; }

    @PostMapping("/auth/joinProc")
    public String joinProc(UserDto userDto) {
        userService.userJoin(userDto);
//        customUserDetailsService.loadUserByUsername(userDto.getUsername());
        return "redirect:/auth/login";
    }
//    public String joinProc(@Valid UserRequestDto userDto, Errors errors, Model model) {
//
//        if (errors.hasErrors()) {
//            /* 회원가입 실패시 입력 데이터 값을 유지 */
//            // Key : valid_{dto 필드명}, Message : dto 에서 작성한 message 값
//            model.addAttribute("userDto", userDto);
//
//            /* 유효성 통과 못한 필드와 메시지를 핸들링 */
//            Map<String, String> validatorResult = userService.validateHandling(errors);
//            for (String key : validatorResult.keySet()) {
//                model.addAttribute(key, validatorResult.get(key));
//            }
//            return "/user/user-join";
//        }
//        userService.userJoin(userDto);
//        return "redirect:/auth/login";
//    }

    @GetMapping("/auth/login")
    public String login() {
        return "/user/user-login";}

    @PostMapping("/auth/loginProc")
    public String loginProc(UserDto userDto) {
        customUserDetailsService.loadUserByUsername(userDto.getUsername());
        return "/main";
    }

    @GetMapping("/auth/modify")
    public String modify(@LoginUser UserSessionDto userDto, Model model) {
        if (userDto != null) {
            model.addAttribute("user", userDto.getNickname());
            model.addAttribute("userDto", userDto);
        }
        return "/user/user-modify";
    }

    @PostMapping("/auth/dropout")
    public String dropout(UserSessionDto userSessionDto) {
        return "/main";
    }
}
