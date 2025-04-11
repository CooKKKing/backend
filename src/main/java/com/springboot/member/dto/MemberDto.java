package com.springboot.member.dto;

import com.springboot.member.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MemberDto {
    @Getter
    public static class Post {
        @NotBlank(message = "ID는 공백이 아니어야 합니다.")
        @Schema(description = "사용자 아이디", example = "example123")
        private String loginId;

        @NotBlank(message = "이메일은 공백이 아니어야 합니다.")
        @Email(message = "이메일 형식을 잘못 입력했습니다.")
        @Schema(description = "사용자 이메일", example = "example@gmail.com")
        private String email;

        @NotBlank
        @Pattern(regexp = "^(?=(?:.*[A-Za-z]){6,})(?=.*\\d)(?=(?:[^%$#@!*]*[%$#@!*])+)[A-Za-z\\d%$#@!*]{8,20}$",
                message = "비밀번호는 8~20자 영문(최소 6자), 숫자, 특수문자(%,$,#,@,!,*) 1자 이상을 조합해야 합니다.")
        @Schema(description = "사용자 비밀번호", example = "example123!")
        private String password;

        @NotBlank(message = "닉네임은 공백이 아니어야 합니다.")
        @Pattern(regexp = "^(?!\\s)(?!.*\\s{2,})(?!.*[~!@#$%^&*()_+=|<>?:{}\\[\\]\"';,.\\\\/`])[^\\s]{1,8}(?<!\\s)$",
                message = "닉네임은 공백 없이 8자 이내, 특수문자를 포함하지 않아야 합니다.")
        @Schema(description = "사용자 닉네임", example = "어쩌고저쩌고")
        private String nickName;

        @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
                message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
        @Schema(description = "사용자 전화번호", example = "010-1111-2222")
        private String phoneNumber;
    }

    @Getter
    public static class Patch{
        private long memberId;

        @Setter
        private String nickName;
    }

    @AllArgsConstructor
    @Getter
    public static class Response {
        private long memberId;
        private String id;
        private String email;
        private String name;
        private String phoneNumber;
        private Member.MemberStatus memberStatus;

        public String getMemberStatus() {
            return memberStatus.getStatus();
        }
    }
}