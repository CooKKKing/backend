package com.springboot.collectioncamera.mapper;

import com.springboot.collectioncamera.dto.CollectionDto;
import com.springboot.collectioncamera.dto.CollectionItemDto;
import com.springboot.collectioncamera.entity.CollectionCamera;
import com.springboot.collectioncamera.entity.CollectionItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CollectionMapper {
    @Mapping(source = "categoryName", target = "customCategoryName")
    CollectionCamera collectionPostDtoToCollection(CollectionDto.Post collectionPostDto);
    @Mapping(source = "collectionId", target = "collectionId")
    @Mapping(source = "collectionPatchDto.categoryName", target = "customCategoryName")
    CollectionCamera collectionPatchDtoToCollection(long collectionId, CollectionDto.Patch collectionPatchDto);
    List<CollectionDto.Response> collectionsToCollectionResponseDtos(List<CollectionCamera> collectionCameras);
    @Mapping(source = "customCategoryName", target = "categoryName")
    CollectionDto.Response collectionToCollectionResponseDto(CollectionCamera collectionCamera);
    @Mapping(source = "image", target = "imageUrl")
    CollectionItemDto.Response collectionItemToCollectionItemResponseDto(CollectionItem entity);
    CollectionItem collectionItemPostDtoToCollectionItem(CollectionItemDto.Post dto);
}
