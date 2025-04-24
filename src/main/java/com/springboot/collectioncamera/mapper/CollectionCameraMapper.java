package com.springboot.collectioncamera.mapper;

import com.springboot.collectioncamera.dto.CollectionCameraDto;
import com.springboot.collectioncamera.dto.CollectionItemDto;
import com.springboot.collectioncamera.entity.CameraImage;
import com.springboot.collectioncamera.entity.CollectionCamera;
import com.springboot.collectioncamera.entity.CollectionItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CollectionCameraMapper {
    CollectionCamera collectionCameraPostDtoToCollectionCamera(CollectionCameraDto.Post Dto);
    List<CollectionCameraDto.Response> collectionsToCollectionResponseDtos(List<CollectionCamera> collectionCameras);
    @Mapping(target = "imageUrl", expression = "java(mapCameraImage(collectionCamera))")
    CollectionCameraDto.Response collectionCameraToCollectionCameraResponseDto(CollectionCamera collectionCamera);
    CollectionItemDto.Response collectionItemToCollectionItemResponseDto(CollectionItem entity);
    CollectionItem collectionItemPostDtoToCollectionItem(CollectionItemDto.Post dto);
    List<CollectionCameraDto.ResponseImage> cameraImagesToCameraImageResponseDtos(List<CameraImage> cameraImages);


    default String mapCameraImage(CollectionCamera collectionCamera) {
        if (collectionCamera.getCameraImage() != null) {
            return collectionCamera.getCameraImage().getImageUrl();
        } else {
            return null; // 이미지 없으면 null
        }
    }
}
