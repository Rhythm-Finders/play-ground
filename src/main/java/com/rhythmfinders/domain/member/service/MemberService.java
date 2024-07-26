package com.rhythmfinders.domain.member.service;

import com.rhythmfinders.domain.member.aggregate.*;
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

    public MemberLoginResponse login(MemberLoginInfo loginInfo) {

        ArrayList<Member> memberList = memberRepository.loadMembers();
        MemberLoginResponse memLoginResponse = new MemberLoginResponse();

        for(Member member : memberList) {
            if(member.getEmail().equals(loginInfo.getEmail()) && member.getPw().equals(loginInfo.getPw())){
                System.out.println("로그인 성공");
                member.setFlag(true);
                memberRepository.saveMembers(memberList);

                memLoginResponse.setMemId(member.getId());
                memLoginResponse.setMemRole(member.getRole().toString());
                memLoginResponse.setSucess(true);
                return memLoginResponse;
            }
        }

        System.out.println("로그인 실패");
        memLoginResponse.setSucess(false);
        return memLoginResponse;
    }

    public void findMemberEmail(MemberFindEmailInfo mfe) {
        ArrayList<Member> memberList = memberRepository.loadMembers();

        for(Member member : memberList) {
            if(member.getName().equals(mfe.getName()) && member.getNickname().equals(mfe.getNickname())){
                System.out.println("당신의 ID 값은 : " + member.getEmail());
                return;
            }
        }

        System.out.println("회원 정보가 없습니다");
    }

    public void findMemberPw(MemberFindPwInfo mfp) {
        ArrayList<Member> memberList = memberRepository.loadMembers();

        for(Member member : memberList) {
            if(member.getEmail().equals(mfp.getEmail()) && member.getName().equals(mfp.getName()) && member.getNickname().equals(mfp.getNickname())){
                System.out.println("당신의 pw 값은 : " + member.getPw());
                return;
            }
        }

        System.out.println("회원 정보가 없습니다");
    }

    public void modifyMemberBy() {
//        회원 정보를 끌고와서 flag
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
