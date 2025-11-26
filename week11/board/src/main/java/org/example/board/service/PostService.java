package org.example.board.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.board.entity.Comment;
import org.example.board.entity.Post;
import org.example.board.repository.PostDataJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostDataJpaRepository postRepository;

    @Transactional
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        // readOnly = false
        // 1. 엔티티 조회
        // 2. 스냅샷 저장
        // 3. 트랜잭션이 끝날 때 비교
        // 4. 변경이 있으면 update

        // readOnly = true
        // 1. 엔티티 조회
    }

    public List<Post> getAllPosts() {
//        return postRepository.findAll(
//            Sort.by(Direction.DESC, "id") // id 기준 내림차순 정렬
//        );
        return postRepository.findAllByOrderByIdDesc();
    }

    @Transactional
    public Post updatePost(Long id, Post updatedPost) {
        Post post = getPostById(id);
        post.updatePost(updatedPost);
        return post;
    }

    @Transactional
    public void deletePost(Long id) {
        Post post = getPostById(id);
        postRepository.delete(post);
    }

    // Transactional 어노테이션 없어도 됨
    @Transactional(readOnly = true)
    public void testFirstLevelCache() {
        Post post1 = postRepository.findById(1L)
            .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        System.out.println(post1.getTitle());

        Post post2 = postRepository.findById(1L)
            .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        System.out.println(post2.getTitle());

        System.out.println(post1 == post2);
    }

    @Transactional
    public void testWriteBehind() {
        Post post = postRepository.findById(1L)
            .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

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

    public List<Post> searchPostsByTitleOrContent(String keyword) {
//        return postRepository.findByTitleContainingOrContentContaining(keyword, keyword);
//        return postRepository.searchByKeyword(keyword);
        return postRepository.searchByTitleNative(keyword);
    }

    public List<Post> getRecentPosts() {
        // findTopByLastnameOrderByAgeDesc
        // 최근 게시물 3개만 출력
        
        // 쿼리 메서드
//        return postRepository.findTop3ByOrderByCreatedAtDesc();

        // nativeQuery
//        return postRepository.findRecentPostsNative();

        // jpql Pageable 사용
        return postRepository.findRecentPosts(PageRequest.of(0, 3));
    }

    public Page<Post> getPostsPage(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Transactional
    public void createDummyPosts(int count) {
        for (int i = 1; i < count; i++) {
            Post post = new Post(i + "번 제목", "게시글 내용");
            postRepository.save(post);
        }
    }

    public Page<Post> searchPostsPage(String keyword, Pageable pageable) {
        return postRepository.findByTitleContaining(keyword, pageable);
    }

    public Slice<Post> getPostsSlice(Pageable pageable) {
        return postRepository.findAllBy(pageable);
    }

    public List<Comment> getCommentsById(Long id) {
        Post post = getPostById(id);
        return post.getComments();
    }
}
