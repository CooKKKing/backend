package com.springboot.recipeboard.repository;

import com.springboot.member.entity.Member;
import com.springboot.recipeboard.entity.RecipeBoard;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecipeBoardRepository extends JpaRepository<RecipeBoard, Long> {
    Page<RecipeBoard> findByMemberAndRecipeBoardStatusNot(Member member, RecipeBoard.RecipeBoardStatus status, Pageable pageable);
    // 내 레시피 게시글 검색 JPQL
    @Query("SELECT rb FROM RecipeBoard rb " +
            "WHERE rb.member = :member " +
            "AND rb.recipeBoardStatus <> :status " +
            "AND (" +
            "   :keyword IS NULL OR " +
            "   LOWER(rb.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "   LOWER(rb.content) LIKE LOWER(CONCAT('%', :keyword, '%'))" +
            ")")
    Page<RecipeBoard> searchMyRecipeBoards(
            @Param("member") Member member,
            @Param("status") RecipeBoard.RecipeBoardStatus status,
            @Param("keyword") String keyword,
            Pageable pageable);
}
