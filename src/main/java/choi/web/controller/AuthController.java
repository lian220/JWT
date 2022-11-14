package choi.web.controller;

import choi.web.auth.JwtTokenProvider;
import choi.web.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    /**
     * 토큰 생성 요청
     */
    @PostMapping("/token")
    public String createToken(@RequestBody Member member) {
        return jwtTokenProvider.createToken(String.valueOf(member.getMemberId()));
    }

    /**
     * 토큰 체크
     */
    @PostMapping("/check/access")
    public String check() {
        return "call check()";
    }

    /**
     * 토큰 미체크
     */
    @PostMapping("/uncheck/access")
    public String uncheck() {
        return "call uncheck()";
    }

}