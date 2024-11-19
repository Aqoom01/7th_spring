package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberResponseDTO;
import umc.study.web.dto.MissiontoInProgressResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MissiontoInProgressResponseDTO toRegisterResultDTO(MemberMission memberMission) {
        return MissiontoInProgressResponseDTO.builder()
                .status(memberMission.getStatus())
                .updated_at(memberMission.getUpdatedAt())
                .build();
    }

    public static MemberResponseDTO.MissionInProgressDTO missionInProgressDTO(MemberMission memberMission) {
        return MemberResponseDTO.MissionInProgressDTO.builder()
                .missionId(memberMission.getMission().getId())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .reward(memberMission.getMission().getReward())
                .createdAt(memberMission.getCreatedAt())
                .storeName(memberMission.getMission().getStore().getName())
                .build();
    }

    public static MemberResponseDTO.MissionInProgressListDTO missionInProgressListDTO(Page<MemberMission> memberMissions) {
        List<MemberResponseDTO.MissionInProgressDTO> missionInProgressDTOS = memberMissions.stream()
                .map(MemberMissionConverter::missionInProgressDTO).collect(Collectors.toList());

        return MemberResponseDTO.MissionInProgressListDTO.builder()
                .isLast(memberMissions.isLast())
                .isFirst(memberMissions.isFirst())
                .totalPage(memberMissions.getTotalPages())
                .totalElements(memberMissions.getTotalElements())
                .listSize(missionInProgressDTOS.size())
                .missionInProgressDTOS(missionInProgressDTOS)
                .build();
    }
}
