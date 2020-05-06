package com.briup.sports.service.impl;

import com.briup.sports.bean.Member;
import com.briup.sports.bean.MemberExample;
import com.briup.sports.mapper.MemberMapper;
import com.briup.sports.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member findMemberById(Long id) {

        MemberExample example1 = new MemberExample();
        MemberExample.Criteria c = example1.createCriteria().andMemberIdEqualTo(id.intValue());
//        System.out.println(memberMapper+"========");
        List<Member> members = memberMapper.selectByExample(example1);
        System.out.println("members="+members);
        if (members.size()==0){
            System.out.println("这里是null");
            return null;
        }else{
            System.out.println("members不为null"+members);
            return members.get(0);
        }
    }

    @Override
    public void updateMember(Member member) {


        MemberExample example2 = new MemberExample();
        MemberExample.Criteria c = example2.createCriteria().andMemberIdEqualTo(member.getMemberId());
        int i = memberMapper.updateByExample(member, example2);
    }

    @Override
    public int insertMember(Member member){
        System.out.println(member.toString());
        int i = memberMapper.insert(member);
        System.out.println("i="+i+"insert成功");

        return i;
    }

    @Override
    public List<Member> findAllMemberByRole(String role) {
        MemberExample example = new MemberExample();
        example.createCriteria().andRoleIdEqualTo(Integer.parseInt(role));
        List<Member> members = memberMapper.selectByExample(example);
        return members;
    }

    @Override
    public void deleteByMemberId(Integer id) {
        MemberExample example = new MemberExample();
        example.createCriteria().andMemberIdEqualTo(id);
        memberMapper.deleteByExample(example);
        System.out.println("删除成功");
    }
}
