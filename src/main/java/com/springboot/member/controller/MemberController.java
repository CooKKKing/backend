package com.springboot.member.controller;

import com.springboot.member.dto.MemberDto;
import com.springboot.member.entity.Member;
import com.springboot.member.mapper.MemberMapper;
import com.springboot.member.service.MemberService;
import com.springboot.utils.UriCreator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@Tag(name = "회원 컨트롤러", description = "회원 관련 컨트롤러")
@RestController
@RequestMapping("/members")
@Validated
public class MemberController {
    private static final String MEMBER_DEFAULT_URL = "/members";
    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @Operation(summary = "회원 가입", description = "회원 가입을 진행합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "회원 등록 완료"),
            @ApiResponse(responseCode = "404", description = "Member not found")
    })
    @PostMapping
    public ResponseEntity postMember(@RequestBody @Valid MemberDto.Post memberPostDto) {
        // Mapper를 통해 받은 Dto 데이터 Member로 변환
        Member member = mapper.memberPostToMember(memberPostDto);
        Member createdMember = memberService.createMember(member);
        URI location = UriCreator.createUri(MEMBER_DEFAULT_URL, createdMember.getMemberId());

        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "회원 수정(닉네임)", description = "회원 정보를 수정합니다(닉네임만).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원 수정 완료"),
            @ApiResponse(responseCode = "404", description = "Member not found")
    })
    @PatchMapping
    public ResponseEntity patchMember(@RequestBody @Valid MemberDto.Patch memberPatchDto,
                                      @Parameter(hidden = true) @AuthenticationPrincipal Member authenticatedmember){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "회원 조회", description = "회원 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원 조회 완료"),
            @ApiResponse(responseCode = "404", description = "Member not found")
    })
    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "회원 탈퇴(자신)", description = "자신(회원)이 탈퇴 합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "회원 삭제 완료"),
            @ApiResponse(responseCode = "404", description = "Member not found")
    })
    @DeleteMapping
    public ResponseEntity deleteMember(@Parameter(hidden = true) @AuthenticationPrincipal Member authenticatedmember) {;

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

