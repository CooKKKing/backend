package com.springboot.collection.repository;

import com.springboot.collection.dto.CollectionItemDto;
import com.springboot.collection.entity.Collection;
import com.springboot.collection.entity.CollectionItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionItemRepository extends JpaRepository<CollectionItem, Long> {
    List<CollectionItem> findByCollection(Collection collection);
}
