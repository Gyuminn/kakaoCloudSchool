package com.example.apiserver.security;


import com.example.apiserver.domain.APIUser;
import com.example.apiserver.dto.APIUserDTO;
import com.example.apiserver.persistence.APIUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class APIUserDetailsService implements UserDetailsService {
    private final APIUserRepository apiUserRepository;

    //로그인을 처리해주는 메서드
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        //User 찾아오기
        Optional<APIUser> result =
                apiUserRepository.findById(username);
        //유저 정보를 가져오는데 없는 경우에는 예외를 발생시킴
        APIUser apiUser =
                result.orElseThrow(() ->
                    new UsernameNotFoundException("아이디가 잘못되었습니다.")
                );
        //로그인 성공에 대한 처리
        log.info("apiUser-----------------------");

        //로그인 성공했을 때 정보를 저장해서 리턴
        //비밀번호는 제외하는 경우가 많습니다.
        APIUserDTO dto = new APIUserDTO(
                apiUser.getMid(), apiUser.getMpw(),
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
        log.info(dto);
        return dto;
    }
}
