package umc.study.web.dto;

import lombok.Getter;
import umc.study.domain.FoodCategory;
import umc.study.domain.Member;

public class MemberPreferRequestDTO {

    @Getter
    public static class JoinDto {
        Long id;
        Member member;
        FoodCategory food_category;
    }
}
