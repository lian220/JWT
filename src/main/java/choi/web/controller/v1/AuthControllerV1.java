package choi.web.controller.v1;

import choi.web.auth.JwtTokenProvider;
import choi.web.domain.Member;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "사용자별 인증 정보 CHECK", notes = "사용자를 인증하여 토큰을 Check합니다.")
    public Authentication check(
            @ApiParam(example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjc1OTE5MjQ0LCJleHAiOjE2NzU5MTkzMDR9.zxHGO1hL4Ao_Xr2NrQlSVCIZuT5NGJWtA8XSYmcMO4g",
                    name = "token",
                    required = true)
            @RequestParam  String token) {
        Authentication test = jwtTokenProvider.getAuthentication(token);
        return jwtTokenProvider.getAuthentication(token);
    }

    /**
     * 토큰 미체크
     */
    @PostMapping("/uncheck/access")
    public String uncheck() {
        return "call uncheck()";
    }

}
