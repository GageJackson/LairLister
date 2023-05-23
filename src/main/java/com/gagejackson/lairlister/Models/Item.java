package com.gagejackson.lairlister.Models;

import jakarta.persistence.*;

@Entity
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = true, length = 255)
    private String image;

    @OneToOne
    private Ad ad;

    @ManyToOne
    @JoinColumn (name = "item_type_id")
    private ItemType itemType;


    /*
    -----------------------------------------
    CONSTRUCTORS
    -----------------------------------------
     */
    public Item() {}
    public Item(long id, String name, String image, Ad ad, ItemType itemType) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.ad = ad;
        this.itemType = itemType;
    }
    public Item(String name, String image, Ad ad, ItemType itemType) {
        this.name = name;
        this.image = image;
        this.ad = ad;
        this.itemType = itemType;
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

    public String getImage() {
        return image;
    }

    public Ad getAd() {
        return ad;
    }

    public ItemType getItemType() {
        return itemType;
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

    public void setImage(String image) {
        this.image = image;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
