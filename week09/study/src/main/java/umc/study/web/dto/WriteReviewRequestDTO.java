package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class WriteReviewRequestDTO {

    @Getter
    @Builder
    public static class ReviewWriteRequestDTO{
        String reviewText;
        Float reviewScore;
        List<String> reviewPic;
    }
}
