package com.springboot.profile.service;

import com.springboot.exception.BusinessLogicException;
import com.springboot.exception.ExceptionCode;
import com.springboot.member.entity.Member;
import com.springboot.member.entity.MemberProfileImage;
import com.springboot.member.repository.MemberRepository;
import com.springboot.profile.entity.ProfileImage;
import com.springboot.profile.repository.MemberProfileImageRepository;
import com.springboot.profile.repository.ProfileImageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    private final ProfileImageRepository profileImageRepository;
    private final MemberProfileImageRepository memberProfileImageRepository;
    private final MemberRepository memberRepository;

    public ProfileService(ProfileImageRepository profileImageRepository, MemberProfileImageRepository memberProfileImageRepository, MemberRepository memberRepository) {
        this.profileImageRepository = profileImageRepository;
        this.memberProfileImageRepository = memberProfileImageRepository;
        this.memberRepository = memberRepository;
    }

    public ProfileImage findProfileImage(Long profileId) {
        Optional<ProfileImage> profileImage = profileImageRepository.findById(profileId);
        return profileImage.orElseThrow(() -> new BusinessLogicException(ExceptionCode.PROFILE_NOT_FOUND));
    }

    public Page<ProfileImage> findAllProfileImages(int page, int size) {
        return profileImageRepository.findAll(PageRequest.of(page, size, Sort.by("profileImageId").descending()));
    }

    public Page<ProfileImage> findMemberProfileImages(int page, int size, long memberId) {
        return profileImageRepository.findAllByMemberProfileImages_Member_MemberId(memberId, PageRequest.of(page, size, Sort.by("profileImageId").descending()));
    }

    public void purchaseProfile(MemberProfileImage memberProfileImage) {

        long memberId = memberProfileImage.getMember().getMemberId();
        long profileId = memberProfileImage.getProfileImage().getProfileImageId();

        // 🔥 1. 이미 보유 중인지 확인
        boolean alreadyOwned = memberProfileImageRepository
                .existsByMember_MemberIdAndProfileImage_ProfileImageId(memberId, profileId);

        if (alreadyOwned) {
            throw new BusinessLogicException(ExceptionCode.PROFILE_ALREADY_OWNED);
        }
        Member member = memberRepository.findById(memberProfileImage.getMember().getMemberId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        ProfileImage profileImage = profileImageRepository.findById(memberProfileImage.getProfileImage().getProfileImageId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.PROFILE_IMAGE_NOT_FOUND));

        int price = profileImage.getPrice();

        // 2. 밥풀 부족 검증
        if (member.getRicePoint() < price) {
            throw new BusinessLogicException(ExceptionCode.INSUFFICIENT_RICE_POINT);
        }

        // 3. 밥풀 차감
        member.setRicePoint(member.getRicePoint() - price);

        memberProfileImageRepository.save(memberProfileImage);
    }

    @Transactional
    public void equipProfile(Long memberId, Long profileId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        boolean hasProfile = memberProfileImageRepository
                .existsByMember_MemberIdAndProfileImage_ProfileImageId(memberId, profileId);

        if (!hasProfile) {
            throw new BusinessLogicException(ExceptionCode.PROFILE_NOT_OWNED);
        }

        member.setActiveImageId(profileId);
        memberRepository.save(member);
    }

    public Page<ProfileImage> findUnownedProfileImages(int page, int size, long memberId) {
        List<Long> ownedIds = memberProfileImageRepository.findProfileImageIdsByMemberId(memberId);
        return profileImageRepository.findByProfileImageIdNotIn(ownedIds, PageRequest.of(page, size));
    }
}