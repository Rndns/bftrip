package com.portfolio.bftrip.user;

import com.portfolio.bftrip.user.cofig.Role;
import lombok.Getter;

import java.io.Serializable;

// 인증된 사용자 정보를 직렬화 없이 세션에 저장
@Getter
public class UserSessionDto implements Serializable {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private Role role;
    private String modifidedDate;

    public UserSessionDto(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.role = user.getRole();
        this.modifidedDate = user.getModifiedDate();
    }
}
