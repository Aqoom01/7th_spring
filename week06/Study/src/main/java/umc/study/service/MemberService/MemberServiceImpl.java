package umc.study.service.MemberService;

import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.repository.MemberRepository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public Member findMemberById(Long id) {
        return memberRepository.findMemberById(id);
    }

    @Override
    public List<Tuple> getHome(Long member_id, Long region_id) {
        return memberRepository.getHome(member_id, region_id);
    }
}
