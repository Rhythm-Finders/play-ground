package com.rhythmfinders.domain.member.aggregate;

public class MemberLoginResponse {
    private int memId;
    private String memRole;
    private boolean isSucess;

    public MemberLoginResponse() {
    }

    public MemberLoginResponse(int memId, String memRole, boolean isSucess) {
        this.memId = memId;
        this.memRole = memRole;
        this.isSucess = isSucess;
    }

    public int getMemId() {
        return memId;
    }

    public void setMemId(int memId) {
        this.memId = memId;
    }

    public String getMemRole() {
        return memRole;
    }

    public void setMemRole(String memRole) {
        this.memRole = memRole;
    }

    public boolean isSucess() {
        return isSucess;
    }

    public void setSucess(boolean sucess) {
        isSucess = sucess;
    }

    @Override
    public String toString() {
        return "MemberLoginResponse{" +
                "memId=" + memId +
                ", memRole='" + memRole + '\'' +
                ", isSucess=" + isSucess +
                '}';
    }
}
