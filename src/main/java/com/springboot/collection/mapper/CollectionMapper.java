package com.springboot.collection.mapper;

import com.springboot.collection.dto.CollectionDto;
import com.springboot.collection.dto.CollectionItemDto;
import com.springboot.collection.entity.Collection;
import com.springboot.collection.entity.CollectionItem;
import com.springboot.recipeboard.dto.RecipeBoardDto;
import com.springboot.recipeboard.entity.RecipeBoard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CollectionMapper {
    @Mapping(source = "categoryName", target = "customCategoryName")
    Collection collectionPostDtoToCollection(CollectionDto.Post collectionPostDto);
    @Mapping(source = "collectionId", target = "collectionId")
    @Mapping(source = "collectionPatchDto.categoryName", target = "customCategoryName")
    Collection collectionPatchDtoToCollection(long collectionId, CollectionDto.Patch collectionPatchDto);
    List<CollectionDto.Response> collectionsToCollectionResponseDtos(List<Collection> collections);
    @Mapping(source = "customCategoryName", target = "categoryName")
    CollectionDto.Response collectionToCollectionResponseDto(Collection collection);
    @Mapping(source = "image", target = "imageUrl")
    CollectionItemDto.Response collectionItemToCollectionItemResponseDto(CollectionItem entity);
    CollectionItem collectionItemPostDtoToCollectionItem(CollectionItemDto.Post dto);
}
