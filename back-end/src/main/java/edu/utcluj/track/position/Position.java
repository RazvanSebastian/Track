package edu.utcluj.track.position;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author radu.miron
 * @since 18.10.2016
 */
@Entity
public class Position {
	@Id
	@GeneratedValue
	@ApiModelProperty(hidden = true)
	private Long id;

	@NotNull
	@Size(min = 5, max = 10, message = "terminalId must be between 5 and 10 characters long")
	private String terminalId;

	@Column(name = "creation_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@ApiModelProperty(hidden = true)
	@JsonIgnore
	private Date createTime;

	@NotNull
	private String latitude;

	@NotNull
	private String longitude;

	public Position() {
		super();
	}

	public Position(String terminalId, Date createTime, String latitude, String longitude) {
		super();
		this.terminalId = terminalId;
		this.createTime = createTime;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
