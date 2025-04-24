package com.springboot.menucategory.mapper;

import com.springboot.menu.dto.MenuDto;
import com.springboot.menucategory.dto.MenuCategoryDto;
import com.springboot.menucategory.entity.MenuCategory;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MenuCategoryMapper {
    // DTO to Entity
    MenuCategory menuCategoryPostDtoToMenuCategory(MenuCategoryDto.Post post);
    MenuCategory menuCategoryPatchDtoToMenuCategory(MenuCategoryDto.Patch patch);

    // Entity to DTO
    default MenuCategoryDto.Response menuCategoryToMenuCategoryResponseDto(MenuCategory menuCategory) {
        if (menuCategory == null) {
            return null;
        }

        MenuCategoryDto.Response response = new MenuCategoryDto.Response();
        response.setMenuCategoryId(menuCategory.getMenuCategoryId());
        response.setMenuCategoryName(menuCategory.getMenuCategoryName());
        response.setMenus(menuCategory.getMenus().stream()
                .map(menu -> new MenuDto.SimpleResponse(
                        menu.getMenuId(),
                        menu.getMenuName()
                ))
                .collect(Collectors.toList()));
        return response;
    };

    List<MenuCategoryDto.Response> menuCategoriesToMenuCategoriesResponseDtos(List<MenuCategory> menuCategories);



}