package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDateTime;

@Getter
@Builder
public class MissiontoInProgressResponseDTO {
    MissionStatus status;
    LocalDateTime updated_at;
}
