package com.springboot.recipeboard.mapper;

import com.springboot.member.dto.MyRecipeBoardResponse;
import com.springboot.recipeboard.dto.RecipeBoardDto;
import com.springboot.recipeboard.entity.RecipeBoard;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface RecipeBoardMapper {
    RecipeBoard recipeBoardPostDtoToRecipeBoard(RecipeBoardDto.Post recipeBoardPostDto);
    RecipeBoard recipeBoardPatchDtoToRecipeBoard(RecipeBoardDto.Patch recipeBoardPatchDto);
    List<RecipeBoardDto.Response> recipeBoardsToRecipeBoardResponseDtos(List<RecipeBoard> recipeBoards);
    RecipeBoardDto.Response recipeBoardToRecipeBoardResponseDto(RecipeBoard recipeBoard);
    default MyRecipeBoardResponse recipeBoardToMyRecipeBoardResponse(RecipeBoard recipeBoard) {
        return MyRecipeBoardResponse.builder()
                .recipeBoardId(recipeBoard.getRecipeBoardId())
                .title(recipeBoard.getTitle())
                .menuName(recipeBoard.getMenuName())
                .image(recipeBoard.getImage())
                .likeCount(recipeBoard.getLikeCount())
                .ingredients(
                        recipeBoard.getRecipeBoardIngredients().stream()
                                .map(rbi -> rbi.getIngredient().getIngredientName())
                                .distinct()
                                .collect(Collectors.toList())
                )
                .build();
    }
}
