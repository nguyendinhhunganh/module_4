package com.example.ung_dung_blog.service;


import com.example.ung_dung_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {
    Blog getBlogById(Integer id);
    List<Blog> getList();
    List<Blog> findByName(String name);
    void save(Blog blog);
    void update(Blog blog);
    void deleteBlogById(Integer id);
    Page<Blog> findAllBlog(Pageable pageable);
    Page<Blog> findByBlogNameContaining(String blogName, Pageable pageable);
    Page<Blog> findByCategoryId(@Param("categoryId") int categoryId, Pageable pageable);
}
