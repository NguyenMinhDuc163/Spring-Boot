//package com.javweb.spring_boot_non_jwt.repository.entity;
//
//import jakarta.persistence.*;
//// //TODO dung quan he many to many khong can cai nay nua
//@Entity
//@Table(name = "user_role")
//public class UserRoleEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "userid")
//    private UserEntity user;
//
//    @ManyToOne
//    @JoinColumn(name = "roleid")
//    private RoleEntity role;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public UserEntity getUser() {
//        return user;
//    }
//
//    public void setUser(UserEntity user) {
//        this.user = user;
//    }
//
//    public RoleEntity getRole() {
//        return role;
//    }
//
//    public void setRole(RoleEntity role) {
//        this.role = role;
//    }
//}
