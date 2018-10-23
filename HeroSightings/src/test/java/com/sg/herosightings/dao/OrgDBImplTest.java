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
public class OrgDBImplTest {

    @Inject
    OrgDao oDao;

    @Inject
    HVDao hvDao;

    @Inject
    LocationDao lDao;

    @Inject
    SightingsDao sDao;

    public OrgDBImplTest() {
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
    public void addGetRemoveOrg() {
        Organization org = new Organization();
        org.setName("All Evil Corp");
        org.setDescription("All Evil Mwahaha");
        org.setPhone("666-999-6699");
        org.setEmail("evil@crop.com");
        org.setCity("Minneapolis");
        org.setStateInitial("MN");
        org.setZipcode("55402");

        oDao.addOrganization(org);

        Organization fromDao = oDao.getOrgById(org.getOrganizationId());

        assertEquals(fromDao, org);

        oDao.removeOrganization(org.getOrganizationId());

        assertNull(oDao.getOrgById(org.getOrganizationId()));
    }

    @Test
    public void updateOrg() {
        Organization org = new Organization();
        org.setName("All Evil Corp");
        org.setDescription("All Evil Mwahaha");
        org.setPhone("666-999-6699");
        org.setEmail("evil@crop.com");
        org.setCity("Minneapolis");
        org.setStateInitial("MN");
        org.setZipcode("55402");
        oDao.addOrganization(org);

        org.setName("Super Evil Corp");
        oDao.updateOrganization(org);

        Organization fromDao = oDao.getOrgById(org.getOrganizationId());

        assertEquals(fromDao, org);
    }
    
    @Test
    public void getAllOrg() {
        Organization org = new Organization();
        org.setName("All Evil Corp");
        org.setDescription("All Evil Mwahaha");
        org.setPhone("666-999-6699");
        org.setEmail("evil@crop.com");
        org.setCity("Minneapolis");
        org.setStateInitial("MN");
        org.setZipcode("55402");
        oDao.addOrganization(org);

        Organization org2 = new Organization();
        org2.setName("All Good Corp");
        org2.setDescription("Everything Good");
        org2.setPhone("000-111-1212");
        org2.setEmail("good@crop.com");
        org2.setCity("Minneapolis");
        org2.setStateInitial("MN");
        org2.setZipcode("55402");
        oDao.addOrganization(org2);

        List<Organization> orgList = oDao.getAllOrganization();

        assertEquals(orgList.size(), 2);
    }
    
}
