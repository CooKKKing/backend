package com.springboot.collection.service;

import com.springboot.collection.entity.Collection;
import com.springboot.collection.entity.CollectionItem;
import com.springboot.collection.repository.CollectionItemRepository;
import com.springboot.collection.repository.CollectionRepository;
import com.springboot.exception.BusinessLogicException;
import com.springboot.exception.ExceptionCode;
import com.springboot.file.Service.StorageService;
import com.springboot.member.entity.Member;
import com.springboot.member.repository.MemberRepository;
import com.springboot.member.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CollectionService {
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final CollectionRepository collectionRepository;
    private final CollectionItemRepository collectionItemRepository;
    private final StorageService storageService;

    public CollectionService(MemberService memberService, MemberRepository memberRepository, CollectionRepository collectionRepository, CollectionItemRepository collectionItemRepository, StorageService storageService) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
        this.collectionRepository = collectionRepository;
        this.collectionItemRepository = collectionItemRepository;
        this.storageService = storageService;
    }


    // 도감 카테고리 생성
    public Collection createCollection(Collection collection, long memberId) {
        Member member = memberService.findMember(memberId);

        // 도감 카테고리명 중복 검증
        if (collectionRepository.existsByMemberAndCustomCategoryName(member, collection.getCustomCategoryName())) {
            throw new BusinessLogicException(ExceptionCode.DUPLICATE_COLLECTION_CATEGORY);
        }

        collection.setMember(member);
        return collectionRepository.save(collection);
    }

    // 도감 카테고리 수정
    public Collection updateCollection(Collection collection, long memberId) {
        Collection existing = verifyOwnedCollection(collection.getCollectionId(), memberId);

        boolean isDuplicate = collectionRepository.existsByCustomCategoryNameAndMember_MemberId(
                collection.getCustomCategoryName(), memberId);

        if (isDuplicate && !existing.getCustomCategoryName().equals(collection.getCustomCategoryName())) {
            throw new BusinessLogicException(ExceptionCode.DUPLICATE_COLLECTION_CATEGORY);
        }

        existing.setCustomCategoryName(collection.getCustomCategoryName());
        return collectionRepository.save(existing);
    }

    // 도감 카테고리 전체 조회
    public List<Collection> findCollections(long memberId) {
        Member member = verifyMemberExists(memberId);
        return collectionRepository.findByMember(member);
    }

    // 도감 카테고리 삭제
    public void deleteCollection(long collectionId, long memberId) {
        Collection collection = verifyOwnedCollection(collectionId, memberId); // 존재 + 소유자 검증
        collectionRepository.delete(collection);
    }

    // 도감 카테고리 내 메뉴 목록 조회
    public List<CollectionItem> findCollectionItems(long collectionId, long memberId) {
        Collection collection = verifyOwnedCollection(collectionId, memberId); // 소유자 확인까지 포함
        return collectionItemRepository.findByCollection(collection);
    }

    // 도감 카테고리 메뉴 추가
    public CollectionItem addCollectionItem(long collectionId, CollectionItem collectionItem, MultipartFile image, long memberId) {
        Collection collection = verifyOwnedCollection(collectionId, memberId); // 도감 소유자 검증

        // 중복 메뉴 이름 검증
        boolean isDuplicate = collection.getCollectionItems().stream()
                .anyMatch(item -> item.getMenuName().equals(collectionItem.getMenuName()));
        if (isDuplicate) {
            throw new BusinessLogicException(ExceptionCode.DUPLICATE_COLLECTION_MENU);
        }

        if (image == null || image.isEmpty()) {
            throw new BusinessLogicException(ExceptionCode.IMAGE_REQUIRED);
        }

        String pathWithoutExt = "collections/" + collection.getCollectionId() + "/item_" + System.currentTimeMillis();
        String imageUrl = storageService.store(image, pathWithoutExt);
        collectionItem.setImage(imageUrl);

        collectionItem.setCollection(collection); // 소속 설정
        return collectionItemRepository.save(collectionItem);
    }

    // 도감 카테고리 메뉴 삭제
    public void deleteCollectionItem(long collectionItemId, long memberId) {
        CollectionItem item = verifyCollectionItemExists(collectionItemId);
        verifyCollectionItemOwner(item.getCollection(), memberId);
        collectionItemRepository.delete(item);
    }

    // 회원 존재 확인
    public Member verifyMemberExists(long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    // 도감 존재 확인
    public Collection verifyCollectionExists(long collectionId) {
        return collectionRepository.findById(collectionId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COLLECTION_NOT_FOUND));
    }

    // 도감 소유자 검증
    public void verifyCollectionOwner(Collection collection, long memberId) {
        if (collection.getMember().getMemberId() != memberId) {
            throw new BusinessLogicException(ExceptionCode.UNAUTHORIZED_ACCESS);
        }
    }

    // 도감 + 소유자 한 번에 검증
    public Collection verifyOwnedCollection(long collectionId, long memberId) {
        Collection collection = verifyCollectionExists(collectionId);
        verifyCollectionOwner(collection, memberId);
        return collection;
    }

    // 도감 메뉴 존재 확인
    public CollectionItem verifyCollectionItemExists(long collectionItemId) {
        return collectionItemRepository.findById(collectionItemId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COLLECTION_ITEM_NOT_FOUND));
    }

    // 도감 메뉴 소유자 확인
    public void verifyCollectionItemOwner(Collection collection, long memberId) {
        if (collection.getMember().getMemberId() != memberId) {
            throw new BusinessLogicException(ExceptionCode.UNAUTHORIZED_ACCESS);
        }
    }
}

