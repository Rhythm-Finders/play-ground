package com.rhythmfinders.domain.member.aggregate;

public class MemberLoginInfo {
    private String email;
    private String pw;

    public MemberLoginInfo() {
    }

    public MemberLoginInfo(String email, String pw) {
        this.email = email;
        this.pw = pw;
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

    @Override
    public String toString() {
        return "MemberLoginInfo{" +
                "email='" + email + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}
