package choi.web.controller.v1;

import choi.web.auth.JwtTokenProvider;
import choi.web.domain.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class AuthControllerV1 {

    private final JwtTokenProvider jwtTokenProvider;

    /**
     * 토큰 생성 요청
     */
    @PostMapping("/token")
    @ApiOperation(value = "사용자별 인증 정보 CHECK 및 토큰 발급", notes = "사용자를 인증하여 토큰을 발급합니다.")
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
