package com.springboot.ranking.controller;

import com.springboot.ranking.dto.RankingResponseDto;
import com.springboot.ranking.service.RankingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "랭킹 컨트롤러", description = "랭킹 관련 컨트롤러")
@RestController
@RequestMapping("/rankings")
public class RankingController {

    private final RankingService rankingService;
    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_SIZE = 30;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @Operation(summary = "레시피 보드 랭킹 조회", description = "레시피 보드 랭킹을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "레시피 보드 랭킹 조회 성공"),
            @ApiResponse(responseCode = "404", description = "레시피 보드 랭킹을 찾을 수 없습니다.")
    })
    @GetMapping("/recipe-board")
    public List<RankingResponseDto> getRecipeBoardRanking() {
        return rankingService.getTopRecipeBoardWriters();
    }

    @Operation(summary = "좋아요 랭킹 조회", description = "좋아요 랭킹을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "좋아요 랭킹 조회 성공"),
            @ApiResponse(responseCode = "404", description = "좋아요 랭킹을 찾을 수 없습니다.")
    })
    @GetMapping("/likes")
    public List<RankingResponseDto> getLikeRanking() {
        return rankingService.getTopLikeReceivers();
    }

    @Operation(summary = "북마크 랭킹 조회", description = "북마크 랭킹을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "북마크 랭킹 조회 성공"),
            @ApiResponse(responseCode = "404", description = "북마크 랭킹을 찾을 수 없습니다.")
    })
    @GetMapping("/bookmarks")
    public List<RankingResponseDto> getBookmarkRanking() {
        return rankingService.getTopBookmarkReceivers();
    }

    @Operation(summary = "칭호 랭킹 조회", description = "칭호 랭킹을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "칭호 랭킹 조회 성공"),
            @ApiResponse(responseCode = "404", description = "칭호 랭킹을 찾을 수 없습니다.")
    })
    @GetMapping("/titles")
    public List<RankingResponseDto> getTitleRanking() {
        return rankingService.getTopTitleCollectors();
    }
}
