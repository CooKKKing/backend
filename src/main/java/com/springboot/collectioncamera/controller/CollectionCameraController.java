package com.springboot.collectioncamera.controller;

import com.springboot.collectioncamera.dto.CollectionDto;
import com.springboot.collectioncamera.dto.CollectionItemDto;
import com.springboot.collectioncamera.entity.CollectionCamera;
import com.springboot.collectioncamera.entity.CollectionItem;
import com.springboot.collectioncamera.mapper.CollectionMapper;
import com.springboot.collectioncamera.service.CollectionService;
import com.springboot.member.entity.Member;
import com.springboot.utils.UriCreator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "도감 컨트롤러", description = "도감 관련 컨트롤러")
@RestController
@RequestMapping("/collections")
@Validated
public class CollectionController {
    private static final String COLLECTION_DEFAULT_URL = "/collections";
    private final CollectionService collectionService;
    private final CollectionMapper mapper;

    public CollectionController(CollectionService collectionService, CollectionMapper mapper) {
        this.collectionService = collectionService;
        this.mapper = mapper;
    }

    @Operation(summary = "도감 카테고리 생성", description = "도감 카테고리를 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "도감 카테고리 생성 완료"),
            @ApiResponse(responseCode = "400", description = "Collection Validation failed")
    })
    @PostMapping
    public ResponseEntity postCollection(@Valid @RequestBody CollectionDto.Post collectionPostDto,
                                         @Parameter(hidden = true) @AuthenticationPrincipal Member member) {
        CollectionCamera collectionCamera = mapper.collectionPostDtoToCollection(collectionPostDto);

        CollectionCamera customCollectionCamera = collectionService.createCollection(collectionCamera, member.getMemberId());

        URI location = UriCreator.createUri(COLLECTION_DEFAULT_URL, customCollectionCamera.getCollectionId());

        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "도감 카테고리 수정", description = "도감 카테고리를 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "도감 카테고리 수정 완료"),
            @ApiResponse(responseCode = "400", description = "Collection Validation failed")
    })
    @PatchMapping("/{collection-id}")
    public ResponseEntity patchCollection(@PathVariable("collection-id") @Positive long collectionId,
                                          @Valid @RequestBody CollectionDto.Patch collectionPatchDto,
                                          @Parameter(hidden = true) @AuthenticationPrincipal Member member) {

        CollectionCamera collectionCamera = mapper.collectionPatchDtoToCollection(collectionId, collectionPatchDto);

        collectionService.updateCollection(collectionCamera, member.getMemberId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "도감 카테고리 전체 조회", description = "도감 카테고리를 전체 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "도감 카테고리 전체 조회 완료"),
            @ApiResponse(responseCode = "400", description = "Collection Validation failed")
    })
    @GetMapping
    public ResponseEntity getCollection(@Parameter(hidden = true) @AuthenticationPrincipal Member member) {
        // 도감 카테고리 전체 조회 로직 작성 해야함

        List<CollectionCamera> collectionCameras = collectionService.findCollections(member.getMemberId());
        List<CollectionDto.Response> response = collectionCameras.stream()
                .map(mapper::collectionToCollectionResponseDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "도감 카테고리 삭제", description = "도감 카테고리를 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "도감 카테고리 삭제 완료"),
            @ApiResponse(responseCode = "400", description = "Collection Validation failed")
    })
    @DeleteMapping("/{collection-id}")
    public ResponseEntity deleteCollection(@PathVariable("collection-id") @Positive long collectionId,
                                           @Parameter(hidden = true) @AuthenticationPrincipal Member member) {
        collectionService.deleteCollection(collectionId, member.getMemberId());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "도감 카테고리 내 메뉴 전체 조회", description = "도감 카테고리 내 메뉴들을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "도감 카테고리 내 메뉴 전체 조회 완료"),
            @ApiResponse(responseCode = "400", description = "Collection Validation failed")
    })
    @GetMapping("/{collection-id}/collectionitem")
    public ResponseEntity getCollectionItem(@PathVariable("collection-id") @Positive long collectionId,
                                            @Parameter(hidden = true) @AuthenticationPrincipal Member member) {
        List<CollectionItem> collectionItems = collectionService.findCollectionItems(collectionId, member.getMemberId());
        List<CollectionItemDto.Response> response = collectionItems.stream()
                .map(mapper::collectionItemToCollectionItemResponseDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "도감 카테고리 메뉴 추가", description = "도감 카테고리 메뉴를 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "도감 카테고리 메뉴 추가 완료"),
            @ApiResponse(responseCode = "400", description = "Collection Validation failed")
    })
    @PostMapping(value = "/{collection-id}/collectionitem", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity postCollectionItem(
            @PathVariable("collection-id") @Positive long collectionId,
            @RequestPart @Valid CollectionItemDto.Post collectionItemPostDto,
            @RequestPart(required = false) MultipartFile collectionItemImage,
            @Parameter(hidden = true) @AuthenticationPrincipal Member member) {

        CollectionItem collectionItem = mapper.collectionItemPostDtoToCollectionItem(collectionItemPostDto);

        CollectionItem postItem = collectionService.addCollectionItem(
                collectionId,
                collectionItem,
                collectionItemImage,
                member.getMemberId()
        );

        CollectionItemDto.Response response = mapper.collectionItemToCollectionItemResponseDto(postItem);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @Operation(summary = "도감 카테고리 메뉴 삭제", description = "도감 카테고리 메뉴를 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "도감 카테고리 메뉴 삭제 완료"),
            @ApiResponse(responseCode = "400", description = "Collection Validation failed")
    })
    @DeleteMapping("/collectionitems/{collectionitem-id}")
    public ResponseEntity deleteCollectionItem(@PathVariable("collectionitem-id") @Positive long collectionItemId,
                                               @Parameter(hidden = true) @AuthenticationPrincipal Member member) {
        collectionService.deleteCollectionItem(collectionItemId, member.getMemberId());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
