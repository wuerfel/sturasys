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
import models.Agenda;
import models.AgendaItem;
import models.Application;
import models.Ballot;
import models.Decision;
import models.ParticipantListItem;
import models.Protocol;
import models.ProtocolItem;
import models.User;
import models.forms.AccountFormData;
import models.forms.AgendaFormData;
import models.forms.AgendaItemFormData;
import models.forms.ApplicationFormData;
import models.forms.BallotFormData;
import models.forms.DecisionFormData;
import models.forms.ParticipantListItemFormData;
import models.forms.ProtocolFormData;
import models.forms.ProtocolItemFormData;
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

		// User u = new User();
		// u.setCity("");
		// u.setEmail("email");
		// u.setFirstName("firstName");
		// u.setMatricleNo("matricleNo");
		// u.setPassword("password");
		// u.setPostal("e");
		// u.setRole(1);
		// u.setStreet("street");
		// u.setStreetNo("streetNo");
		// u.setSurName("surName");
		// u.setTelephoneNo("12");
		//
		// User u2 = new User();
		// u2.setCity("ww");
		// u2.setEmail("emaiwwl");
		// u2.setFirstName("firstwwName");
		// u2.setMatricleNo("matrwwicleNo");
		// u2.setPassword("passwwword");
		// u2.setPostal("ew");
		// u2.setRole(1);
		// u2.setStreet("strweet");
		// u2.setStreetNo("stwreetNo");
		// u2.setSurName("surNwame");
		// u2.setTelephoneNo("1w2");
		// dao.<User> persist(u);
		// dao.<User> persist(u2);
		// dao.<User> remove(u);
		// User returned = dao.getSingleElement(User.class, u2.getId());

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
			dao.<User> persist((User) userData.getAsDbData());
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
	 * POST /account
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
			dao.<Account> persist((Account) accountData.getAsDbData());
		}
		return Results.redirect(context.getContextPath() + "/account");
	}

	/**
	 * Shows the Application-Form <br/>
	 * GET /application
	 * 
	 * @return the Application-form
	 */
	public Result applicationForm()
	{
		return Results.html();
	}

	/**
	 * Shows the Application-Form <br/>
	 * POST /application
	 * 
	 * @return the application-form
	 */
	public Result postApplicationForm(Context context, @JSR303Validation ApplicationFormData applicationData,
			Validation validation)
	{
		if (validation.hasViolations())
		{
			context.getFlashCookie().error("violations!");
		} else
		{
			logger.info(applicationData.printOut());
			dao.<Application> persist((Application) applicationData.getAsDbData());
		}
		return Results.redirect(context.getContextPath() + "/application");
	}

	/**
	 * Shows the Finance-Plan-Form <br/>
	 * GET /financeplan
	 * 
	 * @return the Finance-Plan-form
	 */
	public Result financePlanForm()
	{
		return Results.html();
	}

	/**
	 * Shows the Finance-Plan-Form <br/>
	 * POST /financeplan
	 * 
	 * @return the financeplan-form
	 */
	public Result postFinancePlanForm(Context context)
	{

		return Results.redirect(context.getContextPath() + "/financeplan");
	}

	/**
	 * Shows the Agenda-Form <br/>
	 * GET /agenda
	 * 
	 * @return the Agenda-form
	 */
	public Result agendaForm()
	{

		return Results.html();
	}

	/**
	 * Shows the Agenda-Form <br/>
	 * POST /agenda
	 * 
	 * @return the Agenda-form
	 */
	public Result postAgendaForm(Context context, @JSR303Validation AgendaFormData agendaData, Validation validation)
	{
		if (validation.hasViolations())
		{
			context.getFlashCookie().error("violations!");
		} else
		{
			logger.info(agendaData.printOut());
			dao.<Agenda> persist((Agenda) agendaData.getAsDbData());
		}
		return Results.redirect(context.getContextPath() + "/agenda");
	}

	/**
	 * Shows the AgendaItem-Form <br/>
	 * GET /agendaItem
	 * 
	 * @return the AgendaItem-form
	 */
	public Result agendaItemForm()
	{

		return Results.html();
	}

	/**
	 * Shows the AgendaItem-Form <br/>
	 * POST /agendaItem
	 * 
	 * @return the AgendaItem-form
	 */
	public Result postAgendaItemForm(Context context, @JSR303Validation AgendaItemFormData agendaItemData,
			Validation validation)
	{
		if (validation.hasViolations())
		{
			context.getFlashCookie().error("violations!");
		} else
		{
			logger.info(agendaItemData.printOut());
			dao.<AgendaItem> persist((AgendaItem) agendaItemData.getAsDbData());
		}
		return Results.redirect(context.getContextPath() + "/agendaItem");
	}

	/**
	 * Shows the Decision-Form <br/>
	 * GET /decision
	 * 
	 * @return the Decision-form
	 */
	public Result decisionForm()
	{

		return Results.html();
	}

	/**
	 * Shows the Decision-Form <br/>
	 * POST /decision
	 * 
	 * @return the Decision-form
	 */
	public Result postDecisionForm(Context context, @JSR303Validation DecisionFormData decisionData,
			Validation validation)
	{
		if (validation.hasViolations())
		{
			context.getFlashCookie().error("violations!");
		} else
		{
			logger.info(decisionData.printOut());
			dao.<Decision> persist((Decision) decisionData.getAsDbData());
		}
		return Results.redirect(context.getContextPath() + "/decision");
	}

	/**
	 * Shows the Protocol-Form <br/>
	 * GET /protocol
	 * 
	 * @return the Protocol-form
	 */
	public Result protocolForm()
	{

		return Results.html();
	}

	/**
	 * Shows the Protocol-Form <br/>
	 * POST /protocol
	 * 
	 * @return the Protocol-form
	 */
	public Result postProtocolForm(Context context, @JSR303Validation ProtocolFormData protocolFormData,
			Validation validation)
	{
		if (validation.hasViolations())
		{
			context.getFlashCookie().error("violations!");
		} else
		{
			logger.info(protocolFormData.printOut());
			dao.<Protocol> persist((Protocol) protocolFormData.getAsDbData());
		}
		return Results.redirect(context.getContextPath() + "/protocol");
	}

	/**
	 * Shows the Ballot-Form <br/>
	 * GET /ballot
	 * 
	 * @return the Ballot-form
	 */
	public Result ballotForm()
	{

		return Results.html();
	}

	/**
	 * Shows the Ballot-Form <br/>
	 * POST /ballotDecision
	 * 
	 * @return the Ballot-form
	 */
	public Result postBallotForm(Context context, @JSR303Validation BallotFormData ballotData, Validation validation)
	{
		if (validation.hasViolations())
		{
			context.getFlashCookie().error("violations!");
		} else
		{
			logger.info(ballotData.printOut());
			dao.<Ballot> persist((Ballot) ballotData.getAsDbData());
		}
		return Results.redirect(context.getContextPath() + "/ballotDecision");
	}

	/**
	 * Shows the ProtocolItem-Form <br/>
	 * GET /protocolItem
	 * 
	 * @return the ProtocolItem-form
	 */
	public Result protocolItemForm()
	{

		return Results.html();
	}

	/**
	 * Shows the ProtocolItem-Form <br/>
	 * POST /protocolItem
	 * 
	 * @return the ProtocolItem-form
	 */
	public Result postProtocolItemForm(Context context, @JSR303Validation ProtocolItemFormData protocolItemData,
			Validation validation)
	{
		if (validation.hasViolations())
		{
			context.getFlashCookie().error("violations!");
		} else
		{
			logger.info(protocolItemData.printOut());
			dao.<ProtocolItem> persist((ProtocolItem) protocolItemData.getAsDbData());
		}
		return Results.redirect(context.getContextPath() + "/protocolItem");
	}

	/**
	 * Shows the ParticipantList-Form <br/>
	 * GET /participantList
	 * 
	 * @return the ParticipantList-form
	 */
	public Result participantListForm(Context context)
	{

		return Results.html();
	}

	/**
	 * Shows the ParticipantList-Form <br/>
	 * POST /participantList
	 * 
	 * @return the ParticipantList-form
	 */
	public Result postParticipantListForm(Context context)
	{
		// if (validation.hasViolations())
		// {
		// context.getFlashCookie().error("violations!");
		// } else
		// {
		// logger.info(protocolItemData.printOut());
		// dao.<ProtocolItem> persist((ProtocolItem)
		// protocolItemData.getAsDbData());
		// }
		return Results.redirect(context.getContextPath() + "/participantList");
	}

	/**
	 * Shows the ParticipantListItem-Form <br/>
	 * GET /participantListItem
	 * 
	 * @return the ParticipantListItem-form
	 */
	public Result participantListItemForm()
	{

		return Results.html();
	}

	/**
	 * Shows the ParticipantListItem-Form <br/>
	 * POST /participantListItem
	 * 
	 * @return the ParticipantListItem-form
	 */
	public Result postParticipantListItemForm(Context context,
			@JSR303Validation ParticipantListItemFormData participantListItemData, Validation validation)
	{
		if (validation.hasViolations())
		{
			context.getFlashCookie().error("violations!");
		} else
		{
			logger.info(participantListItemData.printOut());
			dao.<ParticipantListItem> persist((ParticipantListItem) participantListItemData.getAsDbData());
		}
		return Results.redirect(context.getContextPath() + "/participantListItem");
	}
}
