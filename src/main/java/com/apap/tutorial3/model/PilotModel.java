package com.apap.tutorial3.model;

public class PilotModel {
	private String id;
	private String licenseNumber;
	private String name;
	private Integer flyhour;
	
	public PilotModel(String id, String licenseNumber, String name, Integer flyhour) {
		super();
		this.id = id;
		this.licenseNumber = licenseNumber;
		this.name = name;
		this.flyhour = flyhour;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFlyhour() {
		return flyhour;
	}

	public void setFlyhour(Integer flyhour) {
		this.flyhour = flyhour;
	}
	
	

}
