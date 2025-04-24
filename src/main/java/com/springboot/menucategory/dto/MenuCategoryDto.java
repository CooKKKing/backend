package com.springboot.menucategory.dto;

import com.springboot.menu.dto.MenuDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class MenuCategoryDto {
    @Getter
    @Setter
    public static class Post {
        @Schema(description = "메뉴 카테고리 이름", example = "한식", required = true)
        private String menuCategoryName;
    }

    @Getter
    @Setter
    public static class Patch {
        @Schema(description = "메뉴 카테고리 ID", example = "1", required = true)
        private long menuCategoryId;

        @Schema(description = "메뉴 카테고리 이름", example = "양식")
        private String menuCategoryName;
    }

    @Getter
    @Setter
    public static class Response {
        private long menuCategoryId;
        private String menuCategoryName;
        private List<MenuDto.SimpleResponse> menus;
    }
}