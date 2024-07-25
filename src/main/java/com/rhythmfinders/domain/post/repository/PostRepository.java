package com.rhythmfinders.domain.post.repository;

import com.rhythmfinders.domain.post.aggregate.Post;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PostRepository {

    public PostRepository() {
        final String postDBPath = "src/main/java/com/rhythmfinders/domain/post/db/postDB.dat";
        File file = new File(postDBPath);

        if (!file.exists()) {
            ArrayList<Post> postListInstance = new ArrayList<>();
            postListInstance.add(
                    new Post(1, "title01", "contentsDetail01", "member01", LocalDateTime.now(), LocalDateTime.now(), 1)
            );
            postListInstance.add(
                    new Post(2, "title02", "contentsDetail02", "member02", LocalDateTime.now(), LocalDateTime.now(), 10000)
            );
            postListInstance.add(
                    new Post(3, "title03", "contentsDetail03", "member03", LocalDateTime.now(), LocalDateTime.now(), 100)
            );

            savePosts(postListInstance);
            for (Post post : postListInstance) {
                System.out.println("postInstance: " + post);
            }
        }
    }

    private static void savePosts(ArrayList<Post> posts) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/main/java/com/rhythmfinders/domain/post/db/postDB.dat")));

            for (Post post : posts) {
                oos.writeObject(posts);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public int registPost(Post newPostInfo) {
        return 0;
    }
}
