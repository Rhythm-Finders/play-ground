package com.rhythmfinders.domain.post;

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
                    postService.findMyPost(choosePostNo());
                    break;
                case "4":
                    // update post by postId
                    Post selected = postService.findPostForModi(choosePostNo());
                    if (selected == null) continue;
                    postService.modifyPost(reform(selected));
                    break;
                case "5":
                    // delete post by postId
                    postService.removePost(choosePostNo());
                    break;
                case "9":
                    System.out.println("have a good time~");
                    return;
            }
        }
    }

    private static Post reform(Post selected) {
        Post modifyPost = selected;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("==== 수정 서브 메뉴 ====");
            System.out.println("1. 제목");
            System.out.println("2. 글 내용");
            System.out.println("0. 메인 메뉴로 돌아가기");
            System.out.print("내용을 선택하세요: ");
            int chooseNo = sc.nextInt();
            sc.nextLine();

            switch (chooseNo) {
                case 1:
                    System.out.println("수정 할 제목을 입력하세요: ");
                    modifyPost.setPostTitle(sc.nextLine());
                    ;
                    break;
                case 2:
                    System.out.println("수정 할 내용을 입력하세요: ");
                    modifyPost.setPostContents(sc.nextLine());
                    break;
                case 0:
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    return selected;
                default:
                    System.out.println("수정을 완료해주세요");
            }
        }
    }

    private static int choosePostNo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("게시글 등록번호를 입력하세요");
        return sc.nextInt();
    }


    private static Post getNewPostInformation() {
        Post newPost = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("제목을 입력하세요: ");
        String postTitle = scanner.nextLine();

        System.out.print("내용을 입력하세요: ");
        String postContents = scanner.nextLine();

        newPost = new Post(postTitle, postContents);
        return newPost;
    }
}
