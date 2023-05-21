package com.gagejackson.lairlister.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="lair_amenity_types")
public class LairAmenityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lairAmenityType")
    private List<LairAmenity> lairAmenities;

    /*
    -----------------------------------------
    CONSTRUCTORS
    -----------------------------------------
     */
    public LairAmenityType(){}
    public LairAmenityType(String name) {
        this.name = name;
    }
    public LairAmenityType(long id, String name) {
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
