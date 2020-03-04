# Service Oriented Architecture Assignment
rest service with conditional get

### SQL used to create the database
##### This table will store characters and values such as name, race, class, level and name of their campaign
```
CREATE TABLE characters 
(
    id INT, 
    name varchar(50),
    race varchar(25),
    player_class varchar(30),
    level INT,
    campaign_name varchar(50)
)

insert into characters values(1,'Thoradin Frostbeard','Dwarf','Cleric',3,'Alteria');
insert into characters values(2,'Zandariel','Wood Elf','Ranger',3,'Alteria');
insert into characters values(3,'Merc','Firbolg','Druid',4,'Alteria');
insert into characters values(4,'Alizaar Ragthrokar','DragonBorn','Paladin',4,'Alteria');
insert into characters values(5,'Garrus Frostbeard','Dwarf','Ranger',5,'Alteria');
insert into characters values(6,'Horken','Drow','Cleric',4,'Aetria: Overseeing an Invasion');
insert into characters values(7,'Miaq','Tabaxi','Monk',4,'Aetria: Overseeing an Invasion');
insert into characters values(8,'Micah','Human','Warlock',4,'Aetria: Overseeing an Invasion');
```




