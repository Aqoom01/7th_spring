package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class StoreResponseDTO {

    @Getter
    @Builder
    public static class JoinRegionResultDTO {
        LocalDateTime updatedAt;
    }
}
