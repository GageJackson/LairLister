USE lairLister_db;
DROP TABLE IF EXISTS minion_skill_assignments;
DROP TABLE IF EXISTS lair_amenity_assignments;
DROP TABLE IF EXISTS user_ad_assignments;
DROP TABLE IF EXISTS lair_amenities;
DROP TABLE IF EXISTS lairs;
DROP TABLE IF EXISTS minions;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS purchases;
DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS lair_types;
DROP TABLE IF EXISTS lair_securities;
DROP TABLE IF EXISTS lair_sizes;
DROP TABLE IF EXISTS lair_amenity_types;
DROP TABLE IF EXISTS minion_skills;
DROP TABLE IF EXISTS minion_types;
DROP TABLE IF EXISTS minion_levels;
DROP TABLE IF EXISTS minion_sizes;
DROP TABLE IF EXISTS minion_classes;
DROP TABLE IF EXISTS ad_locations;
DROP TABLE IF EXISTS ad_statuses;
DROP TABLE IF EXISTS item_types;


CREATE TABLE ad_locations
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ad_statuses
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE item_types
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE lair_types
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE lair_sizes
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE lair_securities
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE lair_amenity_types
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE lair_amenities
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    lair_amenity_type INT UNSIGNED NOT NULL,
    FOREIGN KEY (lair_amenity_type) REFERENCES lair_amenity_types (id),
    PRIMARY KEY (id)
);

CREATE TABLE minion_types
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE minion_sizes
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE minion_levels
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE minion_skills
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE minion_classes
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users
(
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username      VARCHAR(100) NOT NULL,
    name          VARCHAR(100) NOT NULL,
    email         VARCHAR(255) NOT NULL,
    password      VARCHAR(100) NOT NULL,
    profile_image VARCHAR(255),
    bio           TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE ads
(
    id                 INT UNSIGNED           NOT NULL AUTO_INCREMENT,
    title              VARCHAR(100)           NOT NULL,
    description        TEXT                   NOT NULL,
    description_short  VARCHAR(255)           NOT NULL,
    price              INT                    NOT NULL,
    created_at         DATETIME               NOT NULL,
    last_status_change DATETIME               NOT NULL,
    featured           ENUM ('true', 'false') NOT NULL,
    ad_location_id     INT UNSIGNED           NOT NULL,
    ad_status_id       INT UNSIGNED           NOT NULL,
    FOREIGN KEY (ad_location_id) REFERENCES ad_locations (id),
    FOREIGN KEY (ad_status_id) REFERENCES ad_statuses (id),
    PRIMARY KEY (id)
);

CREATE TABLE items
(
    id           INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name         VARCHAR(100) NOT NULL,
    image        VARCHAR(255),
    ad_id        INT UNSIGNED NOT NULL,
    item_type_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (ad_id) REFERENCES ads (id),
    FOREIGN KEY (item_type_id) REFERENCES item_types (id),
    PRIMARY KEY (id)
);

CREATE TABLE lairs
(
    id               INT UNSIGNED NOT NULL AUTO_INCREMENT,
    item_id          INT UNSIGNED NOT NULL,
    lair_type_id     INT UNSIGNED NOT NULL,
    lair_size_id     INT UNSIGNED NOT NULL,
    lair_security_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (item_id) REFERENCES items (id),
    FOREIGN KEY (lair_type_id) REFERENCES lair_types (id),
    FOREIGN KEY (lair_size_id) REFERENCES lair_sizes (id),
    FOREIGN KEY (lair_security_id) REFERENCES lair_securities (id),
    PRIMARY KEY (id)
);

CREATE TABLE minions
(
    id              INT UNSIGNED NOT NULL AUTO_INCREMENT,
    item_id         INT UNSIGNED NOT NULL,
    minion_type_id  INT UNSIGNED NOT NULL,
    minion_size_id  INT UNSIGNED NOT NULL,
    minion_level_id INT UNSIGNED NOT NULL,
    minion_class INT UNSIGNED NOT NULL,
    FOREIGN KEY (item_id) REFERENCES items (id),
    FOREIGN KEY (minion_type_id) REFERENCES minion_types (id),
    FOREIGN KEY (minion_size_id) REFERENCES minion_sizes (id),
    FOREIGN KEY (minion_level_id) REFERENCES minion_levels (id),
    FOREIGN KEY (minion_class) REFERENCES minion_classes (id),
    PRIMARY KEY (id)
);

CREATE TABLE purchases
(
    id           INT UNSIGNED NOT NULL AUTO_INCREMENT,
    created_at   DATE         NOT NULL,
    seller_id    INT UNSIGNED NOT NULL,
    purchaser_id INT UNSIGNED NOT NULL,
    ad_id        INT UNSIGNED NOT NULL,
    FOREIGN KEY (seller_id) REFERENCES users (id),
    FOREIGN KEY (purchaser_id) REFERENCES users (id),
    FOREIGN KEY (ad_id) REFERENCES ads (id),
    PRIMARY KEY (id)
);

CREATE TABLE lair_amenity_assignments
(
    id           INT UNSIGNED NOT NULL AUTO_INCREMENT,
    lair_id      INT UNSIGNED NOT NULL,
    lair_amenity INT UNSIGNED NOT NULL,
    FOREIGN KEY (lair_id) REFERENCES lairs (id),
    FOREIGN KEY (lair_amenity) REFERENCES lair_amenities (id),
    PRIMARY KEY (id)
);

CREATE TABLE user_ad_assignments
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     INT UNSIGNED NOT NULL,
    ad_id       INT UNSIGNED NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (ad_id) REFERENCES ads (id),
    PRIMARY KEY (id)
);

CREATE TABLE minion_skill_assignments
(
    id           INT UNSIGNED     NOT NULL AUTO_INCREMENT,
    minion_id    INTEGER UNSIGNED NOT NULL,
    minion_skill INTEGER UNSIGNED NOT NULL,
    FOREIGN KEY (minion_id) REFERENCES minions (id),
    FOREIGN KEY (minion_skill) REFERENCES minion_skills (id),
    PRIMARY KEY (id)
);