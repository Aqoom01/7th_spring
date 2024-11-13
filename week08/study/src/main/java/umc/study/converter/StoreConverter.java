package umc.study.converter;

import lombok.Getter;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.JoinRegionResultDTO toJoinRegionResultDTO(Store store) {
        return StoreResponseDTO.JoinRegionResultDTO.builder()
                .updatedAt(LocalDateTime.now())
                .build();
    }
}