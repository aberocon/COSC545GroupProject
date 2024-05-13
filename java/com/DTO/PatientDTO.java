package com.DTO;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.model.Role;


public class PatientDTO {
	
	
	private int id;
	private String name;
	private String email;
	private String password;
	private String first_name;
	private String last_name;
	private Date date_of_birth;
	private String address;
	private String contact_number;
	private String immunization_status;
	private Date lastimmunization_date;
	private String previous_health_conditions;
	private String immunization_form;
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
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
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getImmunization_status() {
		return immunization_status;
	}

	public void setImmunization_status(String immunization_status) {
		this.immunization_status = immunization_status;
	}

	public Date getLastimmunization_date() {
		return lastimmunization_date;
	}

	public void setLastimmunization_date(Date lastimmunization_date) {
		this.lastimmunization_date = lastimmunization_date;
	}

	public String getPrevious_health_conditions() {
		return previous_health_conditions;
	}

	public void setPrevious_health_conditions(String previous_health_conditions) {
		this.previous_health_conditions = previous_health_conditions;
	}

	public String getImmunization_form() {
		return immunization_form;
	}

	public void setImmunization_form(String immunization_form) {
		this.immunization_form = immunization_form;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
