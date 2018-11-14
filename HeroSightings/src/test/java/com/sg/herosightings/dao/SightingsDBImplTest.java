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

        LocalDate localDate = LocalDate.parse("2018-10-03",
                DateTimeFormatter.ISO_LOCAL_DATE);

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
        s.setDate(localDate);
        sDao.addSightings(s);
        List<Sightings> sights = new ArrayList<>();
        sights.add(s);

        HeroVillain hv = new HeroVillain();
        hv.setName("SpoodyMan");
        hv.setDescription("Shoots Webs");
        hv.setPower("Webslinger");
        hv.setType("Hero");
        hv.setSightings(sights);
        hv = hvDao.addHeroVillan(hv);

        Sightings fromDao = sDao.getSightingsById(s.getSightingsId());

        assertEquals(fromDao, s);

        sDao.removeSightings(s.getSightingsId());

        assertNull(sDao.getSightingsById(s.getSightingsId()));
    }

    @Test
    public void updateSightings() {
        LocalDate localDate = LocalDate.parse("2018-10-03",
                DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate localDate2 = LocalDate.parse("2018-10-03",
                DateTimeFormatter.ISO_LOCAL_DATE);

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
        s.setDate(localDate);
        sDao.addSightings(s);

        s.setDate(localDate2);
        sDao.updateSightings(s);

        Sightings fromDao = sDao.getSightingsById(s.getSightingsId());

        assertEquals(fromDao, s);
    }

    @Test
    public void getAllSightings() {

        LocalDate localDate = LocalDate.parse("2018-10-02",
                DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate localDate2 = LocalDate.parse("2018-09-02",
                DateTimeFormatter.ISO_LOCAL_DATE);

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
        s.setDate(localDate);
        sDao.addSightings(s);

        Sightings s2 = new Sightings();
        s2.setLocation(loc);
        s2.setDate(localDate2);
        sDao.addSightings(s2);

        List<Sightings> sList = sDao.getAllSightings();

        assertEquals(sList.size(), 2);
    }

    @Test
    public void getAllSightingsByDate() {

        LocalDate localDate = LocalDate.parse("2018-10-03",
                DateTimeFormatter.ISO_LOCAL_DATE);

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
        s.setDate(localDate);
        sDao.addSightings(s);

        List<Sightings> sListByDate = sDao.getllAllSightingsByDate(localDate);

        assertEquals(sListByDate.size(), 1);
    }

}
