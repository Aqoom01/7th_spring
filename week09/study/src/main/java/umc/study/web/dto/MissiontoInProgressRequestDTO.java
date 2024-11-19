package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.validation.annotation.ExistStore;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MissiontoInProgressRequestDTO {
    Long missionId;
}
