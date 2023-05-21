package com.gagejackson.lairlister.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="lair_amenities")
public class LairAmenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn (name = "lair_amenity_type_id")
    private LairAmenityType lairAmenityType;

    @ManyToMany(mappedBy = "lairAmenities")
    private List<Lair> lairs;

    /*
    -----------------------------------------
    CONSTRUCTORS
    -----------------------------------------
     */
    public LairAmenity(){}
    public LairAmenity(String name, LairAmenityType lairAmenityType) {
        this.name = name;
        this.lairAmenityType = lairAmenityType;
    }
    public LairAmenity(long id, String name, LairAmenityType lairAmenityType) {
        this.id = id;
        this.name = name;
        this.lairAmenityType = lairAmenityType;
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

    public LairAmenityType getLairAmenityType() {return lairAmenityType;}

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

    public void setLairAmenityType(LairAmenityType lairAmenityType) {this.lairAmenityType = lairAmenityType;}
}
