package com.rhythmfinders.domain.member;

import com.rhythmfinders.domain.member.service.MemberService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLData;

public class Application {

    private static final MemberService memberService = new MemberService();

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("===== 회원 관리 프로그램 =====");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 아이디 찾기");
            System.out.println("4. 비밀번호 찾기");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요 : ");

            int input = 0;

            try {
                input = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (input){
                case 1:
                    memberService.signUp();
                    break;
                case 2:
                    int result = memberService.login();

                    if(result == 1)
                        showAdmin();
                    else if(result == 2)
                        showUser();



                    break;
                case 3:
                    memberService.findMemberId();
                    break;
                case 4:
                    memberService.findMemberPw();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다");
                    return;
                default:
                    System.out.println("번호를 잘못 입력했습니다");
            }
        }
    }

    private static void showUser() {
        BufferedReader brUser = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("===== 회원 관리 프로그램 =====");
            System.out.println("1. 회원 정보 수정");
            System.out.println("2. 회원 탈퇴");
            System.out.println("3. 로그아웃");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요 : ");

            int input = 0;

            try {
                input = Integer.parseInt(brUser.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (input){
                case 1:
                    memberService.modifyMemberBy();
                    break;
                case 2:
                    memberService.removeMemberBy();
                    break;
                case 3:
                    int i = memberService.logout();

                    if(i == 1)
                        return;
                    System.out.println("logout 실패");
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
                default:
                    System.out.println("번호를 잘못 입력했습니다");
            }
        }

    }

    private static void showAdmin() {
        BufferedReader brAdimin = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("===== 회원 관리 프로그램 =====");
            System.out.println("1. 회원 단일 조회");
            System.out.println("2. 회원 전체 조회");
            System.out.println("3. 회원 삭제");
            System.out.println("4. 로그아웃");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요 : ");

            int input = 0;

            try {
                input = Integer.parseInt(brAdimin.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (input){
                case 1:
                    memberService.findMemberBy();
                    break;
                case 2:
                    memberService.findMemberAll();
                    break;
                case 3:
                    memberService.removeMemberBy();
                    break;
                case 4:
                    int i = memberService.logout();
                    
                    if(i == 1)
                        return;
                    System.out.println("logout 실패");
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
                default:
                    System.out.println("번호를 잘못 입력했습니다");
            }
        }
        
    }
}
