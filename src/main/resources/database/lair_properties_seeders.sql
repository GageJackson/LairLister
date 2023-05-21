USE lairLister_db;

INSERT INTO lair_amenity_types(name)
VALUES ('Areas'),
       ('Defenses'),
       ('Guardians');

INSERT INTO lair_types(name)
VALUES ('Mansion'),
       ('Tower'),
       ('Castle'),
       ('Stronghold'),
       ('Fortress'),
       ('Crypt'),
       ('Dungeon'),
       ('Labyrinth'),
       ('Temple'),
       ('Cathedral'),
       ('Mine'),
       ('Laboratory'),
       ('Airship'),
       ('Navalship'),
       ('Palace'),
       ('Village'),
       ('Town'),
       ('City'),
       ('Metropolis'),
       ('Nation');

INSERT INTO lair_sizes(name)
VALUES ('Compact'),
       ('Cozy'),
       ('Standard'),
       ('Spacious'),
       ('Grand'),
       ('Colossal'),
       ('Epic'),
       ('Interdimensional');

INSERT INTO lair_securities(name)
VALUES ('The front door might as well be open'),
       ('Standard protections keeping out most riff-raff'),
       ('Low-level defense against heroes'),
       ('Moderate-level defense against heroes'),
       ('High-level defense against heroes'),
       ('Stronghold against heroes'),
       ('Fortress against heroes'),
       ('The heroes don''t stand a chance'),
       ('Beyond the reach of mortals'),
       ('Spit at the gods in the safety overly-fortified lair');

INSERT INTO lair_amenities(name,lair_amenity_type_id)
VALUES
    ('Hidden laboratory',1),
    ('Torture chamber',1),
    ('Treasure vault',1),
    ('Library of forbidden knowledge',1),
    ('Chamber of secrets',1),
    ('Grand throne room',1),
    ('Observatory',1),
    ('Hall of mirrors',1),
    ('Summoning chamber',1),
    ('Poisonous garden',1),
    ('Shrine of the dark one',1),
    ('Planar gateway',1),
    ('Art gallery of evil',1),
    ('Spooky attic',1),
    ('Deadly traps',2),
    ('Escape tunnels',2),
    ('Maze-like corridors',2),
    ('Anti-magic wards',2),
    ('Advanced surveillance system',2),
    ('Magically reinforced doors',2),
    ('Magically reinforced walls',2),
    ('Magic barriers',2),
    ('Moat',2),
    ('Poisonous gases',2),
    ('Illusionary defenses',2),
    ('Self-destruct mechanisms',2),
    ('Dragon',3),
    ('Kraken',3),
    ('Gargoyles',3),
    ('Skeletons',3),
    ('Zombies',3),
    ('Spiders',3),
    ('Slimes',3),
    ('Minotaur',3),
    ('Man-eating plants',3),
    ('Bob...',3);