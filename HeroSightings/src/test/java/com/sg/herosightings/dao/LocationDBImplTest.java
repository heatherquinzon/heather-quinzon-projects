/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.herosightings.dao;

import com.sg.herosightings.dto.HeroVillain;
import com.sg.herosightings.dto.Location;
import com.sg.herosightings.dto.Organization;
import com.sg.herosightings.dto.Sightings;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author heath
 */
@RunWith(SpringJUnit4ClassRunner.class) //Actually loads up the beans
@ContextConfiguration(locations = "classpath:test-applicationContext.xml") //Says which beans to create
public class LocationDBImplTest {

    @Inject
    OrgDao oDao;

    @Inject
    HVDao hvDao;

    @Inject
    LocationDao lDao;

    @Inject
    SightingsDao sDao;

    public LocationDBImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Organization> orgList = oDao.getAllOrganization();
        for (Organization o : orgList) {
            oDao.removeOrganization(o.getOrganizationId());
        }
        List<HeroVillain> hvList = hvDao.getAllHeroVillains();
        for (HeroVillain hv : hvList) {
            hvDao.removeHeroVillain(hv.getHeroVillainId());
        }
        List<Location> lList = lDao.getAllLocation();
        for (Location l : lList) {
            lDao.removeLocation(l.getLocationId());
        }
        List<Sightings> sList = sDao.getAllSightings();
        for (Sightings s : sList) {
            sDao.removeSightings(s.getSightingsId());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAddRemoveLocation() {
        LocalDate localDate = LocalDate.parse("2018-10-03",
                DateTimeFormatter.ISO_LOCAL_DATE);
        
        //ADD LOCATION
        Location loc = new Location();
        loc.setName("SGuild");
        loc.setDescription("School");
        loc.setLongitude("20.232323");
        loc.setLattitude("30.232323");
        loc.setCity("Minneapolis");
        loc.setStateInitial("MN");
        loc.setZipcode("55402");
        loc = lDao.addLocation(loc);

        //ADD SIGHTINGS
        Sightings s = new Sightings();
        s.setLocation(loc);
        s.setDate(localDate);
        s = sDao.addSightings(s);
        List<Sightings> sights = new ArrayList<>();
        sights.add(s);

        //ADD HERO
        HeroVillain hv = new HeroVillain();
        hv.setName("SpoodyMan");
        hv.setDescription("Shoots Webs");
        hv.setPower("Webslinger");
        hv.setType("Hero");
        hv.setSightings(sights);
        hv = hvDao.addHeroVillan(hv);
        
        Location fromDao = lDao.getLocationById(loc.getLocationId());

        assertEquals(fromDao, loc);

        lDao.removeLocation(loc.getLocationId());

        assertNull(lDao.getLocationById(loc.getLocationId()));
    }

    @Test
    public void updateLocation() {
        Location loc = new Location();
        loc.setName("SGuild");
        loc.setDescription("School");
        loc.setLongitude("20.232323");
        loc.setLattitude("30.232323");
        loc.setCity("Minneapolis");
        loc.setStateInitial("MN");
        loc.setZipcode("55402");
        lDao.addLocation(loc);

        loc.setCity("Winnetonka");
        lDao.updateLocation(loc);

        Location fromDao = lDao.getLocationById(loc.getLocationId());
        assertEquals(fromDao, loc);
    }

    @Test
    public void getAllLocation() {
        Location loc = new Location();
        loc.setName("SGuild");
        loc.setDescription("School");
        loc.setLongitude("20.232323");
        loc.setLattitude("30.232323");
        loc.setCity("Minneapolis");
        loc.setStateInitial("MN");
        loc.setZipcode("55402");
        lDao.addLocation(loc);

        Location loc2 = new Location();
        loc2.setName("SGuild");
        loc2.setDescription("School");
        loc2.setLongitude("20.232323");
        loc2.setLattitude("30.232323");
        loc2.setCity("Minneapolis");
        loc2.setStateInitial("MN");
        loc2.setZipcode("55402");
        lDao.addLocation(loc2);
        
        List<Location> locList = lDao.getAllLocation();
        
        assertEquals(locList.size(), 2);
    }
    
    @Test
    public void getLocationsByHeroVillainID(){
        LocalDate localDate = LocalDate.parse("2018-10-03",
                DateTimeFormatter.ISO_LOCAL_DATE);

        //ADD LOCATION
        Location loc = new Location();
        loc.setName("SGuild");
        loc.setDescription("School");
        loc.setLongitude("20.232323");
        loc.setLattitude("30.232323");
        loc.setCity("Minneapolis");
        loc.setStateInitial("MN");
        loc.setZipcode("55402");
        loc = lDao.addLocation(loc);

        //ADD SIGHTINGS
        Sightings s = new Sightings();
        s.setLocation(loc);
        s.setDate(localDate);
        s = sDao.addSightings(s);
        List<Sightings> sights = new ArrayList<>();
        sights.add(s);

        //ADD ORGANIZATION
        Organization org = new Organization();
        org.setName("All Evil Corp");
        org.setDescription("All Evil Mwahaha");
        org.setPhone("666-999-6699");
        org.setEmail("evil@crop.com");
        org.setCity("Minneapolis");
        org.setStateInitial("MN");
        org.setZipcode("55402");
        org = oDao.addOrganization(org);
        List<Organization> orgs = new ArrayList<>();
        orgs.add(org);

        HeroVillain hv = new HeroVillain();
        hv.setName("SpoodyMan");
        hv.setDescription("Shoots Webs");
        hv.setPower("Webslinger");
        hv.setType("Hero");
        hv.setOrgs(orgs);
        hv.setSightings(sights);
        hv = hvDao.addHeroVillan(hv);
        
        List<Location> locList = lDao.getLocationsByHeroVillainId(hv.getHeroVillainId());
        
        assertEquals(locList.size(), 1);
    }
}
