package umc.study.service;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
    Page<MemberMission> getOwnMissions(Long memberId, Integer page);
    boolean isMember(Long memberId);
    Page<Review> getOwnReviews(Long memberId, Integer page);
}
