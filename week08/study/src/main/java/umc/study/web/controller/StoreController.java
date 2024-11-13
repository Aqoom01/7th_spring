package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.domain.Store;
import umc.study.service.StoreService;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;
import umc.study.converter.StoreConverter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/registerRegion")
    public ApiResponse<StoreResponseDTO.JoinRegionResultDTO> joinRegion(@RequestBody StoreRequestDTO.JoinDTO storeRequestDTO) {
        Store store = storeService.joinRegion(storeRequestDTO);
        return ApiResponse.onSuccess(StoreConverter.toJoinRegionResultDTO(store));
    }
}
