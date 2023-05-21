package com.gagejackson.lairlister.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = true, length = 255)
    private String profile_image;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String bio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Ad> ads;


    public User() {}

    public User(long id, String username, String name, String email, String password, String profile_image, String bio) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile_image = profile_image;
        this.bio = bio;
    }

    public User(String username, String name, String email, String password, String profile_image, String bio) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile_image = profile_image;
        this.bio = bio;
    }

    public User(User copy) {
        id = copy.id;
        username = copy.username;
        name = copy.name;
        email = copy.email;
        password = copy.password;
        profile_image = copy.profile_image;
        bio = copy.bio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
