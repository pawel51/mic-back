

INSERT into base_buffs(id, agility_amp, armour_amp, block_chance_amp, crit_chance_amp, crit_damage_amp, damage_amp, endurance_amp, evasion_chance_amp, exp, gold, health_amp, intelligence_amp, luck_amp, speed_amp, strength_amp,name)
VALUES (1,2,null,0,2,2,2,null,2,null,null,2,null,2,2,null,'archer_class'),
       (2,null,3,2,2,null,null,3,0,null,null,4,null,null,null,2,'warrior_class'),
       (3,null,null,0,3,2,null,1,0,null,null,null,3,null,2,null,'mage_class'),
       (4,null,null,0,0,null,null,2,0,null,null,null,1,null,null,null,'orc_race'),
       (5,null,null,2,0,null,null,null,0,null,null,null,null,null,null,null,'human_race'),
       (6,2,null,0,0,null,null,null,0,null,null,null,null,null,null,null,'elf_race'),
       (7,null,null,0,0,null,null,null,0,null,2,null,null,null,null,null,'dwarf_race'),
       (8,null,null,0,0,null,null,null,2,null,null,null,null,null,null,null,'dark_elf_race'),
       (9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'starter bow'),
       (10,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'starter archer armour'),
       (11,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'starter sword'),
       (12,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'starter warrior armour'),
       (13,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'starter staff'),
       (14,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'starter mage armour'),
       (15,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'starter arrows'),
       (16,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'starter shield'),
       (17,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'starter magic');

INSERT into base_stats(id, agility, armour, block_chance, crit_chance, crit_damage, damage, endurance, evasion_chance, exp, gold, health, intelligence, luck, speed, strength,name)
VALUES (1,2,null,0,2,2,2,null,2,null,null,2,null,2,2,null,'archer_class'),
       (2,null,3,2,2,null,null,3,0,null,null,4,null,null,null,2,'warrior_class'),
       (3,1,1,0,0.1,20,10,10,0.01,1,1,80,5,1,1,1,'mage_class'),
       (4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'human_race'),
       (5,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,'orc_race'),
       (6,0,0,2,0,0,0,0,0,0,2,0,0,0,0,2,'dwarf_race'),
       (7,3,0,0,0,0,0,0,2,0,0,0,0,0,0,0,'elf_race'),
       (8,2,0,0,0,0,0,0,3,0,0,0,0,2,0,0,'dark_elf_race'),
       (9,1,0,0,5,5,20,5,0,0,0,0,0,3,3,0,'starter bow'),
       (10,5,5,0,0,0,0,5,5,0,0,100,0,0,3,0,'starter archer armour'),
       (11,0,0,0,3,5,30,10,0,0,0,0,0,1,1,5,'starter sword'),
       (12,0,20,0,0,0,0,0,0,0,0,200,0,0,0,5,'starter warrior armour'),
       (13,0,0,0,5,20,50,0,0,0,0,0,5,3,0,0,'starter staff'),
       (14,0,5,0,0,0,0,0,0,0,0,50,5,0,2,1,'starter mage armour'),
       (15,5,0,0,3,10,5,0,0,0,0,0,0,3,0,0,'starter arrows'),
       (16,0,10,10,0,0,0,0,0,0,0,100,0,0,0,0,'starter shield'),
       (17,0,0,0,5,5,5,0,0,0,0,20,5,3,1,0,'starter magic');



INSERT into classes (id, armour_type, first_weapon_type, name, second_weapon_type, base_buffs_id, base_stats_id)
VALUES (1,'archer','bow','Archer','arrows',1,1 ) ,
       (2,'warrior','sword','Warrior','shield',2,2),
       (3,'mage','staff','Mage','magic',3,3 );

insert into races(id, name, base_buffs_id, base_stats_id)
VALUES (1,'dwarf_race',8,6),
       (2,'human_race',5,4),
       (3,'orc_race',4,5),
       (4,'elf_race',7,7),
       (5,'dark_elf_race',6,8);

insert into items_definition(id, item_type, name, rarity, base_buffs_id, base_stats_id, class_id)
VALUES (1,'bow','starter bow',75,9,9,1),
       (2,'sword','starter sword',75,11,11,2),
       (3,'staff','starter staff',75,13,13,3),
       (4,'armour','starter archer armour',75,10,10,1),
       (5,'armour','starter warrior armour',75,12,12,2),
       (6,'armour','starter mage armour',75,14,14,3),
       (7,'arrows','starter arrows',75,15,15,1),
       (8,'shield','starter shield',75,16,16,2),
       (9,'magic','starter magic',75,17,17,3);

