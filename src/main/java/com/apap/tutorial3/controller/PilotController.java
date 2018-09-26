package com.apap.tutorial3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial3.model.PilotModel;
import com.apap.tutorial3.service.PilotService;

public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/pilot/add")
	public String add(@RequestParam(value="id", required = true) String id,
					  @RequestParam(value="licenseNumber", required = true) String licenseNumber,
					  @RequestParam(value="name", required = true) String name,
					  @RequestParam(value="flyHour", required = true) int flyHour) {
		PilotModel pilot = new PilotModel(id,licenseNumber,name,flyHour);
		pilotService.addPilot(pilot);
		return "add";
		
	}
	

}
