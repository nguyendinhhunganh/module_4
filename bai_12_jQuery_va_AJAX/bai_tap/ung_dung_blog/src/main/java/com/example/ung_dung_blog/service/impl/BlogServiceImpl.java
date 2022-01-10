package com.example.ung_dung_blog.service.impl;


import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.repository.BlogRepository;
import com.example.ung_dung_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Blog getBlogById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }


    @Override
    public List<Blog> getList() {
        Iterable<Blog> iterable = blogRepository.findAll();
        List<Blog> blogList = new ArrayList<>();
        for (Blog b: iterable) {
            blogList.add(b);
        }
        return blogList;
    }

    @Override
    public List<Blog> findByName(String name) {
        return blogRepository.findByBlogNameContaining(name);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlogById(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByBlogNameContaining(String blogName, Pageable pageable) {
        return blogRepository.findByBlogNameContaining(blogName, pageable);
    }

    @Override
    public Page<Blog> findByCategoryId(int categoryId, Pageable pageable) {
        return blogRepository.findByCategoryId(categoryId, pageable);
    }
}
