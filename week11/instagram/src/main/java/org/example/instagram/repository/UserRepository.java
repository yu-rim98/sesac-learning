package org.example.instagram.repository;

import java.util.List;
import java.util.Optional;
import org.example.instagram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    @Query("select u from User u where u.username like %:keyword% or u.name like %:keyword%")
    List<User> searchByKeyword(@Param("keyword") String keyword);
}
