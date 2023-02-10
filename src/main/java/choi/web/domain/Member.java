package choi.web.domain;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(example = "1", notes = "유저 아이디", required = true)
    private Long memberId;

    @ApiModelProperty(example = "dylim", notes = "유저 이름", required = true)
    private String memberName;

    @ApiModelProperty(example = "12345", notes = "유저 비밀번호",  required = true)
    private String memberPassword;

}
