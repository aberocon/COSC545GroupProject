package com.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="[patients]", catalog="[shcti]", schema="[dbo]")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "[first_name]")
	private String firstname;
	
	@Column(name = "[last_name]")
	private String lastname;
	
	@Column(name = "[date_of_birth]")
	private Date dob;
	
	@Column(name = "[address]")
	private String address;
	
	@Column(name = "[contact_number]")
	private String phonenumber;
	
	@Column(name = "[Email]")
	private String email;
	
	@Column(name = "[immunization_status]")
	private String immunizationstatus;
	
	@Column(name = "[lastimmunization_date]")
	private Date lastimmunizationdate;
	
	@Column(name = "[previous_health_conditions]")
	private String previousHealthConditions;
	
	@Column(name = "[immunization_form]")
	private String immunizationForm;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private User user;
  
	// Getters and setters for all fields

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImmunizationstatus() {
		return immunizationstatus;
	}

	public void setImmunizationstatus(String immunizationstatus) {
		this.immunizationstatus = immunizationstatus;
	}

	public Date getLastimmunizationdate() {
		return lastimmunizationdate;
	}

	public void setLastimmunizationdate(Date lastimmunizationdate) {
		this.lastimmunizationdate = lastimmunizationdate;
	}

	public String getPreviousHealthConditions() {
		return previousHealthConditions;
	}

	public void setPreviousHealthConditions(String previousHealthConditions) {
		this.previousHealthConditions = previousHealthConditions;
	}

	public String getImmunizationForm() {
		return immunizationForm;
	}

	public void setImmunizationForm(String immunizationForm) {
		this.immunizationForm = immunizationForm;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
