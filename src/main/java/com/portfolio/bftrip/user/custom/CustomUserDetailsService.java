package com.portfolio.bftrip.user.custom;

import com.portfolio.bftrip.user.User;
import com.portfolio.bftrip.user.UserInfoRepository;
import com.portfolio.bftrip.user.UserSessionDto;
import com.portfolio.bftrip.user.custom.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserInfoRepository userInfoRepository;

    private final HttpSession session;

    @Override
    public  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userInfoRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("해당 사용자가 존재하지 않습니다. : " + username));

        session.setAttribute("user", new UserSessionDto(user));

        // security session 에 유저 정보 저장
        return new CustomUserDetails(user);
    }
}
