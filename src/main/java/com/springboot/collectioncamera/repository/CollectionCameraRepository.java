package com.springboot.collectioncamera.repository;

import com.springboot.collectioncamera.entity.CollectionCamera;
import com.springboot.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionRepository extends JpaRepository<CollectionCamera, Long> {
    boolean existsByMemberAndCustomCategoryName(Member member, String customCategoryName);
    boolean existsByCustomCategoryNameAndMember_MemberId(String customCategoryName, long memberId);
    List<CollectionCamera> findByMember(Member member);
}
