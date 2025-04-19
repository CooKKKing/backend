package com.springboot.collection.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CollectionItemDto {
    @Getter
    public static class Post {
        @NotBlank(message = "메뉴 이름은 필수입니다.")
        @Schema(description = "도감에 등록할 음식 이름", example = "공기밥")
        private String menuName;
    }

    @Getter
    @Builder
    public static class Response {
        private long collectionItemId;

        @Schema(description = "도감에 등록된 음식 이름", example = "카레덮밥")
        private String menuName;

        @Schema(description = "도감에 등록된 음식 이미지 URL", example = "https://img.cookking.com/menus/curry.jpg")
        private String imageUrl;
    }
}
