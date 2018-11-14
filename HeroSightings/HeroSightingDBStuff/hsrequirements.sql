use superdb_test;

-- Gets all heros sighted at a particular location
-- select hv.* 
-- from herovillain hv 
-- join hvsightings hs on hv.id = hs.heroVillainId
-- join sightings s on hs.sightingsId = s.id
-- join location l on s.locationId = l.id
-- where l.id = 1;

-- Gets all locations where a hero has been seen
-- select l.*
-- from location l
-- join sightings s on l.id = s.locationId
-- join hvsightings hs on s.id = hs.sightingsid
-- join herovillain hv on hs.heroVillainId = hv.id
-- where hv.id = 1;

-- Gets all hero and location sightings for a particular date
-- select hv.*, l.*
-- from hvsightings hs
-- join herovillain hv on hs.heroVillainId = hv.id
-- join sightings s on hs.sightingsId = s.id
-- join location l on s.locationId = l.id
-- where s.`date` = '2018-03-22'; 

-- Gets all members of an org
-- select hv.*
-- from hvorg ho
-- join herovillain hv on ho.heroVillainId = hv.id
-- join org o on ho.orgId = o.id
-- where o.`name` = "SuperEvil";

-- Gets all org name a hero is part of
-- select o.*
-- from org o 
-- join hvorg ho on o.id = ho.orgId
-- where ho.herovillainid = 1;

-- Get all sightings for a hero by heroid
-- select s.* 
-- from sightings s
-- join hvsightings hs on s.id = hs.sightingsId
-- where hs.herovillainid = 1;

-- Order hero sightings by 10 latest date
-- select hv.`name`, l.`name`, s.`date`
-- from hvsightings hs
-- join sightings s on hs.sightingsId = s.id
-- join herovillain hv on hs.heroVillainId = hv.id
-- join location l on s.locationId = l.id
-- order by s.`date` desc
-- limit 0,10;

-- Order ten lates sightings by date
-- select s.* from sightings s
-- join hvsightings hs on s.id = hs.sightingsId
-- order by s.`date` desc
-- limit 0,10;
