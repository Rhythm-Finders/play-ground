package com.rhythmfinders.domain.post.service;

import com.rhythmfinders.domain.post.aggregate.Post;
import com.rhythmfinders.domain.post.repository.PostRepository;

import java.util.ArrayList;

public class PostService {
    private final PostRepository postRepository = new PostRepository();

    public void writePost(Post newPostInfo) {
        Post post = new Post();
        int result = postRepository.registPost(newPostInfo);
        if (result == 1) {
            // TODO
            //  Post post = postRepository.selectPost(recent postId)
            //  return post
            System.out.println("Successfully posted");
        }
    }

    public ArrayList<Post> findAllPosts() {
        ArrayList<Post> postList = postRepository.selectAllPost();
        return postList;
    }
}
