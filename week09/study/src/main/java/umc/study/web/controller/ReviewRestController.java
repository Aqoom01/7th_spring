package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.StoreResponseDTO;
import umc.study.web.dto.WriteReviewRequestDTO;
import umc.study.web.dto.WriteReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {
    private final ReviewService reviewService;

    @PostMapping("{memberId}/{shopId}")
    public ApiResponse<WriteReviewResponseDTO.WriteReviewResponseDTOBuilder> WriteReview(@PathVariable("memberId") Long memberId, @PathVariable("shopId") @Valid @ExistStore Long shopId, @RequestBody WriteReviewRequestDTO.ReviewWriteRequestDTO requestDTO) {
        Review review = reviewService.write(memberId, shopId, requestDTO);
        return ApiResponse.onSuccess(ReviewConverter.toWriteResultDTO(review));
    }
}
