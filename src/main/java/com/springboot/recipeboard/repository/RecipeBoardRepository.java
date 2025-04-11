package com.springboot.recipeboard.repository;

import com.springboot.recipeboard.entity.RecipeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeBoardRepository extends JpaRepository<RecipeBoard, Long> {

}
