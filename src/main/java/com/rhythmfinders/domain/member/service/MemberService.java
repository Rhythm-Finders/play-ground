package com.rhythmfinders.domain.member.service;

import com.rhythmfinders.domain.member.aggregate.Member;
import com.rhythmfinders.domain.member.repository.MemberRepository;

import java.util.ArrayList;

public class MemberService {
    private MemberRepository memberRepository = new MemberRepository();

    public void signUp(Member newMember) {
        int result = memberRepository.saveMember(newMember);
        
        if (result == 1)
            System.out.println("회원가입을 축하합니다");
        else
            System.out.println("회원가입 실패");
    }

    public int login() {
        return 0;
    }

    public void findMemberId() {
    }

    public void findMemberPw() {
    }

    public void modifyMemberBy() {
    }

    public void removeMemberBy() {
    }

    public int logout() {
        return 0;
    }

    public void findMemberBy() {
    }

    public void findAllMember() {
        ArrayList<Member> members = memberRepository.selectAllMember();

        for(Member member : members)
            System.out.println(member);

    }
}
