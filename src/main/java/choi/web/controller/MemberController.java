package choi.web.controller;

import choi.web.domain.Member;
import choi.web.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 등록
     */
    @PostMapping("/members")
    public Long saveMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    /**
     * 회원 전체 조회
     */
    @GetMapping("/members")
    public List<Member> findMember() {
        return memberService.findAllMember();
    }

    /**
     * 회원 조회
     */
    @GetMapping("/members/{memberId}")
    public Member findMember(@PathVariable("memberId") Long id) {
        return memberService.findMember(id);
    }

}