package com.example.ung_dung_blog.repository;


import com.example.ung_dung_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByBlogNameContaining(String blogName, Pageable pageable);
    @Query("select b from Blog b  where b.category.categoryId = :categoryId")
    Page<Blog> findByCategoryId(int categoryId, Pageable pageable);
}
