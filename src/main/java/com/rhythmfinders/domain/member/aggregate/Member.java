package com.rhythmfinders.domain.member.aggregate;

import java.io.Serializable;
import java.util.Arrays;

public class Member implements Serializable {
    private int id;
    private String nickname;
    private String email;
    private String pw;
    private String name;
    private int age;
    private Gender gender;
    private String[] myCategory;
    private Role role;
    private boolean flag;

    public Member() {
    }

    public Member(int id, String nickname, String email, String pw, String name, int age, Gender gender, String[] myCategory, Role role, boolean flag) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.pw = pw;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.myCategory = myCategory;
        this.role = role;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String[] getMyCategory() {
        return myCategory;
    }

    public void setMyCategory(String[] myCategory) {
        this.myCategory = myCategory;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", myCategory=" + Arrays.toString(myCategory) +
                ", role=" + role +
                ", flag=" + flag +
                '}';
    }
}
