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
        if (result == 1) {
            System.out.println("고객님 로그인에 성공하셨습니다.");
        } else if (result == 2) {
            System.out.println("관리자님 로그인에 성공하셨습니다.");
        } else {
            System.out.println("로그인 실패!");
        }
        return result;
    }

    public void findEmail(int memNo) {
        Member selectMember = mr.findId(memNo);
        if (selectMember != null) {
            System.out.println("Id = " + selectMember.getEmail());
        } else {
            System.out.println("조회된 아이디가 없습니다.");
        }
    }

    public void findpw(int memNo) {
        Member selectMember = mr.findId(memNo);
        if (selectMember != null) {
            System.out.println("Password = " + selectMember.getPassword());
        } else {
            System.out.println("조회된 이메일의 비밀번호가 없습니다.");
        }
    }

    public void modifyUserInfo(String[][] val) {
        int n = 0;
        String s = "";
        switch (val[0][0]) {
            case "1":
                n = mr.modifyNickName(val[1]);
                s = (n == 1) ? "Nickname이 변경 되었습니다." : "Password이 변경되지 않았습니다.";
                System.out.println(s);
                break;
            case "2":
                n = mr.modifyPassword(val[1]);
                s = (n == 1) ? "Password이 변경 되었습니다." : "Password이 변경되지 않았습니다.";
                System.out.println(s);
                break;
            case "3":
                n = mr.modifyMyCategory(val[1]);
                System.out.println("나의 카테고리가 변경되었습니다.");
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
        }
    }

    public void resignUser(int n) {
        int result = mr.deleteMember(n);
        if (result == 1) {
            System.out.println("회원번호" + n + "님 다시돌아오세요~");
        }else{
            System.out.println("회원번호" + n + "님을 찾을 수 없습니다.");
        }
    }

    public void logout(int memNo) {
        int result = mr.logoutMember(memNo);
        if (result == 1) {
            System.out.println("로그아웃을 진행합니다.");
        }else{
            System.out.println("로그아웃을 미룹니다.");
        }
    }

    public void showOneMember(int memNo) {
        int result = mr.findOneMember(memNo);
        if (result == 1) {
            System.out.println("잘 확인 되셨겠죠 후후..");
        }else{
            System.out.println("입력한 정보가 없습니다.");
        }
    }

    public void showAllMember() {
        int result = mr.findAllMember();
        if (result == 1) {
            System.out.println("잘 확인 되셨겠죠 후후..");
        }else{
            System.out.println("아무런 회원이 없네요 ㅠㅠ");
        }
    }

    public void deleteMember(int memNo) {
        int result = mr.deleteMember(memNo);
        if (result == 1) {
            System.out.println("그 회원이 삭제 되었습니다.");
        }else{
            System.out.println("입력하신 회원이 없네요.");
        }
    }
}
