package com.rhythmfinders.domain.member.repository;

import com.rhythmfinders.domain.member.aggregate.Gender;
import com.rhythmfinders.domain.member.aggregate.Member;
import com.rhythmfinders.domain.member.aggregate.Role;
import com.rhythmfinders.domain.member.stream.MyObjectOuput;

import java.io.*;
import java.util.ArrayList;

public class MemberRepository {

    private ArrayList<Member> membersList = new ArrayList<>();
    private File file = new File("src/main/java/com/rhythmfinders/domain/member/db/membersDB.dat");

    public MemberRepository() {
        if (!file.exists()) {
            ArrayList<Member> defaultMembers = new ArrayList<>();
            defaultMembers.add(new Member(1, "CHUL", "chul1@gmail.com", "pass01", "김철수", 15, Gender.M, new String[]{"생활", "게임"}, Role.USER, false));
            defaultMembers.add(new Member(2, "YOUNG", "young3@naver.com", "pass01", "김철수", 19, Gender.F, new String[]{"뷰티", "뜨개질"}, Role.USER, false));
            defaultMembers.add(new Member(3, "G-Dragon", "Gyoung0@hanmail.com", "pass01", "김철수", 41, Gender.M, new String[]{"IT", "운동"}, Role.USER, false));

            saveMembers(file, defaultMembers);
        }

        loadMembers(file);
    }

    private void loadMembers(File file) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(file)));
            while (true) {
                membersList.add((Member)ois.readObject());
            }

        } catch (EOFException e) {
            System.out.println("회원 정보 모두 로딩 완료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void saveMembers(File file, ArrayList<Member> Members) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)));

            for (Member member : Members) {
                oos.writeObject(member);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Member> selectAllMembers() {
        return null;
    }

    public int selectLastMemberNo() {
        return membersList.get(membersList.size() - 1).getId();
    }

    public int insertMember(Member newMember) {
        membersList.add(newMember);
        int result = 0;
        MyObjectOuput moo = null;

        try {
            moo = new MyObjectOuput(
                    new BufferedOutputStream(
                            new FileOutputStream(file, true)));

            moo.writeObject(newMember);
            result = 1;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (moo != null) moo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    public int login(String[] ePw) {
        int result = 0;
        for (int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i).getEmail().equals(ePw[0]) && membersList.get(i).getPassword().equals(ePw[1])) {
                membersList.get(i).setFlag(true);
                saveMembers(file, membersList);
                if(membersList.get(i).getRole() == Role.USER){
                    result=1;
                }else if(membersList.get(i).getRole() == Role.ADMIN){
                    result=2;
                }
            }
        }


        return 0;
    }

    public Member findId(int memNo) {
        for (Member member : membersList) {
            if (member.getId() == memNo) {
                return member;
            }
        }
        return null;
    }
}
