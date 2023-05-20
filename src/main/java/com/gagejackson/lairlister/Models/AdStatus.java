package com.gagejackson.lairlister.Models;

import jakarta.persistence.*;

@Entity
@Table(name="ad_statuses")
public class AdStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    /*
    -----------------------------------------
    CONSTRUCTORS
    -----------------------------------------
     */
    public AdStatus(){}
    public AdStatus(String name) {
        this.name = name;
    }
    public AdStatus(long id, String name) {
        this.id = id;
        this.name = name;
    }
    /*
    -----------------------------------------
    GETTERS
    -----------------------------------------
     */

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    /*
    -----------------------------------------
    SETTERS
    -----------------------------------------
     */

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
