package com.rhythmfinders.domain.member.view;

import com.rhythmfinders.domain.member.Application;
import com.rhythmfinders.domain.member.aggregate.*;
import com.rhythmfinders.domain.member.service.MemberService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MemberView {

    private static final MemberService memberService = new MemberService();

    public void loginView() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("===== 로그인 화면 =====");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 이메일 찾기");
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
                    memberService.signUp(memberInfo());
                    break;
                case 2:
                    MemberLoginResponse memberLoginResponse = memberService.login(inputLoginInfo());

                    if(memberLoginResponse.isSucess() == true){
                        Application.currentMemId = memberLoginResponse.getMemId();

                        System.out.println(memberLoginResponse.getMemRole());

                        if(memberLoginResponse.getMemRole().equals("ADMIN"))
                            showAdmin();
                        else if(memberLoginResponse.getMemRole().equals("USER"))
                            showUser();
                        else
                            System.out.println("회원 정보가 없습니다");
                    }
                    else {
                        System.out.println("회원 정보가 없습니다");
                    }

                    break;
                case 3:
                    memberService.findMemberEmail(inputEmail());
                    break;
                case 4:
                    memberService.findMemberPw(inputPw());
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다");
                    return;
                case 1234:
                    memberService.findAllMember();
                default:
                    System.out.println("번호를 잘못 입력했습니다");
            }
        }
    }

    private static void showUser() throws IOException {
        BufferedReader brUser = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("===== 일반 유저 화면 =====");
            System.out.println("1. 회원 정보 수정");
            System.out.println("2. 회원 탈퇴");
            System.out.println("3. 로그아웃");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요 : ");

            int input = Integer.parseInt(brUser.readLine());;

            switch (input){
                case 1:
                    memberService.modifyMemberBy(modifyMemberData(Application.currentMemId, chooseModifyNo()));
                    break;
                case 2:
                    memberService.removeMemberBy(Application.currentMemId);
                    break;
                case 3:
                    int i = memberService.logout(Application.currentMemId);

                    if(i == 1)
                        return;

                    System.out.println("logout 실패");
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
                case 1234:
                    memberService.findAllMember();
                default:
                    System.out.println("번호를 잘못 입력했습니다");
            }
        }

    }

    private static Member modifyMemberData(int memNo, int[] modifyNums) throws IOException{
        Member modMem = new Member();
        modMem.setId(Application.currentMemId);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < modifyNums.length; i++) {
            if(modifyNums[i] == 1){
                System.out.print("변경 할 nickname 값을 입력하세요 : ");
                modMem.setNickname(br.readLine());
            } else if (modifyNums[i]==2) {
                System.out.print("변경 할 name 값을 입력하세요 : ");
                modMem.setName(br.readLine());
            }else if (modifyNums[i]==3) {
                System.out.print("변경 할 pw 값을 입력하세요 : ");
                modMem.setPw(br.readLine());
            }else if (modifyNums[i]==4) {
                System.out.print("변경 할 age 값을 입력하세요 : ");
                modMem.setAge(Integer.parseInt(br.readLine()));
            }else if (modifyNums[i]==5) {
                System.out.print("변경 할 gender 값을 입력하세요 : ");
                modifyGender(modMem, br);
            }else if (modifyNums[i]==6) {
                System.out.print("변경 할 myCategory 값을 입력하세요(ex. 축구,농구,... : ");
                modifyMyCategory(br, modMem);
            }
        }

        System.out.println(modMem);
        return modMem;
    }

    private static void modifyMyCategory(BufferedReader br, Member modMem) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] myCategory = new String[st.countTokens()];

        int index = 0;

        while (st.hasMoreTokens()){
            myCategory[index] = st.nextToken();
            index++;
        }

        modMem.setMyCategory(myCategory);
    }

    private static void modifyGender(Member modMem, BufferedReader br) throws IOException {
        String gender = null;
        gender = br.readLine().toUpperCase();
        Gender gd = null;

        switch (gender) {
            case "M":
                gd = Gender.MALE;
                break;
            case "F":
                gd = Gender.MALE;
                break;
        }

        modMem.setGender(gd);
    }

    private static int[] chooseModifyNo() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("===== 회원 수정 정보 =====");
        System.out.println("1. nickname");
        System.out.println("2. name");
        System.out.println("3. pw");
        System.out.println("4. age");
        System.out.println("5. gender");
        System.out.println("6. myCategory");
        System.out.println("9. 수정 안합니다");
        System.out.print("수정하려는 정보들을 선택해 주세요(ex. 1,2,5) : ");

        StringTokenizer st = new StringTokenizer(br.readLine(), ",");


        int[] modifyNo = new int[st.countTokens()];
        int i = 0;

        while(st.hasMoreTokens()) {
            modifyNo[i] = Integer.valueOf(st.nextToken());
            i++;
        }

        return modifyNo;
    }

    private static void showAdmin() throws IOException{
        BufferedReader brAdimin = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("===== 관리자 화면 =====");
            System.out.println("1. 회원 단일 조회");
            System.out.println("2. 회원 전체 조회");
            System.out.println("3. 회원 삭제");
            System.out.println("4. 로그아웃");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요 : ");

            int input = Integer.parseInt(brAdimin.readLine());

            switch (input){
                case 1:
                    memberService.findMemberBy(chooseMemberId());
                    break;
                case 2:
                    memberService.findAllMember();
                    break;
                case 3:
                    memberService.removeMemberBy(chooseMemberId());
                    break;
                case 4:
                    int i = memberService.logout(Application.currentMemId);

                    if(i == 1)
                        return;
                    System.out.println("logout 실패");
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
                case 1234:
                    memberService.findAllMember();
                default:
                    System.out.println("번호를 잘못 입력했습니다");
            }
        }

    }

    private static int chooseMemberId() throws IOException{
        BufferedReader brMember = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("조회하려는 회원의 Id를 입력해주세요 : ");
        int memId = Integer.valueOf(brMember.readLine());

        return memId;
    }

    private static MemberFindPwInfo inputPw() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MemberFindPwInfo mfp = new MemberFindPwInfo();

        System.out.print("이메일을 입력해주세요 : ");
        mfp.setEmail(br.readLine());

        System.out.print("사용자 이름을 입력해주세요 : ");
        mfp.setName(br.readLine());

        System.out.print("사용자 닉네임을 입력해주세요 : ");
        mfp.setNickname(br.readLine());

        return mfp;
    }

    private static MemberFindEmailInfo inputEmail() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MemberFindEmailInfo mfe = new MemberFindEmailInfo();

        System.out.print("사용자 이름을 입력해주세요 : ");
        mfe.setName(br.readLine());

        System.out.print("사용자 닉네임을 입력해주세요 : ");
        mfe.setNickname(br.readLine());

        return mfe;
    }

    private static MemberLoginInfo inputLoginInfo() throws IOException {
        MemberLoginInfo loginInfo = new MemberLoginInfo();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("email 입력 : ");
        loginInfo.setEmail(br.readLine());

        System.out.print("비밀번호 입력 : ");
        loginInfo.setPw(br.readLine());

        return loginInfo;
    }

    private static Member memberInfo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Member newMember = new Member();

        System.out.print("이메일 입력 : ");
        newMember.setEmail(br.readLine());

        System.out.print("비밀번호 입력 : ");
        newMember.setPw(br.readLine());

        System.out.print("이름 입력 : ");
        newMember.setName(br.readLine());

        System.out.print("닉네임 입력 : ");
        newMember.setNickname(br.readLine());

        System.out.print("나이 입력 : ");
        newMember.setAge(Integer.valueOf(br.readLine()));

        System.out.print("성별 입력(m, f) : ");
        String input = br.readLine().toLowerCase();
        Gender gender = null;

        if(input.equals("m"))
            gender = Gender.MALE;
        else if(input.equals("f"))
            gender = Gender.FEMALE;
        else {
            System.out.println("잘못된 값 입력");
            return null;
        }

        newMember.setGender(gender);

        System.out.print("관심사 입력 (ex. 축구, 농구) : ");
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");
        String[] category = new String[st.countTokens()];
        int num = 0;

        while(st.hasMoreTokens())
            category[num++] = st.nextToken().trim();

        newMember.setMyCategory(category);

        return newMember;
    }
}
