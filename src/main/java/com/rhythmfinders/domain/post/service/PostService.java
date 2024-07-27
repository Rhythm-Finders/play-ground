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
            System.out.println(newPostInfo.getPostTitle() + "작성되었습니다.");
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

    public void removePost(int removePost) {
        int result = postRepository.deletePost(removePost);
        if (result == 1) {
            System.out.println("글이 삭제되었습니다.");
            return;
        }
        System.out.println("글이 삭제되지 않았습니다.");
    }

    public void modifyPost(Post reform) {
        int result = postRepository.updatePost(reform);
        if (result == 1) {
            System.out.println("수정 완료");
            return;
        }
        System.out.println("수정 내역없음");
    }

    public Post findPostForModi(int postId) {
        Post selectedPost = postRepository.selectPost(postId);

        if (selectedPost != null) {
            Post newInstance = new Post();
            newInstance.setPostId(selectedPost.postId);
            newInstance.setPostTitle(selectedPost.postTitle);
            newInstance.setPostContents(selectedPost.postContents);
            newInstance.setMember(selectedPost.member);
            newInstance.setCreateDate(selectedPost.createDate); // 수정되면 수정 일자 어떻게
//            newInstance.getView(selectedPost.view); 조회수 확인 기능....

            System.out.println("조회된 게시글은 [" + newInstance.getPostTitle() + "] 입니다.");
            return newInstance;
        } else {
            System.out.println("그런 게시글은 없습니다.");
        }
        return null;
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

