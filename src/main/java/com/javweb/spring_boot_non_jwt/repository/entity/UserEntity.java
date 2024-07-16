package com.javweb.spring_boot_non_jwt.repository.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "status",nullable = false)
    private Integer status;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", // ten bang lien ket
            // colum tham chieu den khoa chinh cua bang hien tai
            joinColumns = @JoinColumn(name = "userid", nullable = false), // userid la ten code se duoc tao
            // colum tham chieu den khoa chinh cua bang reference
            inverseJoinColumns = @JoinColumn(name = "roleid", nullable = false))
    private List<RoleEntity> roles = new ArrayList<>();  // roles phai giong ben kia

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
