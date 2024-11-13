package umc.study.converter;

import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MissiontoInProgressResponseDTO;

public class MemberMissionConverter {

    public static MissiontoInProgressResponseDTO toRegisterResultDTO(MemberMission memberMission) {
        return MissiontoInProgressResponseDTO.builder()
                .status(memberMission.getStatus())
                .updated_at(memberMission.getUpdatedAt())
                .build();
    }
}
