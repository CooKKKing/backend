package com.springboot.collection.repository;

import com.springboot.collection.entity.Collection;
import com.springboot.collection.entity.CollectionItem;
import com.springboot.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionRepository extends JpaRepository<Collection, Long> {
    boolean existsByMemberAndCustomCategoryName(Member member, String customCategoryName);
    boolean existsByCustomCategoryNameAndMember_MemberId(String customCategoryName, long memberId);
    List<Collection> findByMember(Member member);
}
