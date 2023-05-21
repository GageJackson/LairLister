package com.gagejackson.lairlister.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="item_types")
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemType")
    private List<Item> items;

    /*
    -----------------------------------------
    CONSTRUCTORS
    -----------------------------------------
     */
    public ItemType(){}
    public ItemType(String name) {
        this.name = name;
    }
    public ItemType(long id, String name) {
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
