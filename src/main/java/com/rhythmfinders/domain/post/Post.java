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
}
