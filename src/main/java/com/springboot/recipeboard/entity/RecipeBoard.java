package com.springboot.recipeboard.entity;

import com.springboot.audit.BaseEntity;
import com.springboot.bookmark.entitiy.Bookmark;
import com.springboot.member.entity.Member;
import com.springboot.menu.entity.Menu;
import com.springboot.recipestep.entity.RecipeStep;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RecipeBoard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recipeBoardId;

    @Column(nullable = false)
    private String title; // 레시피 게시글 제목

    @Column(nullable = false)
    private String menuName; // 음식 이름

    @Column(nullable = false)
    private String content; // 설명

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String recipeTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecipeStatus recipeStatus = RecipeStatus.RECIPE_PUBLIC;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecipeBoardStatus recipeBoardStatus = RecipeBoardStatus.RECIPE_BOARD_POST;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @OneToMany(mappedBy = "recipeBoard", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Bookmark> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "recipeBoard", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<RecipeStep> recipeSteps = new ArrayList<>();

    @OneToMany(mappedBy = "recipeBoard", cascade = CascadeType.PERSIST)
    private List<RecipeBoardIngredient> recipeBoardIngredients = new ArrayList<>();

    public void setMember(Member member) {
        this.member = member;
        if (!member.getRecipeBoards().contains(this)) {
            member.setRecipeBoard(this);
        }
    }

    public void setBookmark(Bookmark bookmark) {
        bookmarks.add(bookmark);
        if (bookmark.getRecipeBoard() != this) {
            bookmark.setRecipeBoard(this);
        }
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
        if (!menu.getRecipeBoards().contains(this)) {
            menu.setRecipeBoard(this);
        }
    }

    public void setRecipeStep(RecipeStep recipeStep) {
        recipeSteps.add(recipeStep);
        if (recipeStep.getRecipeBoard() != this) {
            recipeStep.setRecipeBoard(this);
        }
    }

    public void setRecipeBoardIngredient(RecipeBoardIngredient recipeBoardIngredient) {
        recipeBoardIngredients.add(recipeBoardIngredient);
        if (recipeBoardIngredient.getRecipeBoard() != this) {
            recipeBoardIngredient.setRecipeBoard(this);
        }
    }

    public enum RecipeStatus {
        RECIPE_PUBLIC("공개글"),
        RECIPE_PRIVATE("비밀글");

        @Getter
        private String status;

        RecipeStatus(String status) {
            this.status = status;
        }
    }

    public enum RecipeBoardStatus {
        RECIPE_BOARD_POST("게시글 등록 상태"),
        RECIPE_BOARD_DELETE("게시글 삭제 상태");

        @Getter
        private String status;

        RecipeBoardStatus(String status) {
            this.status = status;
        }
    }
}
