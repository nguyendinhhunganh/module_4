package codegym.controller;

import codegym.model.Blog;
import codegym.service.BlogService;
import codegym.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Blob;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public String listBlog(Model model) {
        List<Blog> blogs = blogService.getList();
        model.addAttribute("blogs", blogs);
        return "ListBlog";
    }

    @GetMapping("/blog/content/{id}")
    public String listBlogContent(@PathVariable("id") int id, Model model) {
        Blog blogs = blogService.getBlogById(id);
        model.addAttribute("blogs", blogs);
        return "StatusBlog";
    }
    @GetMapping("/blog/content/create")
    public String createBlog( Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog" , blog);
        return "CreateBlog";
    }
    @PostMapping("/blog/content/save")
    public String saveBlog(@ModelAttribute("blog") Blog blog, Model model) {
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/blog/delete/{id}")
    public String deleteBlog(@PathVariable("id") int id, Model model) {
        blogService.deleteBlogById(id);
        return "redirect:/";
    }
    @GetMapping("/blog/edit/{id}")
    public String updateBlog(@PathVariable("id") int id, Model model) {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "UpdateBlog";
    }
}
