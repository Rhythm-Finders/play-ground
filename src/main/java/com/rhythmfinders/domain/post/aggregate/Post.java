package com.rhythmfinders.domain.post.aggregate;

import java.time.LocalDateTime;

public class Post {
    public int postId;
    public String postTitle;
    public String postContents;
    public String member;
    public LocalDateTime createDate;
    public LocalDateTime updateDate;
    public int view;

}
