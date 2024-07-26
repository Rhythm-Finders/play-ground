package com.rhythmfinders.domain.member.service;

import com.rhythmfinders.domain.member.aggregate.*;
import com.rhythmfinders.domain.member.repository.MemberRepository;

import java.io.File;
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

    public void modifyMemberBy(Member modifyMember) {
        ArrayList<Member> memberList = memberRepository.loadMembers();

        for(int i = 0; i < memberList.size(); i++) {
            if(modifyMember.getId() == memberList.get(i).getId()){
                modifyMember.setEmail(memberList.get(i).getEmail());
                modifyMember.setRole(memberList.get(i).getRole());
                modifyMember.setFlag(memberList.get(i).isFlag());

                if(modifyMember.getNickname() == null)
                    modifyMember.setNickname(memberList.get(i).getNickname());

                if (modifyMember.getPw() == null)
                    modifyMember.setPw(memberList.get(i).getPw());

                if (modifyMember.getName() == null)
                    modifyMember.setName(memberList.get(i).getName());

                if (modifyMember.getAge() == 0)
                    modifyMember.setAge(memberList.get(i).getAge());

                if(modifyMember.getGender() == null)
                    modifyMember.setGender(memberList.get(i).getGender());

                if (modifyMember.getMyCategory() == null)
                    modifyMember.setMyCategory(memberList.get(i).getMyCategory());

                memberList.remove(i);
                memberList.add(i, modifyMember);
                memberRepository.saveMembers(memberList);
            }
        }

    }

    public void removeMemberBy(int memId) {
        ArrayList<Member> memberList = memberRepository.loadMembers();
        int code = 0;

        for (int i = 0; i < memberList.size(); i++) {
            if(memberList.get(i).getId() == memId) {
                System.out.println(memberList.remove(i));
                code = 1;
            }
        }
        
        memberRepository.saveMembers(memberList);
        
        if(code == 1) {
            System.out.println(memId + " 회원 삭제 완료");
            return;
        }

        System.out.println("회원 삭제 실패");

    }

    public int logout(int currentMemId) {
        ArrayList<Member> members = memberRepository.loadMembers();

        for(Member member : members) {
            if(member.getId() == currentMemId) {
                if(member.isFlag()){
                    member.setFlag(false);
                    return 1;
                }
            }
        }

        return 0;
    }

    public void findMemberBy(int memId) {
        ArrayList<Member> members = memberRepository.loadMembers();

        for(Member member : members){
            if(member.getId() == memId){
                System.out.println("id 값이 " + memId + "이신 회원분의 정보 : " + member);
                return;
            }
            System.out.println("찾으려는 회원 정보가 없습니다");
        }

    }

    public void findAllMember() {
        ArrayList<Member> members = memberRepository.loadMembers();

        for(Member member : members)
            System.out.println(member);

    }

}
