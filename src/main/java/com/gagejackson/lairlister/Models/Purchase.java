package com.gagejackson.lairlister.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(nullable = false)
    private Date created_at;

    @OneToOne
    private User seller;

    @OneToOne
    private User purchaser;

    @OneToOne
    private Ad ad;

    /*
    -----------------------------------------
    CONSTRUCTORS
    -----------------------------------------
     */
    public Purchase() {}
    public Purchase(Date created_at, User seller, User purchaser, Ad ad) {
        this.created_at = created_at;
        this.seller = seller;
        this.purchaser = purchaser;
        this.ad = ad;
    }
    public Purchase(long id, Date created_at, User seller, User purchaser, Ad ad) {
        this.id = id;
        this.created_at = created_at;
        this.seller = seller;
        this.purchaser = purchaser;
        this.ad = ad;
    }

    /*
    -----------------------------------------
    GETTERS
    -----------------------------------------
     */
    public long getId() {
        return id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public User getSeller() {
        return seller;
    }

    public User getPurchaser() {
        return purchaser;
    }

    public Ad getAd() {
        return ad;
    }

    /*
    -----------------------------------------
    SETTERS
    -----------------------------------------
     */
    public void setId(long id) {
        this.id = id;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public void setPurchaser(User purchaser) {
        this.purchaser = purchaser;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }
}
