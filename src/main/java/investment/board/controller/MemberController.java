package investment.board.controller;

import investment.board.entity.Member;
import investment.board.form.MemberForm;
import investment.board.repository.MemberRepository;
import investment.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/{id}")
    public String findMember(@PathVariable("id") Long id) {
        return "아직 안만듦";
    }

    @GetMapping("signup")
    public String signup(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "member/signup";
    }
    @PostMapping("signup")
    public String signup( MemberForm memberForm) {
        Member member = Member.builder()
                .memberId(memberForm.getMemberId())
                .username(memberForm.getUsername())
                .email(memberForm.getEmail())
                .password(memberForm.getPassword())
                .build();

        System.out.println("memberForm.getEmail() = " + memberForm.getEmail());
        System.out.println("memberForm.getUsername() = " + memberForm.getUsername());
        System.out.println("memberForm.getMemberId() = " + memberForm.getMemberId());

        System.out.println("member.getEmail() = " + member.getEmail());
        System.out.println("member name = " + member.getUsername());
        System.out.println("member = " + member.getMemberId());
        
        memberService.signup(member);
        return "redirect:/";
    }
}
