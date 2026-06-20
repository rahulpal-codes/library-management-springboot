package com.rahul.library_management.service;

import java.util.List;

import com.rahul.library_management.entity.Member;

public interface MemberService {
    Member addMember(Member member);
    List<Member> getAllMembers();
    Member getMemberById(Long id);
    void deleteMember(Long id);
}