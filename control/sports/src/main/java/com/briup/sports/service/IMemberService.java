package com.briup.sports.service;

import com.briup.sports.bean.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMemberService {
    public Member findMemberById(Long id);

    public void updateMember(Member member);

    public int insertMember(Member member);

    public List<Member> findAllMemberByRole(String role);

    public void deleteByMemberId(Integer id);
}
