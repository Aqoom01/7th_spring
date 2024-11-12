package umc.study.repository.MemberRepository;

import com.querydsl.core.Tuple;
import umc.study.domain.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    Member findMemberById(Long Id);
    List<Tuple> getHome(Long member_id, Long region_id);
}
