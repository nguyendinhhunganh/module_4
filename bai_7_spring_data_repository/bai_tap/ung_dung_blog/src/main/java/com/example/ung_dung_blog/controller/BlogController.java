package com.example.ung_dung_blog.controller;


import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.model.Category;
import com.example.ung_dung_blog.service.BlogService;
import com.example.ung_dung_blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String listBlog(Model model, @PageableDefault(size = 3) Pageable pageable,
                           Optional<String> search_name, Optional<Integer> category_id) {
        model.addAttribute("categories", categoryService.findAll());
        if (search_name.isPresent()) {
            model.addAttribute("blogs",
                    blogService.findByBlogNameContaining(search_name.get(), pageable));
        } else {
            if (category_id.isPresent()) {
                model.addAttribute("blogs",
                        blogService.findByCategoryId(category_id.get(), pageable));
            } else {
            model.addAttribute("blogs", blogService.findAllBlog(pageable));
            }
        }
            return "blog/ListBlog";
        }

        @GetMapping("/blog/content/{id}")
        public String listBlogContent ( @PathVariable("id") int id, Model model){
            Blog blogs = blogService.getBlogById(id);
            model.addAttribute("blogs", blogs);
            return "blog/StatusBlog";
        }

        @GetMapping("/blog/content/create")
        public String createBlog (Model model){
            Blog blog = new Blog();
            List<Category> categories = categoryService.findAll();
            model.addAttribute("blog", blog);
            model.addAttribute("categories", categories);
            return "blog/CreateBlog";
        }

        @PostMapping("/blog/content/save")
        public String saveBlog (@ModelAttribute("blog") Blog blog, Model model){
            blogService.save(blog);
            return "redirect:/";
        }

        @GetMapping("/blog/delete/{id}")
        public String deleteBlog ( @PathVariable("id") int id, Model model){
            blogService.deleteBlogById(id);
            return "redirect:/";
        }

        @GetMapping("/blog/edit/{id}")
        public String updateBlog ( @PathVariable("id") int id, Model model){
            Blog blog = blogService.getBlogById(id);
            List<Category> categories = categoryService.findAll();
            model.addAttribute("blog", blog);
            model.addAttribute("categories", categories);
            return "blog/UpdateBlog";
        }
    }
