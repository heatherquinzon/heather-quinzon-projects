/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.herosightings.dao;

import com.sg.herosightings.dto.HeroVillain;
import com.sg.herosightings.dto.Organization;
import java.util.List;

/**
 *
 * @author heath
 */
public interface OrgDao {

    public Organization addOrganization(Organization org);

    public void removeOrganization(int orgId);

    public void updateOrganization(Organization org);

    public Organization getOrgById(int orgId);

    public List getAllOrganization();

}
