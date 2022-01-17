package investment.board.service;

import investment.board.entity.Member;
import investment.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)  // 조회 전용
@RequiredArgsConstructor  //lombok
public class MemberService {

    private final MemberRepository memberRepository;


    /**
     * 회원 가입
     */
    @Transactional   // 데이터 변경이 필요한 메서드에 붙여준다
    public Long signup(Member member) {
        memberRepository.save(member);
        return member.getId();
    }



}
