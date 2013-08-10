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

package models.forms;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import models.Account;
import models.Application;
import models.ParticipantListItem;
import models.User;
import ninja.validation.Length;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.mindrot.jbcrypt.BCrypt;

@Entity
public class UserFormData
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * the user's first name
	 */
	@NotEmpty
	private String firstName;
	/**
	 * the user's surname
	 */
	@NotEmpty
	private String surName;
	/**
	 * the user's matricle number
	 */
	@NotEmpty
	private String matricleNo;
	/**
	 * the user's role (applicant, stura-member, etc.)
	 */
	private Integer role;
	/**
	 * the user's password
	 */
	@NotEmpty
	private String password;

	/**
	 * the user's password repetition
	 */
	@NotEmpty
	private String password2;
	/**
	 * the user's telephone number
	 */
	@NotEmpty
	private String telephoneNo;
	/**
	 * the user's postal code
	 */
	@NotEmpty
	@Pattern(regexp = "\\d+")
	private String postal;
	/**
	 * the user's street name
	 */
	@NotEmpty
	private String street;
	/**
	 * the user's city
	 */
	@NotEmpty
	private String city;
	/**
	 * the user's street number
	 */
	@NotEmpty
	private String streetNo;
	/**
	 * the user's email-address
	 */
	@NotEmpty
	@Email
	private String email;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public List<Application> getApplications()
	{
		return applications;
	}

	public void setApplications(List<Application> applications)
	{
		this.applications = applications;
	}

	public List<Account> getAccounts()
	{
		return accounts;
	}

	public void setAccounts(List<Account> accounts)
	{
		this.accounts = accounts;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "applicant")
	private List<Application> applications;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Account> accounts;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "participant")
	private List<ParticipantListItem> participationList;

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getSurName()
	{
		return surName;
	}

	public void setSurName(String surName)
	{
		this.surName = surName;
	}

	public String getMatricleNo()
	{
		return matricleNo;
	}

	public void setMatricleNo(String matricleNo)
	{
		this.matricleNo = matricleNo;
	}

	public Integer getRole()
	{
		return role;
	}

	public void setRole(Integer role)
	{
		this.role = role;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPassword2()
	{
		return password2;
	}

	public void setPassword2(String password2)
	{
		this.password2 = password2;
	}

	public String getTelephoneNo()
	{
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo)
	{
		this.telephoneNo = telephoneNo;
	}

	public String getPostal()
	{
		return postal;
	}

	public void setPostal(String postal)
	{
		this.postal = postal;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getStreetNo()
	{
		return streetNo;
	}

	public void setStreetNo(String streetNo)
	{
		this.streetNo = streetNo;
	}

	public UserFormData()
	{
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void hashPassword(String plainPass)
	{
		String crypt = BCrypt.hashpw(plainPass, BCrypt.gensalt());
		this.setPassword(crypt);
	}

	public boolean checkPw(String passWord)
	{
		return BCrypt.checkpw(passWord, this.getPassword());
	}

	public String printOut()
	{
		return firstName + ", " + surName + ", " + matricleNo + ", " + role + ", " + password + ", ";
	}
	
	public User getAsUser(){
		User user = new User();
		
		user.setFirstName(firstName);
		user.setCity(city);
		user.setEmail(email);
		user.setMatricleNo(matricleNo);
		user.setPassword(password);
		user.setPostal(postal);
		user.setStreet(street);
		user.setStreetNo(streetNo);
		user.setSurName(surName);
		user.setTelephoneNo(telephoneNo);
		
		return user;
		
	}

}
