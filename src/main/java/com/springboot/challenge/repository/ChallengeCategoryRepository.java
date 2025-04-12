package com.springboot.challenge.repository;

import com.springboot.category.entity.ChallengeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeCategoryRepository extends JpaRepository<ChallengeCategory, Long> {
}
