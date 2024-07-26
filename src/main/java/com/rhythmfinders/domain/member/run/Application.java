package com.rhythmfinders.domain.member.run;

import com.rhythmfinders.domain.member.aggregate.Gender;
import com.rhythmfinders.domain.member.aggregate.Member;
import com.rhythmfinders.domain.member.aggregate.Role;
import com.rhythmfinders.domain.member.service.MemberService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    private static final MemberService ms = new MemberService();
    public static int memNo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("=====로그인 화면=====");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 아이디 찾기");
            System.out.println("4. 비밀번호 찾기");
            System.out.println("9. 프로그램 종료");
            System.out.print("위 메뉴의 번호를 입력하시오.");
            int input = Integer.valueOf(br.readLine());

            switch (input) {
                case 1:
                    ms.registMember(signUp());
                    break;
                case 2:
                    int r = ms.login(checkEPw());
                    secondPage(r);
                    break;
                case 3:
                    ms.findEmail(checkUserNo());
                    break;
                case 4:
                    ms.findpw(checkUserEmailNo());
                    break;
                case 9:
                    System.out.println("회원관리 프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
                    break;
            }


        }
    }

    private static void secondPage(int r) throws IOException {
        if (r == 1) {
            UserPage();
        } else if (r == 2) {
            AdminPage();
        }
    }

    private static void AdminPage() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("=====관리자 화면=====");
            System.out.println("1. 회원 단일 조회");
            System.out.println("2. 회원 전체 조회");
            System.out.println("3. 회원 삭제");
            System.out.println("9. 로그아웃");
            System.out.print("위 메뉴의 번호를 입력하시오.");

            int input = Integer.valueOf(br.readLine());

            switch (input) {
                case 1:
                    ms.showOneMember(checkUserNo());
                    break;
                case 2:
                    ms.showAllMember();
                    break;
                case 3:
                    ms.deleteMember(checkUserNo());
                    break;
                case 9:
                    ms.logout(memNo);
                    System.out.println("로그아웃 합니다.");
                    return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
                    break;
            }


        }
    }

    private static void UserPage() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("=====User 화면=====");
            System.out.println("1. 회원 정보 수정");
            System.out.println("2. 회원 탈퇴");
            System.out.println("3. 게시판");
            System.out.println("4. Product");
            System.out.println("9. 로그아웃");
            System.out.print("위 메뉴의 번호를 입력하시오.");

            String input = br.readLine();

            switch (input) {
                case "1":
                    ms.modifyUserInfo(selectModifyInto());
                    break;
                case "2":
                    ms.resignUser(memNo);
                    break;
                case "9":
                    ms.logout(memNo);
                    return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
                    break;
            }


        }
    }

    // 여기부터 재시작할 것(회원 로그인후 어떻게 처리할지 논의후 진행)
    private static String[][] selectModifyInto() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] a = new String[2][];
        System.out.println("1: 별칭");
        System.out.println("2: 비밀번호");
        System.out.println("3: 나의 카테고리");
        System.out.print("수정하고 싶으신 정보의 번호를 입력해주세요.");
        a[0] = new String[1];
        a[0][0] = br.readLine().trim();
        if (a[0][0].equals("1") || a[0][0].equals("2")) {
            System.out.println("변경하실 것을 입력해주세요.");
            a[1] = new String[1];
            a[1][0] = br.readLine().trim();
        } else if (a[0][0].equals("3")) {
            System.out.println("총 몇 개로 수정하시겠습니까?");
            int T = Integer.valueOf(br.readLine().trim());
            a[1] = new String[T];
            for (int i = 0; i < T; i++) {
                a[1][i] = br.readLine().trim();
            }
        } else {
            System.out.println("잘못 입력하셨습니다.");
        }

        return a;
    }


    private static int checkUserEmailNo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("=====FindPassword Page=====");
        System.out.print("회원 번호를 입력하시오.");
        int num = Integer.valueOf(br.readLine());
        System.out.print("회원 email을 입력하시오.");
        String email = br.readLine();

        return num;
    }

    private static int checkUserNo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("=====FindId Page=====");
        System.out.print("회원 번호를 입력하시오.");
        int num = Integer.valueOf(br.readLine());
        return num;
    }


    private static String[] checkEPw() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("=====Login Page=====");
        System.out.print("email를 입력하시오.");
        String email = br.readLine();
        System.out.print("password를 입력하시오.");
        String password = br.readLine();
        String[] ePw = {email, password};
        return ePw;
    }

    private static Member signUp() throws IOException {
        Member newMember = new Member();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("====회원가입 페이지====");
        System.out.print("닉네임을 입력하세요: ");
        newMember.setNickname(br.readLine().trim());

        System.out.print("email을 입력하세요: ");
        newMember.setEmail(br.readLine().trim());

        System.out.print("비밀번호를 입력하세요: ");
        newMember.setPassword(br.readLine().trim());

        System.out.print("성함을 입력하세요: ");
        newMember.setName(br.readLine().trim());

        System.out.print("나이를 입력하세요: ");
        newMember.setAge(Integer.valueOf(br.readLine().trim()));

        System.out.print("성별을 입력하시오.(M, F)");
        String gender = br.readLine().trim().toUpperCase();
        switch (gender) {
            case "M":
                newMember.setGender(Gender.M);
            case "F":
                newMember.setGender(Gender.F);
            default:
                System.out.println("잘못 입력하였습니다.");
        }

        System.out.print("입력할 나만의 카테고리의 개수를 입력하시오. ");
        int length = Integer.valueOf(br.readLine().trim());
        String[] myCategory = new String[length];
        for (int i = 0; i < myCategory.length; i++) {
            System.out.print((i + 1) + "번째 카테고리를 입력하시오.");
            myCategory[i] = br.readLine().trim();
        }
        newMember.setMyCategory(myCategory);

        System.out.print("회원가입 종류를 입력하시오.(USER, ADMIN)");
        String role = br.readLine().trim().toUpperCase();
        Role rl = null;
        switch (role) {
            case "USER":
                newMember.setRole(Role.USER);
                break;
            case "ADMIN":
                newMember.setRole(Role.ADMIN);
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
        }

        return newMember;
    }
}
