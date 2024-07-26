package com.rhythmfinders.domain.member.aggregate;

public class MemberFindEmailInfo {
    private String name;
    private String nickname;

    public MemberFindEmailInfo() {
    }

    public MemberFindEmailInfo(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "MemberFindIdInfo{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
