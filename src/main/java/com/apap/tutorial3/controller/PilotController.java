package com.apap.tutorial3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial3.model.PilotModel;
import com.apap.tutorial3.service.PilotService;

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/pilot/add")
	public String add(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "licenseNumber", required = true) String licenseNumber,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "flyHour", required = true) int flyHour) {
		
		PilotModel pilot = new PilotModel(id, licenseNumber, name, flyHour);
		
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping("/pilot/view")
	public String view(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel archive = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		
		model.addAttribute("pilot", archive);
		return "view-pilot";
	}
	
	@RequestMapping("/pilot/viewall")
	public String viewAll(Model model) {
		List<PilotModel> archive = pilotService.getPilotList();
		model.addAttribute("listPilot", archive);
		return "viewall-pilot";
	}
	
	@RequestMapping(value = {"pilot/view/license-number/{licenseNumber}","/pilot/view/license-number"})
	public String viewPath(@PathVariable String licenseNumber, Model model) {
		PilotModel match = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		if (match != null) {
			model.addAttribute("pilot",match);
		}
		else {
			return "error-page";
		}
		return "view-pilot";
		
	}
	@RequestMapping(value= {"/pilot/update/license-number/{licenseNumber}/fly-hour/{flyHour}"})
	public String updateFlyHour(@PathVariable Optional<String> licenseNumber, @PathVariable Optional<String> flyHour, Model model) {
		
		if (licenseNumber.isPresent() ) {
			PilotModel match = pilotService.getPilotDetailByLicenseNumber(licenseNumber.get());
			
			if (match != null) {
				match.setFlyHour(Integer.parseInt(flyHour.get()));
				model.addAttribute("pilot", match);
				return "update";
				
			}
			
		}
		return "error-page";
	}
	
	@RequestMapping(value = {"/pilot/delete/id/{id}", "/pilot/delete/id/"})
	public String deletePilot(@PathVariable Optional<String> id,
								Model model) {
		if (id.isPresent()) {
			PilotModel match = pilotService.getPilotDetailByID(id.get());
			if (match != null) {
				pilotService.getPilotList().remove(match);
				return "delete";
			}
		}
		return "error-page";
	}
}
