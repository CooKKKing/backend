package com.springboot.menu.dto;

import com.springboot.recipeboard.dto.RecipeBoardDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class MenuDto {
    @Getter
    @Setter
    public static class Post {
        @Schema(description = "메뉴 이름", example = "김치찌개", required = true)
        private String menuName;

        @Schema(description = "메뉴에 들어가는 재료 리스트", required = true)
        private List<MenuIngredientDto.Post> menuIngredientDtos;

        @Schema(description = "메뉴 카테고리 ID", example = "3", required = true)
        private long menuCategoryId;
    }
    @Getter
    @Setter
    public static class Patch {
        @Schema(description = "메뉴 ID", example = "1", required = true)
        private long menuId;

        @Schema(description = "메뉴 이름", example = "된장찌개")
        private String menuName;

        @Schema(description = "메뉴에 들어가는 재료 리스트")
        private List<MenuIngredientDto> menuIngredientDtos;

        @Schema(description = "메뉴 카테고리 ID", example = "2")
        private long menuCategoryId;
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Response {
        private long menuId;
        private String menuName;
        private List<MenuIngredientDto.Response> menuIngredients;
        private MenuCategory category;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class SimpleResponse {
        private long menuId;
        private String image;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class MenuCategory {
        private long menuCategoryId;
        private String menuCategoryName;
        private String menuSubCategory;
    }
}