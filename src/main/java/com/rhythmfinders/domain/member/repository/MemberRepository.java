package com.rhythmfinders.domain.member.repository;

import com.rhythmfinders.domain.member.aggregate.Gender;
import com.rhythmfinders.domain.member.aggregate.Member;
import com.rhythmfinders.domain.member.aggregate.Role;

import java.io.*;
import java.util.ArrayList;

public class MemberRepository {

    private static final File file = new File("src/main/java/com/rhythmfinders/domain/member/db/membersDB.dat");

    public MemberRepository() {
        if (!file.exists()) {
            ArrayList<Member> defaultMembers = new ArrayList<>(); // 초기 회원 세 명만 담는 용도
            defaultMembers.add(new Member(1, "닉네임1", "1@gmail.com", "pw1", "이름1", 25, Gender.MALE, new String[]{"자바", "스프링", "마리아DB"}, Role.ADMIN, false));
            defaultMembers.add(new Member(2, "닉네임2", "2@gmail.com", "pw2", "이름2", 30, Gender.FEMALE, new String[]{"HTML", "포른트"}, Role.USER, false));
            defaultMembers.add(new Member(3, "닉네임3", "3@gmail.com", "pw3", "이름3", 35, Gender.MALE, new String[]{"Unity", "C#"}, Role.USER, false));

            saveMembers(defaultMembers);
        }
    }

    private void saveMembers(ArrayList<Member> defaultMembers) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

            /* 설명. 초기 회원 세 명을 각각 객체 출력 내보내기 */
            for(Member member : defaultMembers)
                oos.writeObject(member);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private ArrayList<Member> loadMembers() {
        ArrayList<Member> memberList = new ArrayList<>();

        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

            while (true)
                memberList.add((Member) ois.readObject());

        } catch (EOFException e) {
            System.out.println("회원 정보 모두 로딩됨...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return memberList;
    }

    public int saveMember(Member newMember) {
        ArrayList<Member> memberList = loadMembers();

        try {
            newMember.setRole(Role.USER);
            newMember.setId(memberList.get(memberList.size()-1).getId() + 1);
            memberList.add(newMember);
            saveMembers(memberList);

            System.out.println("회원가입된 User의 정보는 : " + newMember);

            return 1;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public ArrayList<Member> selectAllMember() {
        return loadMembers();
    }
}
