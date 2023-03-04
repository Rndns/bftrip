package com.portfolio.bftrip.user;

import com.portfolio.bftrip.user.cofig.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private  String username;

    private  String nickname;

    private  String password;

    private  String email;

    public User toEntity(){
        return User.builder()
                .username(username)
                .nickname(nickname)
                .password(password)
                .email(email)
                .role(Role.USER)
                .build();
    }
}
