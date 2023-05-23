package com.gagejackson.lairlister.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="lairs")
public class Lair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @OneToOne
    private Item item;

    @ManyToOne
    @JoinColumn (name = "lair_type_id")
    private LairType lairType;

    @ManyToOne
    @JoinColumn (name = "lair_size_id")
    private LairSize lairSize;

    @ManyToOne
    @JoinColumn (name = "lair_security_id")
    private LairSecurity lairSecurity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="lair_amenity_assignments",
            joinColumns={@JoinColumn(name="lair_id")},
            inverseJoinColumns={@JoinColumn(name="lair_amenity_id")}
    )
    private List<LairAmenity> lairAmenities;

    /*
    -----------------------------------------
    CONSTRUCTORS
    -----------------------------------------
     */
    public Lair() {}
    public Lair(long id, Item item, LairType lairType, LairSize lairSize, LairSecurity lairSecurity, List<LairAmenity> lairAmenities) {
        this.id = id;
        this.item = item;
        this.lairType = lairType;
        this.lairSize = lairSize;
        this.lairSecurity = lairSecurity;
        this.lairAmenities = lairAmenities;
    }
    public Lair(Item item, LairType lairType, LairSize lairSize, LairSecurity lairSecurity, List<LairAmenity> lairAmenities) {
        this.item = item;
        this.lairType = lairType;
        this.lairSize = lairSize;
        this.lairSecurity = lairSecurity;
        this.lairAmenities = lairAmenities;
    }

    /*
    -----------------------------------------
    GETTERS
    -----------------------------------------
     */
    public long getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public LairType getLairType() {
        return lairType;
    }

    public LairSize getLairSize() {
        return lairSize;
    }

    public LairSecurity getLairSecurity() {
        return lairSecurity;
    }

    public List<LairAmenity> getLairAmenities() {return lairAmenities;}

    /*
        -----------------------------------------
        SETTERS
        -----------------------------------------
         */
    public void setId(long id) {
        this.id = id;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setLairType(LairType lairType) {
        this.lairType = lairType;
    }

    public void setLairSize(LairSize lairSize) {
        this.lairSize = lairSize;
    }

    public void setLairSecurity(LairSecurity lairSecurity) {
        this.lairSecurity = lairSecurity;
    }

    public void setLairAmenities(List<LairAmenity> lairAmenities) {this.lairAmenities = lairAmenities;}
}
