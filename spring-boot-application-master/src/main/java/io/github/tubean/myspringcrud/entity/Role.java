package io.github.tubean.myspringcrud.entity;

import javax.persistence.*;

@Entity
@Table(name = "use_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_user_id")
    private String user_id;

    @Column(name = "role_name")
    private String role_name;

    public Role() {
    }

    public Role(String user_id, String role_name) {
        this.user_id = user_id;
        this.role_name = role_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
