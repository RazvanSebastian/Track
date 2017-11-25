package edu.utcluj.track.dao;

public class DeviceDao {
	private String email;
	private String password;
	private String token;

	public DeviceDao() {
		super();
	}

	public DeviceDao(String email, String password, String deviceId) {
		super();
		this.email = email;
		this.password = password;
		this.token = deviceId;
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

}
