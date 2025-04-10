package com.springboot.recipestep.entity;

import com.springboot.recipeboard.entity.RecipeBoard;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RecipeStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recipeStepId;

    @Column(nullable = false)
    private int stemNumber;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "recipeBoard_id")
    private RecipeBoard recipeBoard;

    public void setRecipeBoard(RecipeBoard recipeBoard) {
        this.recipeBoard = recipeBoard;
        if (recipeBoard.getRecipeSteps().contains(this)) {
            recipeBoard.setRecipeStep(this);
        }
    }
}
