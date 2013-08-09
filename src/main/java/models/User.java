/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.mindrot.jbcrypt.BCrypt;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	/**
	 * the user's first name
	 */
	private String firstName;
	/**
	 * the user's surname
	 */
	private String surName;
	/**
	 * the user's matricle number
	 */
	private String matricleNo;
	/**
	 * the user's role (applicant, stura-member, etc.)
	 */
	private Integer role;
	/**
	 * the user's password
	 */
	private String password;
	/**
	 * the user's telephone number
	 */
	private String telephoneNo;
	/**
	 * the user's postal code
	 */
	private String postal;
	/**
	 * the user's street name
	 */
	private String street;
	/**
	 * the user's city
	 */
	private String city;
	/**
	 * the user's street number
	 */
	private String streetNo;
	/**
	 * the user's email-address
	 */
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getMatricleNo() {
		return matricleNo;
	}

	public void setMatricleNo(String matricleNo) {
		this.matricleNo = matricleNo;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public User() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void hashPassword(String plainPass) {
		String crypt = BCrypt.hashpw(plainPass, BCrypt.gensalt());
		this.setPassword(crypt);
	}

	public boolean checkPw(String passWord) {
		return BCrypt.checkpw(passWord, this.getPassword());
	}

}
