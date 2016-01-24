package org.springframework.social.microsoft.api;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MicrosoftProfile {

	private final String id;

	private final String name;

	@JsonProperty("first_name")
	private final String firstName;

	@JsonProperty("last_name")
	private final String lastName;

	private String link;

	private final String gender;
	
	private String locale;
	
	@JsonProperty("updated_time")
	private Date updatedTime;

	public MicrosoftProfile(String id, String name, String firstName, String lastName, String gender, String locale) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

}
