package com.springboot.challenge.repository;

import com.springboot.member.entity.MemberChallenge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberChallengeRepository extends JpaRepository<MemberChallenge, Long> {
    Page<MemberChallenge> findByMember_MemberId(Long memberId, Pageable pageable);
}