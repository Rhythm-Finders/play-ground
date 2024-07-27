package com.rhythmfinders.domain.post.service;

import com.rhythmfinders.domain.post.aggregate.Post;
import com.rhythmfinders.domain.post.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PostService {
    private final PostRepository postRepository = new PostRepository();

    public void writePost(Post newPostInfo) {
        newPostInfo.setPostId(postRepository.selectLastPostNo());
        // TODO: set member information
//        newPostInfo.setMember(memberId);
        newPostInfo.setCreateDate(LocalDateTime.now());
        newPostInfo.setUpdateDate(LocalDateTime.now());
        newPostInfo.setView(0);
        int result = postRepository.insertPost(newPostInfo);
        if (result == 1) {
            System.out.println("Successfully posted");
        }
    }

    public ArrayList<Post> findAllPosts() {
        ArrayList<Post> postList = postRepository.selectAllPost();
        return postList;
    }

    public void removePost(int postId) {
        if (findPostByPostId(postId) == null) {
            System.out.println("Post not found");
        } else {
            int result = postRepository.deletePost(postId);

            if (result == 1) {
                System.out.println("글이 삭제되었습니다.");
                return;
            }
            System.out.println("글이 삭제되지 않았습니다.");
        }
    }

    public void modifyPost(Post reform) {
        int result = postRepository.updatePost(reform);
        if (result == 1) {
            System.out.println("update successful");
        } else {
            System.out.println("update failed");
        }
    }

    public Post findPostByPostId(int postId) {
        Post post = postRepository.selectPost(postId);
        if (post == null) {
            System.out.println("Post not found");
            return null;
        } else {
            postRepository.selectPost(postId);
            return post;
        }
    }

    public void findMyPost(int postId) {
        Post selectedPost = postRepository.selectPost(postId);
        if (selectedPost != null) {
            System.out.println("조회된 게시글은 [" + selectedPost.getPostTitle() + "] 입니다.");
            System.out.println("["+ selectedPost.getPostTitle() + "] 글의 내용은 '" + selectedPost.getPostContents() + "' 입니다.");
        } else {
            System.out.println("찾으시는 상품 게시글은 없습니다.");
        }
    }
}

