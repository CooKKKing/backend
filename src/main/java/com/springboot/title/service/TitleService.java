package com.springboot.title.service;

import com.springboot.title.entity.Title;
import com.springboot.title.repository.TitleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TitleService {
    private final TitleRepository titleRepository;

    public TitleService(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    public Page<Title> findTitles(int page, int size, Long memberId) {
        return titleRepository.findAll(PageRequest.of(page, size, Sort.by("titleId").ascending()));
    }
    public Page<Title> findOwnedTitles(int page, int size, Long memberId) {
        return titleRepository.findByMemberTitles_Member_MemberId(memberId, PageRequest.of(page, size, Sort.by("titleId").ascending()));
    }

    public Page<Title> findUnownedTitles(int page, int size, Long memberId) {
        return titleRepository.findTitlesNotOwnedByMember(memberId, PageRequest.of(page, size, Sort.by("titleId").ascending()));
    }
}