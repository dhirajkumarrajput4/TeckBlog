package com.tech.blog.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", length = 20)
    private int userId;
    @Column(name = "USER_NAME", length = 500)
    private String userName;
    @Column(name = "USER_EMAIL", length = 500, unique = true)
    private String userEmail;
    @Column(name = "USER_PASSWORD", length = 500)
    private String userPassword;
    @Column(name = "USER_GENDER", length = 10)
    private String userGender;
    @Column(name = "USER_ABOUT", length = 1000)
    private String userAbout;
    @Column(name = "REGISTER_DATE")
    private Date registerDate;
    @Column(name = "PROFILE_PIC")
    private String profilePic;

    @OneToMany(mappedBy = "userid")
    private List<Post> post = new ArrayList<>();

    public User(int userId, String userName, String userEmail, String userPassword, String userGender, String userAbout, Date registerDate, String profilePic) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userGender = userGender;
        this.userAbout = userAbout;
        this.registerDate = registerDate;
        this.profilePic = profilePic;
    }

    public User(String userName, String userEmail, String userPassword, String userGender, String userAbout, Date registerDate, String profilePic) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userGender = userGender;
        this.userAbout = userAbout;
        this.registerDate = registerDate;
        this.profilePic = profilePic;
    }

    public User() {
        
//        default
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserAbout() {
        return userAbout;
    }

    public void setUserAbout(String userAbout) {
        this.userAbout = userAbout;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    
    
}
