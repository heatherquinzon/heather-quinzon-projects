use superdb;

-- Gets all heros sighted at a particular location
-- select hv.`name` 
-- from herovillain hv 
-- join hvsightings hs on hv.id = hs.heroVillainId
-- join sightings s on hs.sightingsId = s.id
-- join location l on s.locationId = l.id
-- where l.id = 1;

-- Gets all locations where a hero has been seen
-- select l.`name`
-- from location l
-- join sightings s on l.id = s.locationId
-- join hvsightings hs on s.id = hs.sightingsid
-- join herovillain hv on hs.heroVillainId = hv.id
-- where hv.id = 1;

-- Gets all hero and location sightings for a particular date
-- select hv.`name`, l.`name`
-- from hvsightings hs
-- join herovillain hv on hs.heroVillainId = hv.id
-- join sightings s on hs.sightingsId = s.id
-- join location l on s.locationId = l.id
-- where s.`date` = '2018-03-22'; 

-- Gets all members of an org
-- select hv.`name`
-- from hvorg ho
-- join herovillain hv on ho.heroVillainId = hv.id
-- join org o on ho.orgId = o.id
-- where o.`name` = "SuperEvil";

-- Gets all org name a hero is part of
-- select o.`name`
-- from org o 
-- join hvorg hv on o.id = hv.id
-- where hv.herovillainid = 1;