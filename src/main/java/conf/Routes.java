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

package conf;

import ninja.AssetsController;
import ninja.Router;
import ninja.application.ApplicationRoutes;
import ninja.utils.NinjaProperties;

import com.google.inject.Inject;

import controllers.ApplicationController;

public class Routes implements ApplicationRoutes
{

	private NinjaProperties ninjaProperties;

	@Inject
	public Routes(NinjaProperties ninjaProperties)
	{
		this.ninjaProperties = ninjaProperties;
	}

	/**
	 * Using a (almost) nice DSL we can configure the router.
	 * 
	 * The second argument NinjaModuleDemoRouter contains all routes of a
	 * submodule. By simply injecting it we activate the routes.
	 * 
	 * @param router
	 *            The default router of this application
	 */
	@Override
	public void init(Router router)
	{

		// default routes
		router.GET().route("/").with(ApplicationController.class, "getIndex");
        router.GET().route("/account").with(ApplicationController.class, "accountForm");
        router.POST().route("/account").with(ApplicationController.class, "postAccountForm");
		router.GET().route("/agenda").with(ApplicationController.class, "agendaForm");
        router.POST().route("/agenda").with(ApplicationController.class, "postAgendaForm");
		router.GET().route("/agendaItem").with(ApplicationController.class, "agendaItemForm");
        router.POST().route("/agendaItem").with(ApplicationController.class, "postAgendaItemForm");
        router.GET().route("/application").with(ApplicationController.class, "applicationForm");
        router.POST().route("/application").with(ApplicationController.class, "postApplicationForm");
		router.GET().route("/ballot").with(ApplicationController.class, "ballotForm");
        router.POST().route("/ballot").with(ApplicationController.class, "postBallotForm");
		router.GET().route("/decision").with(ApplicationController.class, "decisionForm");
        router.POST().route("/decision").with(ApplicationController.class, "postDecisionForm");
        router.GET().route("/financeplan").with(ApplicationController.class, "financePlanForm");
        router.POST().route("/financeplan").with(ApplicationController.class, "postFinancePlanForm");
		router.GET().route("/participantList").with(ApplicationController.class, "participantListForm");
        router.POST().route("/participantList").with(ApplicationController.class, "postParticipantListForm");
		router.GET().route("/participantListItem").with(ApplicationController.class, "participantListItemForm");
        router.POST().route("/participantListItem").with(ApplicationController.class, "postParticipantListItemForm");
		router.GET().route("/protocol").with(ApplicationController.class, "protocolForm");
        router.POST().route("/protocol").with(ApplicationController.class, "postProtocolForm");
		router.GET().route("/protocolItem").with(ApplicationController.class, "protocolItemForm");
        router.POST().route("/protocolItem").with(ApplicationController.class, "postProtocolItemForm");
        router.GET().route("/user").with(ApplicationController.class, "userForm");
        router.POST().route("/user").with(ApplicationController.class, "postUserForm");

		router.GET().route("/assets/.*").with(AssetsController.class, "serve");
	}
}
