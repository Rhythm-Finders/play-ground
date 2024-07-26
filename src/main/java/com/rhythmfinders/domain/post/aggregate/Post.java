package com.rhythmfinders.domain.post.aggregate;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Post implements Serializable {
    public int postId;
    public String postTitle;
    public String postContents;
    public String member;
    public LocalDateTime createDate;
    public LocalDateTime updateDate;
    public int view;

    public Post() {
    }

    public Post(String postContents, String postTitle) {
        this.postContents = postContents;
        this.postTitle = postTitle;
    }

    public Post(int postId, String postTitle, String postContents, String member, LocalDateTime createDate, LocalDateTime updateDate, int view) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContents = postContents;
        this.member = member;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.view = view;
    }

    public int getPostId() {

        return postId;
    }

    public void setPostId(Integer postId) {
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

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postContents='" + postContents + '\'' +
                ", member='" + member + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", view=" + view +
                '}';
    }

}
