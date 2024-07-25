package com.rhythmfinders.domain.post;

import java.lang.reflect.Member;
import java.util.Date;

public class Post {
    public int postId;
    public String postTitle;
    public String postContents;
    public Member member;
    public Date createDate;
    public Date updateDate;
    public int viewed;

    public Post() {
    }

    public Post(int postId, String postTitle, String postContents, Member member, Date createDate, Date updateDate, int viewed) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContents = postContents;
        this.member = member;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.viewed = viewed;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postContents='" + postContents + '\'' +
                ", member=" + member +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", viewed=" + viewed +
                '}';
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContents() {
        return postContents;
    }

    public void setPostContents(String postContents) {
        this.postContents = postContents;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getViewed() {
        return viewed;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }
}
