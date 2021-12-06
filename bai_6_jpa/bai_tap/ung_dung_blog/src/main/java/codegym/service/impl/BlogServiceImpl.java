package codegym.service.impl;

import codegym.model.Blog;
import codegym.repository.BlogRepository;
import codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
