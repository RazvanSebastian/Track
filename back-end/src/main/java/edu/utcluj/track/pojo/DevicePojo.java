package edu.utcluj.track.pojo;

import java.util.Date;

public class DevicePojo {

	private String token;
	private String name;
	private Date registrationDate;

	public DevicePojo() {
		super();
	}

	public DevicePojo(String token, String name, Date registrationDate) {
		this.token = token;
		this.name = name;
		this.registrationDate = registrationDate;
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

}
