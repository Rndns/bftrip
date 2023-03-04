package com.portfolio.bftrip.user;

import com.portfolio.bftrip.place.domain.Kid;
import com.portfolio.bftrip.user.validator.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserInfoRepository userInfoRepository;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public void userJoin(UserDto dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));

        userInfoRepository.save(dto.toEntity()).getId();
    }

    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }

    @Transactional
    public void modify(UserRequestDto dto) {
        User user = userInfoRepository.findById(dto.toEntity().getId()).orElseThrow(() ->
                new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
        String encPassword = encoder.encode(dto.getPassword());
        user.modify(dto.getNickname(), encPassword);
    }

    public Optional<User> findUser(int id){
        return userInfoRepository.findById(id);
    }


}
