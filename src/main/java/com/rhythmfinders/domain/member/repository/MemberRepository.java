package com.rhythmfinders.domain.member.repository;

import com.rhythmfinders.domain.member.aggregate.Gender;
import com.rhythmfinders.domain.member.aggregate.Member;
import com.rhythmfinders.domain.member.aggregate.Role;

import java.io.*;
import java.util.ArrayList;

public class MemberRepository {

    public MemberRepository() {

        File file = new File("src/main/java/com/rhythmfinders/domain/member/db/membersDB.dat");

        if (!file.exists()) {
            ArrayList<Member> defaultMembers = new ArrayList<>(); // 초기 회원 세 명만 담는 용도
            defaultMembers.add(new Member(1, "닉네임1", "1@gmail.com", "pw1", "이름1", 25, Gender.MALE, new String[]{"자바", "스프링", "마리아DB"}, Role.ADMIN, false));
            defaultMembers.add(new Member(2, "닉네임2", "2@gmail.com", "pw2", "이름2", 30, Gender.FEMALE, new String[]{"HTML", "포른트"}, Role.USER, false));
            defaultMembers.add(new Member(3, "닉네임3", "3@gmail.com", "pw3", "이름3", 35, Gender.MALE, new String[]{"Unity", "C#"}, Role.USER, false));

            saveMembers(file, defaultMembers);
        }
    }

    private void saveMembers(File file, ArrayList<Member> defaultMembers) {
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
}
