package umc.study.service.MemberService;

import com.querydsl.core.Tuple;
import umc.study.domain.Member;

import java.util.List;

public interface MemberService {
    Member findMemberById(Long id);
    List<Tuple> getHome(Long member_id, Long region_id);
}
