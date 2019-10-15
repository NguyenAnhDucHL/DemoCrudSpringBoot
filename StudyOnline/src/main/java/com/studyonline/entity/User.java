package com.studyonline.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "user_id")
    private int user_id;

    @Column( name = "full_name")
    private String full_name;

    @Column( name = "email")
    private String email;

    @Column( name = "mobile")
    private String mobile;

    @Column( name = "dob")
    private String dob;

    @Column( name = "last_login")
    private String last_login;

    @Column( name = "stt")
    private boolean stt;

    @Column(name = "picture")
    private String picture;

    @ManyToOne
    private List<Role> roles;

    public User() {
    }

    public User(String full_name, String email, String mobile, String dob, String last_login, boolean stt, String picture) {
        this.full_name = full_name;
        this.email = email;
        this.mobile = mobile;
        this.dob = dob;
        this.last_login = last_login;
        this.stt = stt;
        this.picture = picture;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public boolean isStt() {
        return stt;
    }

    public void setStt(boolean stt) {
        this.stt = stt;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
