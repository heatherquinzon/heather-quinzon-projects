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
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author heath
 */
@RunWith(SpringJUnit4ClassRunner.class) //Actually loads up the beans
@ContextConfiguration(locations = "classpath:test-applicationContext.xml") //Says which beans to create
public class SightingsDBImplTest {

    @Inject
    OrgDao oDao;

    @Inject
    HVDao hvDao;

    @Inject
    LocationDao lDao;

    @Inject
    SightingsDao sDao;

    public SightingsDBImplTest() {
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
    public void addGetRemoveSighting() {

        Location loc = new Location();
        loc.setName("SGuild");
        loc.setDescription("School");
        loc.setLongitude("20.232323");
        loc.setLattitude("30.232323");
        loc.setCity("Minneapolis");
        loc.setStateInitial("MN");
        loc.setZipcode("55402");
        lDao.addLocation(loc);

        Sightings s = new Sightings();
        s.setLocation(loc);
        s.setDate(java.sql.Date.valueOf("2018-10-22"));
        sDao.addSightings(s);

        Sightings fromDao = sDao.getSightingsById(s.getSightingsId());

        assertEquals(fromDao, s);
        
        lDao.removeLocation(loc.getLocationId());
        sDao.removeSightings(s.getSightingsId());

        assertNull(sDao.getSightingsById(s.getSightingsId()));
        assertNull(lDao.getLocationById(loc.getLocationId()));

    }

    @Test
    public void getAllSightings(){
        
    }
    
}
