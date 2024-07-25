package com.rhythmfinders.domain.member.service;

import com.rhythmfinders.domain.member.aggregate.Member;
import com.rhythmfinders.domain.member.repository.MemberRepository;

import java.util.ArrayList;

public class MemberService {
    private final MemberRepository mr = new MemberRepository();

    public MemberService() {
    }

    public void findAllMember() {
        ArrayList<Member> viewMembers = mr.selectAllMembers();

        for (Member mem : viewMembers) {
            System.out.println("mem = " + mem);
        }
    }

    public void registMember(Member newMember) {
        int lastMemberNo = mr.selectLastMemberNo();
        newMember.setId(lastMemberNo + 1);
        if (mr.insertMember(newMember) == 1) {
            System.out.println(newMember.getId() + "님 회원가입을 축하드립니다~");
        } else {
            System.out.println("회원가입 실패..");
        }
    }

    public int login(String[] ePw) {
        int result = mr.login(ePw);
        if(result==1){
            System.out.println("고객님 로그인에 성공하셨습니다.");
        }else if(result==2){
            System.out.println("관리자님 로그인에 성공하셨습니다.");
        }else{
            System.out.println("로그인 실패!");
        }
        return result;
    }

    public void findId(int memNo) {
        Member selectMember = mr.findId(memNo);
        if(selectMember != null){
            System.out.println("Id = " + selectMember.getId());
        }else{
            System.out.println("조회된 아이디가 없습니다.");
        }
    }

    public void findpw(int memNo) {
        Member selectMember = mr.findId(memNo);
        if(selectMember != null){
            System.out.println("Password = " + selectMember.getPassword());
        }else{
            System.out.println("조회된 이메일의 비밀번호가 없습니다.");
        }
    }

    public void modifyUserInfo(int num) {

        switch (num){
            case 1:
                mr.modifyNickName();
                break;
            case 2:
                mr.modifyPassword()
                break;
            case 3:
                mr.modifyMyCategory();
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
        }
    }
}
