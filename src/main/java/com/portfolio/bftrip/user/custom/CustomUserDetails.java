package com.portfolio.bftrip.user.custom;

import com.portfolio.bftrip.user.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/* security 가 로그인 요청을 가로채 로그인을 진행하고 완료되면 UserDetails 타입의 오브젝트를 세션저장소에 저장 */
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final User user;

    @Override
    public String getPassword() { return user.getPassword();}

    @Override
    public String getUsername() { return user.getUsername();}

    // 계정 만료
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정 잠김
    @Override
    public  boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호 만료
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 사용자 활성화
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 유저 권환
    @Override
    public  Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();

        collectors.add(() -> "ROLE_"+user.getRole());

        return collectors;
    }
}
