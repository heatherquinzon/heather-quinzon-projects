use superdb_test;

select hv.*
from herovillain hv 
join hvorg ho on hv.id = ho.herovillainid
where ho.orgid = 1;

select hv.* 
from herovillain hv 
join hvsightings hs on hv.id = hs.heroVillainId
join sightings s on hs.sightingsId = s.id
join location l on s.locationId = l.id
where l.id = 1;

select l.*
from location l
join sightings s on l.id = s.locationId
join hvsightings hs on s.id = hs.sightingsid
join herovillain hv on hs.heroVillainId = hv.id
where hv.id = 1;