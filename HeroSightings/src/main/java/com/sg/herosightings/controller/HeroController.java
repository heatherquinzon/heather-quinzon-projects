/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.herosightings.controller;

import com.sg.herosightings.dao.HVDao;
import com.sg.herosightings.dao.LocationDao;
import com.sg.herosightings.dao.OrgDao;
import com.sg.herosightings.dao.SightingsDao;
import com.sg.herosightings.dto.HeroVillain;
import com.sg.herosightings.dto.Location;
import com.sg.herosightings.dto.Organization;
import com.sg.herosightings.dto.Sightings;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author heath
 */
@Controller
public class HeroController {

    @Inject
    OrgDao oDao;

    @Inject
    HVDao hvDao;

    @Inject
    LocationDao lDao;

    @Inject
    SightingsDao sDao;

    //ALL HEROS XXXXXXXXXX
    //Display Hero Details XXX
    @GetMapping("/displayherodetails")
    public String displayHeroDetails(HttpServletRequest request, Model model) {
        String heroIdParamater = request.getParameter("heroId");
        int heroId = Integer.parseInt(heroIdParamater);

        HeroVillain hero = hvDao.getHVById(heroId);

        model.addAttribute("hero", hero);

        return "heroDetails";
    }

    //Display ALL Heros and Villains XXX
    @GetMapping("/displayherosandvillains")
    public String displayHerosPage(Model model) {
        List<HeroVillain> hvList = hvDao.getAllHeroVillains();
        model.addAttribute("hvList", hvList);

        List<Organization> oList = oDao.getAllOrganization();
        model.addAttribute("oList", oList);

        List<Sightings> sList = sDao.getAllSightings();
        model.addAttribute("sList", sList);

        return "hero";
    }

    //Delete Hero / Villain XXX
    @GetMapping("/deletehero")
    public String deleteHero(HttpServletRequest request) {
        String heroIdParameter = request.getParameter("heroId");
        int heroId = Integer.parseInt(heroIdParameter);
        hvDao.removeHeroVillain(heroId);
        return "redirect:displayherosandvillains";
    }

    //Create Hero / Villain (Missing Orgs)
    @PostMapping("/createHero")
    public String createHero(HttpServletRequest request) {

        HeroVillain hv = new HeroVillain();
        hv.setName(request.getParameter("name"));
        hv.setPower(request.getParameter("power"));
        hv.setType(request.getParameter("type"));
        hv.setDescription(request.getParameter("description"));

        String[] orgId = request.getParameterValues("orgId");
        List<Organization> oList = new ArrayList<>();
        for (String o : orgId) {
            int id = Integer.parseInt(o);
            Organization org = oDao.getOrgById(id);
            oList.add(org);
        }
        hv.setOrgs(oList);

        String[] sId = request.getParameterValues("sightingsId");
        List<Sightings> sList = new ArrayList<>();
        for (String s : sId) {
            int id = Integer.parseInt(s);
            Sightings sight = sDao.getSightingsById(id);
            sList.add(sight);
        }
        hv.setSightings(sList);

        hvDao.addHeroVillan(hv);

        return "redirect:displayherosandvillains";
    }

    //Display Edit Hero Form (Missing Orgs)
    @GetMapping("/displayeditheroform")
    public String displayEditHeroForm(HttpServletRequest request, Model model) {
        String heroIdParamater = request.getParameter("heroId");
        int heroId = Integer.parseInt(heroIdParamater);
        HeroVillain hero = hvDao.getHVById(heroId);
        model.addAttribute("hero", hero);

        List<Organization> oList = oDao.getAllOrganization();
        model.addAttribute("oList", oList);

        List<Sightings> sList = sDao.getAllSightings();
        model.addAttribute("sList", sList);

        return "editHeroForm";
    }

    //Edit Hero
    @PostMapping("/editHero")
    public String editHero(@Valid @ModelAttribute("hero") HeroVillain hero, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "editHeroForm";
        }
        
        String heroIdParamater = request.getParameter("heroVillainId");
        int heroId = Integer.parseInt(heroIdParamater);
        hero = hvDao.getHVById(heroId);
        hero.setName(request.getParameter("name"));
        hero.setPower(request.getParameter("power"));
        hero.setType(request.getParameter("type"));
        hero.setDescription(request.getParameter("description"));
        
        String[] orgId = request.getParameterValues("orgId");
        List<Organization> oList = new ArrayList<>();
        for (String o : orgId) {
            int id = Integer.parseInt(o);
            Organization org = oDao.getOrgById(id);
            oList.add(org);
        }
        hero.setOrgs(oList);
        
        String[] sId = request.getParameterValues("sightingsId");
        List<Sightings> sList = new ArrayList<>();
        for (String s : sId) {
            int id = Integer.parseInt(s);
            Sightings sight = sDao.getSightingsById(id);
            sList.add(sight);
        }
        hero.setSightings(sList);

        hvDao.updateHeroVillan(hero);

        return "redirect:displayherosandvillains";
    }

    //ALL ORGANIZATIONS XXXXXXXXXX
    //Display Org Details XXX
    @GetMapping("/displayorgdetails")
    public String displayOrgDetails(HttpServletRequest request, Model model) {
        String orgIdParameter = request.getParameter("orgId");
        int orgId = Integer.parseInt(orgIdParameter);

        Organization org = oDao.getOrgById(orgId);

        model.addAttribute("org", org);

        return "orgDetails";
    }

    //Display ALL Orgs XXX
    @GetMapping("/displayorganization")
    public String displayOrganizations(Model model) {
        List<Organization> oList = oDao.getAllOrganization();

        model.addAttribute("oList", oList);

        return "organization";
    }

    //Delete Org XXX
    @GetMapping("/deleteorg")
    public String deleteOrg(HttpServletRequest request) {
        String orgIdParameter = request.getParameter("orgId");
        int orgId = Integer.parseInt(orgIdParameter);

        oDao.removeOrganization(orgId);

        return "redirect:displayorganization";
    }

    //Create Org XXX
    @PostMapping("/createOrg")
    public String createOrg(HttpServletRequest request) {

        Organization org = new Organization();
        org.setName(request.getParameter("name"));
        org.setDescription(request.getParameter("description"));
        org.setPhone(request.getParameter("phone"));
        org.setEmail(request.getParameter("email"));
        org.setCity(request.getParameter("city"));
        org.setStateInitial(request.getParameter("stateInitial"));
        org.setZipcode(request.getParameter("zipcode"));

        oDao.addOrganization(org);

        return "redirect:displayorganization";
    }

    //Display Edit Org Form XXX
    @GetMapping("/displayeditorgform")
    public String displayEditOrgForm(HttpServletRequest request, Model model) {
        String orgIdParameter = request.getParameter("orgId");
        int orgId = Integer.parseInt(orgIdParameter);
        Organization org = oDao.getOrgById(orgId);
        model.addAttribute("org", org);
        return "editOrgForm";
    }

    //Edit Org XXX
    @PostMapping("/editOrg")
    public String editOrg(@Valid @ModelAttribute("org") Organization org, BindingResult result) {
        if (result.hasErrors()) {
            return "editOrgForm";
        }

        oDao.updateOrganization(org);

        return "redirect:displayorganization";
    }

    //ALL LOCATIONS XXXXXXXXXX
    //Display Loc Details XXX
    @GetMapping("/displaylocationdetails")
    public String displayLocationDetails(HttpServletRequest request, Model model) {
        String locationIdParameter = request.getParameter("locationId");
        int locationId = Integer.parseInt(locationIdParameter);

        Location location = lDao.getLocationById(locationId);

        model.addAttribute("location", location);

        return "locationDetails";
    }

    //Display ALL Locations XXX
    @GetMapping("/displaylocations")
    public String displayLocations(Model model) {
        List<Location> locList = lDao.getAllLocation();

        model.addAttribute("locList", locList);

        return "location";
    }

    //Delete Location XXX
    @GetMapping("/deletelocation")
    public String deleteLocation(HttpServletRequest request) {
        String locationIdParameter = request.getParameter("locationId");
        int locationId = Integer.parseInt(locationIdParameter);
        lDao.removeLocation(locationId);
        return "redirect:displaylocations";
    }

    //Create Location XXX
    @PostMapping("/createLocation")
    public String createLocation(HttpServletRequest request) {
        Location location = new Location();
        location.setName(request.getParameter("name"));
        location.setDescription(request.getParameter("description"));
        location.setLongitude(request.getParameter("longitude"));
        location.setLattitude(request.getParameter("lattitude"));
        location.setCity(request.getParameter("city"));
        location.setStateInitial(request.getParameter("stateInitial"));
        location.setZipcode(request.getParameter("zipcode"));

        lDao.addLocation(location);

        return "redirect:displaylocations";

    }

    //Display Location Form XXX
    @GetMapping("/displaylocationform")
    public String displayEditLocationForm(HttpServletRequest request, Model model) {
        String locationIdParameter = request.getParameter("locationId");
        int locationId = Integer.parseInt(locationIdParameter);

        Location location = lDao.getLocationById(locationId);

        model.addAttribute("location", location);

        return "editLocationForm";
    }

    //Edit Location XXX
    @PostMapping("/editLocation")
    public String editLocation(@Valid @ModelAttribute("location") Location location, BindingResult result) {
        if (result.hasErrors()) {
            return "editLocationForm";
        }

        lDao.updateLocation(location);

        return "redirect:displaylocations";
    }

    //ALL SIGHTINGS
    //Display Sightings Details XXX
    @GetMapping("/displaysightingdetails")
    public String displaySightingDetails(HttpServletRequest request, Model model) {
        String sightingIdParameter = request.getParameter("sightingsId");
        int sightingsId = Integer.parseInt(sightingIdParameter);

        Sightings sighting = sDao.getSightingsById(sightingsId);

        model.addAttribute("sighting", sighting);

        return "sightingDetails";
    }

    //Display ALL Sightings XXX
    @GetMapping("/displaysightings")
    public String displaySightings(Model model) {
        List<Sightings> sList = sDao.getAllSightings();
        model.addAttribute("sList", sList);
        
        List<Location> locList = lDao.getAllLocation();
        model.addAttribute("locList", locList);

        return "sightings";
    }

    //Delete Sighting XXX
    @GetMapping("/deletesighting")
    public String deleteSighting(HttpServletRequest request) {
        String sightingIdParameter = request.getParameter("sightingsId");
        int sightingsId = Integer.parseInt(sightingIdParameter);
        sDao.removeSightings(sightingsId);
        return "redirect:displaysightings";
    }

    //Create Sighting
    @PostMapping("/createSighting")
    public String createSighting(HttpServletRequest request) {
        Sightings sightings = new Sightings();
        
        LocalDate sDate = LocalDate.parse(request.getParameter("date"));
        sightings.setDate(sDate);
        
        String locationIdParameter = request.getParameter("locName");
        int locId = Integer.parseInt(locationIdParameter);
        Location loc = lDao.getLocationById(locId);
        sightings.setLocation(loc);

        sDao.addSightings(sightings);

        return "redirect:displaysightings";
    }

    //Edit Sighting Form
    @GetMapping("/displayeditsightingform")
    public String displayEditSightingForm(HttpServletRequest request, Model model) {
        String sightingIdParameter = request.getParameter("sightingsId");
        int sightingsId = Integer.parseInt(sightingIdParameter);
        Sightings sighting = sDao.getSightingsById(sightingsId);
        
        List<Location> locList = lDao.getAllLocation();
        model.addAttribute("locList", locList);

        model.addAttribute("sighting", sighting);

        return "editSightingForm";
    }

    //Edit Sighting XXX
    @PostMapping("/editSighting")
    public String editSighting(@Valid @ModelAttribute("sighting") Sightings sighting, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "editSightingForm";
        }

        String sightingIdParameter = request.getParameter("sightingsId");
        int sightingsId = Integer.parseInt(sightingIdParameter);
        
        LocalDate sDate = LocalDate.parse(request.getParameter("date"));
        sighting.setDate(sDate);
        
        String locationIdParameter = request.getParameter("locName");
        int locId = Integer.parseInt(locationIdParameter);
        Location loc = lDao.getLocationById(locId);
        sighting.setLocation(loc);
        
        sDao.updateSightings(sighting);

        return "redirect:displaysightings";
    }
    
    @GetMapping(value = {"/", "/home"})
    public String displayHomePage(Model model){
        List<Sightings> sList = sDao.getTenLatestSightings();
        model.addAttribute("sList", sList);
        
        List<Location> locList = lDao.getAllLocation();
        model.addAttribute("locList", locList);
        
        List<HeroVillain> hvList = hvDao.getAllHeroVillains();
        model.addAttribute("hvList", hvList);
        
        return "index";
    }
            
}
