package com.springboot.member.service;

import com.springboot.auth.utils.AuthorityUtils;
import com.springboot.member.entity.Member;
import com.springboot.member.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityUtils authorityUtils;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder, AuthorityUtils authorityUtils) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityUtils = authorityUtils;
    }

    public Member createMember(Member member){
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        List<String> roles = authorityUtils.createAuthorities(member.getEmail());
        member.setRoles(roles);
        return memberRepository.save(member);
    }

    public Member updateMember() {
        return null;
    }
}