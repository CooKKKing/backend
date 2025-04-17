package com.springboot.member.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MyPageResponseDto {
    private String profile;
    private String nickName;
    private String title;
    private int ricePoint;
}
