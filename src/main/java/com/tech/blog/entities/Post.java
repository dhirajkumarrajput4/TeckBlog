
package com.tech.blog.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="POST_ID")
    private int postId;
    @Column(name="POST_TITLE",length = 150,nullable = false)
    private String postTitle;
    @Column(name="POST_CONTENT")
    @Lob
    private String postContent;
    @Column(name="POST_CODE")
    @Lob
    private String postCode;
    @Column(name="POST_PIC", length = 100)
    private String postPic;
    
    @CreationTimestamp
    @Column(name="POST_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private PostCategory category_Id;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private User userid;

    
    
    public Post(int postId, String postTitle, String postContent, String postCode, String postPic, Date postDate, PostCategory category_Id, User userid) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postCode = postCode;
        this.postPic = postPic;
        this.postDate = postDate;
        this.category_Id = category_Id;
        this.userid = userid;
    }

    public Post(String postTitle, String postContent, String postCode, String postPic, PostCategory category_Id, User userid) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postCode = postCode;
        this.postPic = postPic;
//        this.postDate = postDate;
        this.category_Id = category_Id;
        this.userid = userid;
    }

    public Post() {
        
        //default
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostPic() {
        return postPic;
    }

    public void setPostPic(String postPic) {
        this.postPic = postPic;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public PostCategory getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(PostCategory category_Id) {
        this.category_Id = category_Id;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }
    
    
    
}
