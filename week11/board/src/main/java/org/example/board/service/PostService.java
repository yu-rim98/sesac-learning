package org.example.board.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.board.entity.Post;
import org.example.board.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id);
        // readOnly = false
        // 1. 엔티티 조회
        // 2. 스냅샷 저장
        // 3. 트랜잭션이 끝날 때 비교
        // 4. 변경이 있으면 update

        // readOnly = true
        // 1. 엔티티 조회
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Transactional
    public Post updatePost(Long id, Post updatedPost) {
        Post post = getPostById(id);
        post.updatePost(updatedPost);
        return postRepository.update(post);
    }

    @Transactional
    public void deletePost(Long id) {
        Post post = getPostById(id);
        postRepository.delete(post);
    }

    // Transactional 어노테이션 없어도 됨
    @Transactional(readOnly = true)
    public void testFirstLevelCache() {
        Post post1 = postRepository.findById(1L);
        System.out.println(post1.getTitle());

        Post post2 = postRepository.findById(1L);
        System.out.println(post2.getTitle());

        System.out.println(post1 == post2);
    }

    @Transactional
    public void testWriteBehind() {
        Post post = postRepository.findById(1L);

        post.updatePost(new Post("수정", "수정"));
        System.out.println("update1");

        post.updatePost(new Post("수정2", "수정"));
        System.out.println("update1");

        System.out.println("종료");

        // 변경 감지
        // postRepository.update(post);

        // 변경 감지와 쓰기 지연은 Transactional 어노테이션 필수
    }

    public List<Post> searchPosts(String keyword) {
        return postRepository.findByTitleContaining(keyword);
    }
}
