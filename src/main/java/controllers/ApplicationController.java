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

package controllers;

import utils.DAOController;
import models.Account;
import models.Application;
import models.User;
import models.forms.AccountFormData;
import models.forms.ApplicationFormData;
import models.forms.UserFormData;
import ninja.Context;
import ninja.Result;
import ninja.Results;
import ninja.Router;
import ninja.i18n.Lang;
import ninja.validation.JSR303Validation;
import ninja.validation.Validation;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ApplicationController
{

	/**
	 * This is the system wide logger. You can still use any config you like. Or
	 * create your own custom logger.
	 * 
	 * But often this is just a simple solution:
	 */
	@Inject
	public org.slf4j.Logger logger;

	@Inject
	Router router;

	@Inject
	Lang lang;

	@Inject
	DAOController dao;

	public Result getIndex()
	{

		User u = new User();
		u.setCity("");
		u.setEmail("email");
		u.setFirstName("firstName");
		u.setMatricleNo("matricleNo");
		u.setPassword("password");
		u.setPostal("e");
		u.setRole(1);
		u.setStreet("street");
		u.setStreetNo("streetNo");
		u.setSurName("surName");
		u.setTelephoneNo("12");

		User u2 = new User();
		u2.setCity("ww");
		u2.setEmail("emaiwwl");
		u2.setFirstName("firstwwName");
		u2.setMatricleNo("matrwwicleNo");
		u2.setPassword("passwwword");
		u2.setPostal("ew");
		u2.setRole(1);
		u2.setStreet("strweet");
		u2.setStreetNo("stwreetNo");
		u2.setSurName("surNwame");
		u2.setTelephoneNo("1w2");
		dao.<User> persist(u);
		dao.<User> persist(u2);
		dao.<User> remove(u);
		User returned = dao.getSingleElement(User.class, u2.getId());
		System.out.println(returned);
		return Results.html();

	}

	/**
	 * Shows the User-Form <br/>
	 * GET /user
	 * 
	 * @return the user-form
	 */
	public Result userForm()
	{
		return Results.html();
	}

	/**
	 * Takes the post of the User-Form <br/>
	 * POST /user
	 * 
	 * @return to the user-form
	 */
	public Result postUserForm(Context context, @JSR303Validation UserFormData userData, Validation validation)
	{
		if (validation.hasViolations())
		{
			context.getFlashCookie().error("violations!");
		} else
		{
			logger.info(userData.printOut());
			dao.<User> persist(userData.getAsUser());
		}
		return Results.redirect(context.getContextPath() + "/user");
	}

	/**
	 * Shows the Account-Form <br/>
	 * GET /account
	 * 
	 * @return the account-form
	 */
	public Result accountForm()
	{
		return Results.html();
	}

	/**
	 * Shows the Account-Form <br/>
	 * GET /account
	 * 
	 * @return the account-form
	 */
	public Result postAccountForm(Context context, @JSR303Validation AccountFormData accountData, Validation validation)
	{
		if (validation.hasViolations())
		{
			context.getFlashCookie().error("violations!");
		} else
		{
			logger.info(accountData.printOut());
			dao.<Account> persist(accountData.getAsAccount());
		}
		return Results.redirect(context.getContextPath() + "/account");
	}

	/**
	 * Shows the Application-Form <br/>
	 * GET /account
	 * 
	 * @return the Application-form
	 */
	public Result applicationForm()
	{
		return Results.html();
	}

	/**
	 * Shows the Application-Form <br/>
	 * GET /application
	 * 
	 * @return the account-form
	 */
	public Result postApplicationForm(Context context, @JSR303Validation ApplicationFormData applicationData, Validation validation)
	{
		if (validation.hasViolations())
		{
			context.getFlashCookie().error("violations!");
		} else
		{
			logger.info(applicationData.printOut());
			dao.<Application> persist(applicationData.getAsApplication());
		}
		return Results.redirect(context.getContextPath() + "/application");
	}
	/**
	 * Shows the Finance-Plan-Form <br/>
	 * GET /account
	 * 
	 * @return the Finance-Plan-form
	 */
	public Result financePlanForm()
	{
		return Results.html();
	}

	public Result agendaForm()
	{

		return Results.html();
	}

	public Result agendaItemForm()
	{

		return Results.html();
	}

	public Result decisionForm()
	{

		return Results.html();
	}

	public Result protocolForm()
	{

		return Results.html();
	}

	public Result ballotForm()
	{

		return Results.html();
	}
	
	public Result protocolItemForm()
	{

		return Results.html();
	}
	
	public Result participantListForm()
	{

		return Results.html();
	}
	
	public Result participantListItemForm()
	{

		return Results.html();
	}
}
