package com.portfolio.bftrip.user.validator;

import com.portfolio.bftrip.user.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Component
public class CheckUsernameValidator extends AbstractValidator<UserRequestDto> {

    private final UserInfoRepository userInfoRepository;

    @Override
    protected void doValidate(UserRequestDto dto, Errors errors) {
        if (userInfoRepository.existsByUsername(dto.toEntity().getUsername())) {
            errors.rejectValue("username", "아이디 중복 오류", "이미 사용중인 아이디 입니다.");
        }
    }
}
