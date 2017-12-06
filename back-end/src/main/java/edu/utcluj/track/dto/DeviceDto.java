package edu.utcluj.track.dto;

public class DeviceDto {
	private String email;
	private String password;
	private String name;
	private String token;

	public DeviceDto() {
		super();
	}

	public DeviceDto(String email, String password, String deviceId, String name) {
		super();
		this.email = email;
		this.password = password;
		this.token = deviceId;
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeviceToken() {
		return token;
	}

	public void setDeviceToken(String deviceId) {
		this.token = deviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
