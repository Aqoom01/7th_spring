package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberMissionService;
import umc.study.web.dto.MissiontoInProgressRequestDTO;
import umc.study.web.dto.MissiontoInProgressResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionRestController {
    private final MemberMissionService memberMissionService;

    @PostMapping("/{memberId}/registertoComplete")
    public ApiResponse<MissiontoInProgressResponseDTO> registerToComplete(@PathVariable("memberId") Long memberId, @RequestBody MissiontoInProgressRequestDTO requestDTO) {
        MemberMission memberMission = memberMissionService.registertoComplete(memberId, requestDTO);
        return ApiResponse.onSuccess(MemberMissionConverter.toRegisterResultDTO(memberMission));
    }
}
