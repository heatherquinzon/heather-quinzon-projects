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
import java.util.List;

/**
 *
 * @author heath
 */
public interface HVDao {

    public HeroVillain addHeroVillan(HeroVillain hv);

    public void removeHeroVillain(int heroVillainId);

    public void updateHeroVillan(HeroVillain hv);

    public HeroVillain getHVById(int heroVillainId);

    public List getAllHeroVillains();

    //gets all heros/villains by location id
    public List<HeroVillain> getAllHeroVillainByLocationId(int locationId);

    //gets all heros/villains from particular org id
    public List<HeroVillain> getAllMembersByOrgId(int orgId);

}
