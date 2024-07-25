package com.rhythmfinders.domain.post.service;

import com.rhythmfinders.domain.post.aggregate.Post;
import com.rhythmfinders.domain.post.repository.PostRepository;

public class PostService {
    private final PostRepository postRepository = new PostRepository();

    public Post writePost(Post newPostInfo) {
        Post post = new Post();
        int result = postRepository.registPost(newPostInfo);

        return null;
    }
}
