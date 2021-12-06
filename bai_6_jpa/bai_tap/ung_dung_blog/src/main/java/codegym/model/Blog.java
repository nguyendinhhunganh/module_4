package codegym.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    private Integer blogId;
    private String blogName;
    private String blogSummary;
    @Column(columnDefinition = "text")
    private String blogStatus;

    public Blog() {
    }

    public Blog(int blogId, String blogName, String blogSummary, String blogStatus) {
        this.blogId = blogId;
        this.blogName = blogName;
        this.blogSummary = blogSummary;
        this.blogStatus = blogStatus;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogSummary() {
        return blogSummary;
    }

    public void setBlogSummary(String blogSummary) {
        this.blogSummary = blogSummary;
    }

    public String getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(String blogStatus) {
        this.blogStatus = blogStatus;
    }
}
