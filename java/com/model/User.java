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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="[user]", catalog="[shcti]", schema="[dbo]")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "[name]")
	private String name;
	
	
	@Column(name = "[email]")
	private String email;
	
	@Column(name = "[password]")
	private String password;
	
	@Column(name = "[first_name]")
	private String first_name;
	
	@Column(name = "[last_name]")
	private String last_name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "[date_of_birth]")
	private Date date_of_birth;
	
	@Column(name = "[address]")
	private String address;
	
	@Column(name = "[contact_number]")
	private String contact_number;
	
	@Column(name = "[immunization_status]")
	private String immunization_status;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "[lastimmunization_date]")
	private Date lastimmunization_date;
	
	@Column(name = "[previous_health_conditions]")
	private String previous_health_conditions;
	
	@Column(name = "[immunization_form]")
	private String immunization_form;
	
	 @Column(name = "[reset_password_token]")
	 private String resetPasswordToken;
	 
	 @Column(name = "[ip_address]")
	 private String ipAddress;

	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "cust_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id") )
	Set<Role> roles = new HashSet<Role>();


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Role> getRole() {
		return roles;
	}

	public void setRole(Role role) {
		this.roles.add(role);
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
	
	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
}
