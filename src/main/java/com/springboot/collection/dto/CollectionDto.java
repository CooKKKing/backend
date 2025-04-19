package com.springboot.collection.dto;


import com.springboot.audit.BaseEntity;
import com.springboot.collection.entity.Collection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CollectionDto {
    @Getter
    public static class Post {
        @Schema(description = "도감 카테고리 이름", example = "실패해서 다시 도전할 음식")
        @NotBlank(message = "도감 카테고리 이름은 필수입니다.")
        @Size(min = 1, max = 20, message = "카테고리 이름은 1자 이상 20자 이내여야 합니다.")
        @Pattern(
                regexp = "^(?!\\s)(?!.*\\s{2,}).*$",
                message = "카테고리 이름은 공백으로 시작하거나 연속된 공백이 포함될 수 없습니다."
        )
        private String categoryName;
    }

    @Getter
    @Setter
    public static class Patch {
        @Schema(description = "도감 카테고리 이름", example = "실패해서 다시 도전할 음식")
        @NotBlank(message = "도감 카테고리 이름은 필수입니다.")
        @Size(min = 1, max = 20, message = "카테고리 이름은 1자 이상 20자 이내여야 합니다.")
        @Pattern(
                regexp = "^(?!\\s)(?!.*\\s{2,}).*$",
                message = "카테고리 이름은 공백으로 시작하거나 연속된 공백이 포함될 수 없습니다."
        )
        private String categoryName;
    }

    @Getter
    @Builder
    public static class Response {
        @Schema(description = "도감 카테고리 ID", example = "1")
        private Long collectionId;

        @Schema(description = "도감 카테고리 이름", example = "실패해서 다시 도전할 음식")
        private String categoryName;

        @Schema(description = "도감 공개 상태", example = "PUBLIC")
        private Collection.CollectionStatus collectionStatus;
    }
}
