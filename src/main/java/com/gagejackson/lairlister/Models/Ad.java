package com.gagejackson.lairlister.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, length = 255)
    private String description_short;

    @Column(nullable = false)
    private long price;

    @Column(nullable = false, length = 255)
    private Date created_at;

    @Column(nullable = false, length = 255)
    private Date last_status_change;

    @Column(nullable = false)
    private boolean featured;

    @OneToOne
    private AdLocation ad_location_id;

    @OneToOne
    private AdStatus ad_status_id;

    /*
    -----------------------------------------
    CONSTRUCTORS
    -----------------------------------------
     */
    public Ad(){}
    public Ad(long id, String title, String description, String description_short, long price, Date created_at, Date last_status_change, boolean featured, AdLocation ad_location_id, AdStatus ad_status_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.description_short = description_short;
        this.price = price;
        this.created_at = created_at;
        this.last_status_change = last_status_change;
        this.featured = featured;
        this.ad_location_id = ad_location_id;
        this.ad_status_id = ad_status_id;
    }
    public Ad(String title, String description, String description_short, long price, Date created_at, Date last_status_change, boolean featured, AdLocation ad_location_id, AdStatus ad_status_id) {
        this.title = title;
        this.description = description;
        this.description_short = description_short;
        this.price = price;
        this.created_at = created_at;
        this.last_status_change = last_status_change;
        this.featured = featured;
        this.ad_location_id = ad_location_id;
        this.ad_status_id = ad_status_id;
    }

    /*
    -----------------------------------------
    GETTERS
    -----------------------------------------
     */

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDescription_short() {
        return description_short;
    }

    public long getPrice() {
        return price;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getLast_status_change() {
        return last_status_change;
    }

    public boolean isFeatured() {
        return featured;
    }

    public AdLocation getAd_location_id() {
        return ad_location_id;
    }

    public AdStatus getAd_status_id() {
        return ad_status_id;
    }

    /*
    -----------------------------------------
    SETTERS
    -----------------------------------------
     */

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDescription_short(String description_short) {
        this.description_short = description_short;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setLast_status_change(Date last_status_change) {
        this.last_status_change = last_status_change;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public void setAd_location_id(AdLocation ad_location_id) {
        this.ad_location_id = ad_location_id;
    }

    public void setAd_status_id(AdStatus ad_status_id) {
        this.ad_status_id = ad_status_id;
    }
}
