package com.rhythmfinders.domain.member.aggregate;

import java.util.Arrays;

public class Member {
    private int id;
    private String nickName;
    private String email;
    private String password;
    private String name;
    private int age;
    private Gender gender;
    private String[] myCategory;
    private Role role;
    private boolean flag;

    public Member() {}

    public Member(int id, String nickName, String email, String password, String name, int age, Gender gender, String[] myCategory, Role role, boolean flag) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
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
        return nickName;
    }

    public void setNickname(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", nickname='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", myCategory=" + Arrays.toString(myCategory) +
                ", role=" + role +
                ", flag=" + flag +
                '}';
    }
}
