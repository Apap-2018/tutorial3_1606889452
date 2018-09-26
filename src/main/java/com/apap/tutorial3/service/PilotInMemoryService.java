package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import com.apap.tutorial3.model.PilotModel;

public class PilotInMemoryService implements PilotService {
	private List<PilotModel> archivePilot;
	

	public PilotInMemoryService() {
		archivePilot = new ArrayList<>();
	}

	public void addPilot(PilotModel pilot) {
		archivePilot.add(pilot);
	}

	public List<PilotModel> getPilotList() {
		return archivePilot;
	}

	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		for (PilotModel pilot : archivePilot) {
			if (pilot.getLicenseNumber().equals(licenseNumber)){
				return pilot;
			}
		}
		return null;
	}

}
