package umc.study.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Mission;

import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.web.dto.MissiontoInProgressRequestDTO;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberMissionService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    public MemberMission registertoComplete(Long memberId, MissiontoInProgressRequestDTO request) {
        Member member = memberRepository.findById(memberId).orElse(null);
        Mission mission = missionRepository.findById(request.getMissionId()).orElse(null);

        MemberMission memberMission = MemberMission.builder()
                .mission(mission)
                .member(member)
                .status(MissionStatus.IN_PROGRESS)
                .build();

        return memberMissionRepository.save(memberMission);
    }

    public boolean isExistsinRepo(List<Long> values) {
        return values.stream()
                .allMatch(value -> memberMissionRepository.existsById(value));
    }
}