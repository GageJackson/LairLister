package com.gagejackson.lairlister.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="minions")
public class Minion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @OneToOne
    private Item item;

    @ManyToOne
    @JoinColumn (name = "minion_type_id")
    private MinionType minionType;

    @ManyToOne
    @JoinColumn (name = "minion_size_id")
    private MinionSize minionSize;

    @ManyToOne
    @JoinColumn (name = "minion_level_id")
    private MinionLevel minionLevel;

    @ManyToOne
    @JoinColumn (name = "minion_class_id")
    private MinionClass minionClass;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="minion_skill_assignments",
            joinColumns={@JoinColumn(name="minion_id")},
            inverseJoinColumns={@JoinColumn(name="minion_skill_id")}
    )
    private List<MinionSkill> minionSkills;
    /*
    -----------------------------------------
    CONSTRUCTORS
    -----------------------------------------
     */
    public Minion() {}
    public Minion(Item item, MinionType minionType, MinionSize minionSize, MinionLevel minionLevel, MinionClass minionClass) {
        this.item = item;
        this.minionType = minionType;
        this.minionSize = minionSize;
        this.minionLevel = minionLevel;
        this.minionClass = minionClass;
    }
    public Minion(long id, Item item, MinionType minionType, MinionSize minionSize, MinionLevel minionLevel, MinionClass minionClass) {
        this.id = id;
        this.item = item;
        this.minionType = minionType;
        this.minionSize = minionSize;
        this.minionLevel = minionLevel;
        this.minionClass = minionClass;
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

    public MinionType getMinionType() {
        return minionType;
    }

    public MinionSize getMinionSize() {
        return minionSize;
    }

    public MinionLevel getMinionLevel() {
        return minionLevel;
    }

    public MinionClass getMinionClass() {
        return minionClass;
    }

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

    public void setMinionType(MinionType minionType) {
        this.minionType = minionType;
    }

    public void setMinionSize(MinionSize minionSize) {
        this.minionSize = minionSize;
    }

    public void setMinionLevel(MinionLevel minionLevel) {
        this.minionLevel = minionLevel;
    }

    public void setMinionClass(MinionClass minionClass) {
        this.minionClass = minionClass;
    }
}
