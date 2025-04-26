package com.springboot.recipeboard.service;

import com.springboot.bookmark.entitiy.Bookmark;
import com.springboot.bookmark.repository.BookmarkRepository;
import com.springboot.exception.BusinessLogicException;
import com.springboot.exception.ExceptionCode;
import com.springboot.ingredient.entity.Ingredient;
import com.springboot.ingredient.entity.MainIngredient;
import com.springboot.ingredient.repository.IngredientRepository;
import com.springboot.member.entity.Member;
import com.springboot.member.repository.MemberRepository;
import com.springboot.menu.entity.Menu;
import com.springboot.menu.repository.MenuRepository;
import com.springboot.recipeboard.entity.Like;
import com.springboot.recipeboard.entity.RecipeBoard;
import com.springboot.recipeboard.repository.LikeRepository;
import com.springboot.recipeboard.repository.RecipeBoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeBoardService {
    private final MemberRepository memberRepository;
    private final MenuRepository menuRepository;
    private final IngredientRepository ingredientRepository;
    private final RecipeBoardRepository recipeBoardRepository;
    private final BookmarkRepository bookmarkRepository;
    private final LikeRepository likeRepository;

    public RecipeBoardService(MemberRepository memberRepository, MenuRepository menuRepository, IngredientRepository ingredientRepository, RecipeBoardRepository recipeBoardRepository, BookmarkRepository bookmarkRepository, LikeRepository likeRepository) {
        this.memberRepository = memberRepository;
        this.menuRepository = menuRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeBoardRepository = recipeBoardRepository;
        this.bookmarkRepository = bookmarkRepository;
        this.likeRepository = likeRepository;
    }

    // 게시글 등록
    public RecipeBoard createRecipeBoard(RecipeBoard recipeBoard) {
        // 메인 재료 개수 검증
        verifyMainIngredientCount(recipeBoard);
        // 메뉴 존재 여부 검증
        // 있다면 영속화, 없다면 새로 생성 후 영속화
        Menu menu = menuExists(recipeBoard.getMenu().getMenuName());
        recipeBoard.setMenu(menu);
        // 회원 존재 여부 검증
        verifyMemberExists(recipeBoard.getMember().getMemberId());

        // TODO: 칭호를 위한 기능 아래 추가 필요합니다.

        return recipeBoardRepository.save(recipeBoard);
    }

    // 게시글 수정
    public RecipeBoard updateRecipeBoard(RecipeBoard recipeBoard, Long memberId) {
        // 게시글 존재 여부 검증
        RecipeBoard existingRecipeBoard = verifyRecipeBoardExists(recipeBoard.getRecipeBoardId());
        // 비공개 게시글 접근 권한 검증
        verifyCanAccessPrivate(existingRecipeBoard, memberId);
        // 메인 재료 개수 검증
        verifyMainIngredientCount(recipeBoard);

        // 아레 코드 제네릭 이용해서 리팩토링 필요합니다.
        Optional.ofNullable(recipeBoard.getRecipeStatus()).ifPresent(status -> {
            if (status != null) {
                existingRecipeBoard.setRecipeStatus(status);
            }
        });

        Optional.ofNullable(recipeBoard.getRecipeBoardStatus()).ifPresent(status -> {
            if (status != null) {
                existingRecipeBoard.setRecipeBoardStatus(status);
            }
        });
        Optional.ofNullable(recipeBoard.getImage()).ifPresent(image -> {
            if (image != null) {
                existingRecipeBoard.setImage(image);
            }
        });
        Optional.ofNullable(recipeBoard.getTitle()).ifPresent(title -> {
            if (title != null) {
                existingRecipeBoard.setTitle(title);
            }
        });

        Optional.ofNullable(recipeBoard.getRecipeBoardIngredients()).ifPresent(ingredients -> {
            if (ingredients != null) {
                existingRecipeBoard.setRecipeBoardIngredients(ingredients);
            }
        });

        Optional.ofNullable(recipeBoard.getRecipeBoardSteps()).ifPresent(steps -> {
            if (steps != null) {
                existingRecipeBoard.setRecipeBoardSteps(steps);
            }
        });

        return recipeBoardRepository.save(recipeBoard);
    }

    // 게시글 단일 조회
    public RecipeBoard findRecipeBoard(long recipeBoardId) {
        // 게시글 존재 여부 검증
        RecipeBoard recipeBoard = verifyRecipeBoardExists(recipeBoardId);
        // 비공개 게시글 접근 권한 검증
        verifyCanAccessPrivate(recipeBoard, recipeBoard.getMember().getMemberId());

        return recipeBoard;
    }

    // 게시글 삭제
    public void deleteRecipeBoard(long recipeBoardId) {
        // 게시글 존재 여부 검증
        RecipeBoard recipeBoard = verifyRecipeBoardExists(recipeBoardId);
        // 비공개 게시글 접근 권한 검증
        verifyCanAccessPrivate(recipeBoard, recipeBoard.getMember().getMemberId());

        recipeBoardRepository.delete(recipeBoard);
    }

    // 카테고리별 레시피 게시글 전체 조회
    public Page<RecipeBoard> findCategoryRecipeBoards(int page, int size, long categoryId) {
        return recipeBoardRepository.findByMenu_MenuCategory_MenuCategoryId(categoryId, PageRequest.of(page, size, Sort.by("recipeBoardId").descending()));
    }

    // 메뉴별 레시피 게시글 전체 조회
    public Page<RecipeBoard> findMenuRecipeBoards(int page, int size, long menuId) {
        return recipeBoardRepository.findByMenu_MenuId(menuId, PageRequest.of(page, size, Sort.by("recipeBoardId").descending()));
    }

    // 레시피 게시글 북마크 추가/해제
    public void toggleBookmark(long recipeBoardId, long memberId) {
        // 게시글 존재 여부 검증
        RecipeBoard recipeBoard = verifyRecipeBoardExists(recipeBoardId);
        // 회원 존재 여부 검증
        verifyMemberExists(memberId);

        Optional<Bookmark> findBookmark = bookmarkRepository.findByMember_MemberIdAndRecipeBoard_RecipeBoardId(memberId, recipeBoardId);

        if (findBookmark.isPresent()) {
            // 북마크가 존재하면 삭제
            bookmarkRepository.delete(findBookmark.get());
        } else {
            // 북마크가 존재하지 않으면 추가
            Bookmark bookmark = new Bookmark();
            Member member = new Member();
            member.setMemberId(memberId);
            bookmark.setMember(member);
            bookmark.setRecipeBoard(recipeBoard);

            bookmarkRepository.save(bookmark);
        }
    }

    // 레시피 게시글 좋아요 추가/해제
    public void toggleLike(long recipeBoardId, long memberId) {
        // 게시글 존재 여부 검증
        RecipeBoard recipeBoard = verifyRecipeBoardExists(recipeBoardId);
        // 회원 존재 여부 검증
        verifyMemberExists(memberId);

        Optional<Like> findLike = likeRepository.findByMember_MemberIdAndRecipeBoard_RecipeBoardId(memberId, recipeBoardId);

        if (findLike.isPresent()) {
            // 좋아요가 존재하면 삭제
            likeRepository.delete(findLike.get());
        } else {
            // 좋아요가 존재하지 않으면 추가
            Like like = new Like();
            Member member = new Member();
            member.setMemberId(memberId);
            like.setMember(member);
            like.setRecipeBoard(recipeBoard);

            likeRepository.save(like);
        }
    }

    // 레시피 게시글 검색
    public Page<RecipeBoard> recipeBoardSearch(long recipeBoardId, long memberId, String keyword) {
        return null;
    }

    // 회원 존재 여부 검증
    private Member verifyMemberExists(long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    // 메뉴 존재 여부 검증
//    private void verifyMenuExists(Menu menu) {
//        if(menu == null) {
//            throw new BusinessLogicException(ExceptionCode.MENU_NOT_FOUND);
//        }
//        return menuRepository.findById(menu.getMenuId())
//                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MENU_NOT_FOUND));
//    }

    private Menu menuExists(String menuName) {
        return menuRepository.findByMenuName(menuName)
                .orElseGet(() -> {
                    Menu newMenu = new Menu();
                    newMenu.setMenuName(menuName);
                    return menuRepository.save(newMenu); // 영속 상태로 만들어서 반환
                });
    }

    // 게시글 존재 여부 검증
    private RecipeBoard verifyRecipeBoardExists(long recipeBoardId) {
        return recipeBoardRepository.findById(recipeBoardId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.RECIPEBOARD_NOT_FOUND));
    }

    // 게시글 작성자인지 검증
    private void verifyIsOwner(RecipeBoard recipeBoard, long memberId) {
        if (recipeBoard.getMember().getMemberId() != memberId) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_MATCH);
        }
    }

    // 비공개 게시글 접근 권한 검증
    private void verifyCanAccessPrivate(RecipeBoard recipeBoard, long memberId) {
        if (recipeBoard.getRecipeStatus() == RecipeBoard.RecipeStatus.RECIPE_PRIVATE ) {
            if (recipeBoard.getMember().getMemberId() != memberId) {
                throw new BusinessLogicException(ExceptionCode.UNAUTHORIZED_ACCESS);
            }
        }
    }

    // 검색 키워드 유효성 검증
    private void verifySearchKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            throw new BusinessLogicException(ExceptionCode.INVALID_KEYWORD);
        }
    }

    // 주 재료가 2개 이상인 경우 검증, 입력된 재료의 타입이 잘 맞는지도 동시에 검증.
    private void verifyMainIngredientCount(RecipeBoard recipeBoard) {
        long mainIngredientCount = recipeBoard.getRecipeBoardIngredients().stream()
                .filter(ingredient -> ingredient.getIngredient() instanceof MainIngredient)
                .count();

        recipeBoard.getRecipeBoardIngredients().stream()
                .forEach(ingredient -> {
                    verifyIngredientExists(ingredient.getIngredient());
                });
        if (mainIngredientCount < 2) {
            throw new BusinessLogicException(ExceptionCode.INSUFFICIENT_MAIN_INGREDIENTS);
        }
    }

    // 재료 존재 여부 검증
    private void verifyIngredientExists(Ingredient ingredient) {
        long ingredientId = ingredient.getIngredientId();

        Ingredient existingIngredient = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.INGREDIENT_NOT_FOUND));

        String inputDtype = ingredient instanceof MainIngredient ? "MAIN" : "SEASONING";

        if(inputDtype.equals("MAIN")) {
            if (!(existingIngredient instanceof MainIngredient)) {
                throw new BusinessLogicException(ExceptionCode.INGREDIENT_NOT_FOUND);
            }
        } else {
            if (existingIngredient instanceof MainIngredient) {
                throw new BusinessLogicException(ExceptionCode.INGREDIENT_NOT_FOUND);
            }
        }
    }

}