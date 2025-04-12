package com.springboot.challenge.service;

import com.springboot.category.entity.ChallengeCategory;
import com.springboot.challenge.entity.Challenge;
import com.springboot.challenge.repository.ChallengeCategoryRepository;
import com.springboot.challenge.repository.ChallengeRepository;
import com.springboot.exception.BusinessLogicException;
import com.springboot.exception.ExceptionCode;
import com.springboot.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService {
    private final MemberRepository memberRepository;
    private final ChallengeRepository challengeRepository;
    private final ChallengeCategoryRepository challengeCategoryRepository;

    public ChallengeService(MemberRepository memberRepository, ChallengeRepository challengeRepository, ChallengeCategoryRepository challengeCategoryRepository) {
        this.memberRepository = memberRepository;
        this.challengeRepository = challengeRepository;
        this.challengeCategoryRepository = challengeCategoryRepository;
    }

    public Challenge findChallengesOfCategory(long categoryId, long memberId) {
        return null;
    }

    public Challenge findChallenge(long challengeId, long memberId) {
        return null;
    }

    // 회원 존재 여부

    // 도전과제 존재 여부
    public Challenge verifyChallengeExists(long challengeId) {
        return challengeRepository.findById(challengeId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.CHALLENGE_NOT_FOUND));
    }

    // 도전과제 카테고리 존재 여부
    public ChallengeCategory verifyChallengeCategoryExists(long categoryId) {
        return challengeCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.CHALLENGE_CATEGORY_NOT_FOUND));
    }
}
