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

import javax.validation.constraints.Pattern;

import models.Account;
import models.Application;
import models.DbData;
import models.ParticipantListItem;
import models.User;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.mindrot.jbcrypt.BCrypt;

public class UserFormData implements FormData
{

	private List<Account> accounts;
	private List<Application> applications;
	/**
	 * the user's city
	 */
	@NotEmpty
	private String city;
	/**
	 * the user's email-address
	 */
	@NotEmpty
	@Email
	private String email;
	/**
	 * the user's first name
	 */
	@NotEmpty
	private String firstName;

	/**
	 * the user's matricle number
	 */
	@NotEmpty
	private String matricleNo;
	private List<ParticipantListItem> participationList;
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
	 * the user's postal code
	 */
	@NotEmpty
	@Pattern(regexp = "\\d+")
	private String postal;
	/**
	 * the user's role (applicant, stura-member, etc.)
	 */
	private Integer role;
	/**
	 * the user's street name
	 */
	@NotEmpty
	private String street;

	/**
	 * the user's street number
	 */
	@NotEmpty
	private String streetNo;

	/**
	 * the user's surname
	 */
	@NotEmpty
	private String surName;

	/**
	 * the user's telephone number
	 */
	@NotEmpty
	private String telephoneNo;

	public UserFormData()
	{
	}

	public boolean checkPw(String passWord)
	{
		return BCrypt.checkpw(passWord, this.getPassword());
	}

	public List<Account> getAccounts()
	{
		return accounts;
	}

	public List<Application> getApplications()
	{
		return applications;
	}


	public UserFormData(List<Account> accounts, List<Application> applications, String city, String email,
			String firstName, String matricleNo, List<ParticipantListItem> participationList, String password,
			String password2, String postal, Integer role, String street, String streetNo, String surName,
			String telephoneNo)
	{
		super();
		this.accounts = accounts;
		this.applications = applications;
		this.city = city;
		this.email = email;
		this.firstName = firstName;
		this.matricleNo = matricleNo;
		this.participationList = participationList;
		this.password = password;
		this.password2 = password2;
		this.postal = postal;
		this.role = role;
		this.street = street;
		this.streetNo = streetNo;
		this.surName = surName;
		this.telephoneNo = telephoneNo;
	}

	public String getCity()
	{
		return city;
	}

	public String getEmail()
	{
		return email;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getMatricleNo()
	{
		return matricleNo;
	}

	public List<ParticipantListItem> getParticipationList()
	{
		return participationList;
	}

	public String getPassword()
	{
		return password;
	}

	public String getPassword2()
	{
		return password2;
	}

	public String getPostal()
	{
		return postal;
	}

	public Integer getRole()
	{
		return role;
	}

	public String getStreet()
	{
		return street;
	}

	public String getStreetNo()
	{
		return streetNo;
	}

	public String getSurName()
	{
		return surName;
	}

	public String getTelephoneNo()
	{
		return telephoneNo;
	}

	public void hashPassword(String plainPass)
	{
		String crypt = BCrypt.hashpw(plainPass, BCrypt.gensalt());
		this.setPassword(crypt);
	}

	public String printOut()
	{
		return firstName + ", " + surName + ", " + matricleNo + ", " + role + ", " + password + ", ";
	}

	public void setAccounts(List<Account> accounts)
	{
		this.accounts = accounts;
	}

	public void setApplications(List<Application> applications)
	{
		this.applications = applications;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setMatricleNo(String matricleNo)
	{
		this.matricleNo = matricleNo;
	}

	public void setParticipationList(List<ParticipantListItem> participationList)
	{
		this.participationList = participationList;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public void setPassword2(String password2)
	{
		this.password2 = password2;
	}

	public void setPostal(String postal)
	{
		this.postal = postal;
	}

	public void setRole(Integer role)
	{
		this.role = role;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public void setStreetNo(String streetNo)
	{
		this.streetNo = streetNo;
	}

	public void setSurName(String surName)
	{
		this.surName = surName;
	}

	public void setTelephoneNo(String telephoneNo)
	{
		this.telephoneNo = telephoneNo;
	}

	@Override
	public DbData getAsDbData()
	{
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
