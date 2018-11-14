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
public class HVDBImplTest {

    @Inject
    OrgDao oDao;

    @Inject
    HVDao hvDao;

    @Inject
    LocationDao lDao;

    @Inject
    SightingsDao sDao;

    public HVDBImplTest() {
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
    public void getAddRemoveHero() {
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

        HeroVillain fromDao = hvDao.getHVById(hv.getHeroVillainId());

        assertEquals(fromDao, hv);

        hvDao.removeHeroVillain(hv.getHeroVillainId());
        assertNull(hvDao.getHVById(hv.getHeroVillainId()));
    }
    
    @Test
    public void updateHero(){
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

        //ADD HERO
        HeroVillain hv = new HeroVillain();
        hv.setName("SpoodyMan");
        hv.setDescription("Shoots Webs");
        hv.setPower("Webslinger");
        hv.setType("Hero");
        hv.setOrgs(orgs);
        hv.setSightings(sights);
        hv = hvDao.addHeroVillan(hv);
        
        //UPDATE HERO
        hv.setName("SpiderMan");
        hvDao.updateHeroVillan(hv);
        
        HeroVillain fromDao = hvDao.getHVById(hv.getHeroVillainId());

        assertEquals(fromDao, hv);
    }
    

    @Test
    public void getAllHeros() {
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

        List<HeroVillain> hvList = hvDao.getAllHeroVillains();

        assertEquals(hvList.size(), 1);
    }

    @Test
    public void getAllHerosByOrgId() {
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
        
        HeroVillain hv2 = new HeroVillain();
        hv2.setName("Deadpool");
        hv2.setDescription("Mercenary");
        hv2.setPower("He cant die");
        hv2.setType("Hero");
        hv2.setOrgs(orgs);
        hv2.setSightings(sights);
        hv2 = hvDao.addHeroVillan(hv2);
        
        List<HeroVillain> hvList = hvDao.getAllMembersByOrgId(org.getOrganizationId());
        
        assertEquals(hvList.size(), 2);
    }

    @Test
    public void getAllHerosByLocId() {
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
        
        HeroVillain hv2 = new HeroVillain();
        hv2.setName("Deadpool");
        hv2.setDescription("Mercenary");
        hv2.setPower("He cant die");
        hv2.setType("Hero");
        hv2.setOrgs(orgs);
        hv2.setSightings(sights);
        hv2 = hvDao.addHeroVillan(hv2);
        
        List<HeroVillain> hvList = hvDao.getAllHeroVillainByLocationId(loc.getLocationId());
        
        assertEquals(hvList.size(), 2);
    }

}
