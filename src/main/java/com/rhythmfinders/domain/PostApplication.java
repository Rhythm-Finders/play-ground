package com.rhythmfinders.domain;

import com.rhythmfinders.domain.post.aggregate.Post;
import com.rhythmfinders.domain.post.service.PostService;

import java.util.ArrayList;
import java.util.Scanner;

public class PostApplication {

    // executed with staring program
    private static final PostService postService = new PostService();

    public static void main(String[] args) {

        System.out.println("welcome to RhythmFinders' store");

        while (true) {
            System.out.println("==== enter your choice ====");
            System.out.println("1. 모든 게시글 보기");
            System.out.println("2. 글 작성하기");
            System.out.println("3. 내가 쓴 글 보기");
            System.out.println("4. 글 수정하기");
            System.out.println("5. 글 삭제하기");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해주세요: ");
            Scanner scanner = new Scanner(System.in);
            String userOption = scanner.nextLine();
            switch (userOption) {
                case "1":
                    // get all existing posts
                    ArrayList<Post> posts = postService.findAllPosts();
                    for (Post post : posts) {
                        System.out.println(post);
                    }
                    break;
                case "2":
                    // write post with memberId
                    postService.writePost(getNewPostInformation());
                    break;
                case "3":
                    // get user's posts with something
                    // TODO: findPostBy()
                    break;
                case "4":
                    // update post by postId
                    // TODO: updatePost()
                    break;
                case "5":
                    // delete post by postId
                    // TODO: deletePost()
                    break;
                case "9":
                    System.out.println("have a good time~");
                    return;
            }
        }
    }


    private static Post getNewPostInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        return null;
    }
}
