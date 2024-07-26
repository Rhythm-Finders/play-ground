package com.rhythmfinders.domain.member.service;

import com.rhythmfinders.domain.member.aggregate.Member;
import com.rhythmfinders.domain.member.aggregate.MemberLoginInfo;
import com.rhythmfinders.domain.member.aggregate.Role;
import com.rhythmfinders.domain.member.repository.MemberRepository;

import java.util.ArrayList;

public class MemberService {
    private MemberRepository memberRepository = new MemberRepository();

    public void signUp(Member newMember) {
        ArrayList<Member> memberList = memberRepository.loadMembers();

        try {
            newMember.setRole(Role.USER);
            newMember.setId(memberList.get(memberList.size()-1).getId() + 1);
            memberList.add(newMember);
            memberRepository.saveMembers(memberList);

            System.out.println("회원가입된 User의 정보는 : " + newMember);
            System.out.println("회원가입을 축하합니다");


        }
        catch (Exception e) {
            System.out.println("회원가입 실패");
            e.printStackTrace();
        }

        System.out.println("회원가입 실패");

    }

    public int login(MemberLoginInfo loginInfo) {

        ArrayList<Member> memberList = memberRepository.loadMembers();

        for(Member member : memberList) {
            if(member.getEmail().equals(loginInfo.getEmail()) && member.getPw().equals(loginInfo.getPw())){
                System.out.println("로그인 성공");
                return 1;
            }
        }

        System.out.println("로그인 실패");
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
