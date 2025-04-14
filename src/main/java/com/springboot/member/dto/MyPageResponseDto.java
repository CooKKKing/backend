package com.springboot.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyPageResponseDto {
    private String profileImage;
    private String nickname;
    private String currentTitle;
    private int point;
}
