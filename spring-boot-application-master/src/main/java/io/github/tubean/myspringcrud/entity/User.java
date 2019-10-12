package io.github.tubean.myspringcrud.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private Long user_id;

  @Column(name = "full_name")
  private String full_name;

  @Column(name = "email")
  private String email;

  @Column(name = "mobile")
  private String mobile;

  @Column(name = "title")
  private String title;

  @Column(name = "from")
  private String from;

  @Column(name = "position")
  private String position;

  @Column(name = "mail_reg")
  private String mail_reg;

  @Column(name = "picture")
  private String picture;



  public User() {
  }

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getMail_reg() {
    return mail_reg;
  }

  public void setMail_reg(String mail_reg) {
    this.mail_reg = mail_reg;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }
}
