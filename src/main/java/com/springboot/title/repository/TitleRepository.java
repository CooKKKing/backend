package com.springboot.title.repository;

import com.springboot.title.entity.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TitleRepository extends JpaRepository<Title, Long> {
    Page<Title> findByMemberTitles_Member_MemberId(Long memberId, Pageable pageable);

    @Query("SELECT t FROM Title t WHERE NOT EXISTS (" +
            "SELECT 1 FROM MemberTitle mt WHERE mt.member.memberId = :memberId AND mt.title = t)")
    Page<Title> findTitlesNotOwnedByMember(@Param("memberId") Long memberId, Pageable pageable);
    List<Title> findAll();
}