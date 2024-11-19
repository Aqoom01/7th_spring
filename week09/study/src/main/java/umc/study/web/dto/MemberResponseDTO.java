package umc.study.web.dto;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO {
        Long memberId;
        LocalDateTime createdAt;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionInProgressListDTO {
        List<MissionInProgressDTO> missionInProgressDTOS;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionInProgressDTO {
        Long missionId;
        LocalDateTime createdAt;
        String storeName;
        String missionSpec;
        Integer reward;
    }
}
