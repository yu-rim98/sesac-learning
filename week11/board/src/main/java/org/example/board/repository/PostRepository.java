package org.example.board.repository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.board.dto.PostDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final JdbcTemplate jdbcTemplate;

    // row 한줄을 dto로 바꿔줌
    // DB 조회 결과를 DTO 객체로 변환해주는 역할
    private final RowMapper<PostDto> rowMapper = (rs, rowNum) -> {
        return new PostDto(
            // 데이터 타입과 컬럼명을 명시해서 가져옴
            rs.getLong("id"),
            rs.getString("title"),
            rs.getString("content"),
            rs.getTimestamp("created_at").toLocalDateTime()
        );
    };

    // 전체 조회
    public List<PostDto> findAll() {
        String sql = "select * from post";

        return jdbcTemplate.query(sql, rowMapper);
    }

    // 상세 조회
    public PostDto findById(Long id) {
        String sql = "select * from post where id = ?";
        // queryForObject => 단일 행 조회
        PostDto post = jdbcTemplate.queryForObject(sql, rowMapper, id); // id = ?에 들어갈 값
        return post;
    }

    public void save(PostDto postDto) {
        String sql = "insert into post (title, content) values (?, ?)";
        jdbcTemplate.update(sql, postDto.getTitle(), postDto.getContent());
    }

    public void update(Long id, PostDto postDto) {
        String sql = "update post set title = ?, content = ? where id = ?";
        jdbcTemplate.update(sql, postDto.getTitle(), postDto.getContent(), id);
    }

    public void deleteById(Long id) {
        String sql = "delete from post where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
