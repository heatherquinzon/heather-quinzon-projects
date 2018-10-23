use superdb;

-- insert into herovillain(`name`, `description`, power, `type`)
-- values("Spoodyman", "Some dude throwing webs", "Web-slinger", "Hero");

-- insert into org(`name`, `description`, phone, email, city, stateInitial, zipcode)
-- values("SuperEvil", "All Evil Corporation", "6669996969", "evil@corp.cp,", "Minneapolis", "MN", "55402");

-- insert into hvorg(herovillainId, orgId)
-- values(1, 1);

-- insert into org(`name`, `description`, phone, email, city, stateInitial, zipcode)
-- values("SuperHero", "All Hero Corporation", "0001112222", "hero@corp.cp,", "Minneapolis", "MN", "55402");

-- insert into hvorg(herovillainId, orgId)
-- values(1, 2);

-- insert into location(`name`, `description`, longitude, lattitude, city, stateInitial, zipcode)
-- values("Spyhouse", "Hipster coffee shop w/ expensive coffee", 28.19029, 29.208328, "Minneapolis", "MN", "55402");

-- insert into sightings(locationId, `date`)
-- values(1, '2018-09-18');

-- insert into hvsightings(sightingsId, herovillainId)
-- values(1, 1);

-- insert into herovillain(`name`, `description`, power, `type`)
-- values("DongerDude", "Dude that dongs", "Idrk tbh", "Hero");

-- insert into hvsightings(sightingsId, herovillainId)
-- values(1, 2);

-- insert into location(`name`, `description`, longitude, lattitude, city, stateInitial, zipcode)
-- values("The SoftwareGuild", "Tall Building", 59.19029, 39.208328, "Minneapolis", "MN", "55402");

-- insert into sightings(locationId, `date`)
-- values(2, '2018-03-22');

-- insert into hvsightings(sightingsId, herovillainId)
-- values(2, 1);

-- insert into sightings(locationId, `date`)
-- values(1, '2018-03-22');

-- insert into hvsightings(sightingsId, herovillainId)
-- values(3, 2);

-- insert into hvorg(herovillainId, orgId)
-- values(2, 1);