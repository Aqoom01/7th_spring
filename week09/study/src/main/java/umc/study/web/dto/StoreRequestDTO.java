package umc.study.web.dto;

import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class JoinDTO {
        Long storeId;
        Long regionId;
    }
}
