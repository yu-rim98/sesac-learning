package org.example.board.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.example.board.entity.Post;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {

    @PersistenceContext
    private EntityManager em;

    public Post save(Post post) {
        em.persist(post);
        return post;
    }

    public Post findById(Long id) {
        return em.find(Post.class, id); // 엔티티의 정보와 id를 전달
    }

    public List<Post> findAll() {
        // EM -> 단일 엔티티 조작만 기본으로 제공됨
        String jpql = "select p from Post p";
        return em.createQuery(jpql, Post.class).getResultList();
    }

    public Post update(Post post) {
        return em.merge(post);
    }

    public void delete(Post post) {
        em.remove(post);
    }

    public List<Post> findByTitleContaining(String keyword) {
        String jpql = "select p from Post p where p.title like :keyword";
        return em.createQuery(jpql, Post.class)
            // :keyword에 "%" + keyword + "%" 넣음
            .setParameter("keyword", "%" + keyword + "%")
            .getResultList();
    }

}
