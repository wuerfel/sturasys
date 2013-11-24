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

import models.DbData;
import models.ParticipantListItem;

public class ParticipantListItemFormData implements FormData
{

	public ParticipantListItemFormData(Character perticipationRole, Long arrivalTime, Long leavingTime, String comment)
	{
		super();
		this.perticipationRole = perticipationRole;
		this.arrivalTime = arrivalTime;
		this.leavingTime = leavingTime;
		this.comment = comment;
	}

	/**
	 * specifies if a participant was present and in which role. can be A,E,U,G
	 * A means attendant or present E means excused absent U means unexcused
	 * absent G means guest
	 */
	private Character perticipationRole;
	/**
	 * the time the participant arrived
	 */
	private Long arrivalTime;
	/**
	 * the time the participant left
	 */
	private Long leavingTime;
	/**
	 * an additional comment field
	 */
	private String comment;

	public Character getPerticipationRole()
	{
		return perticipationRole;
	}

	public void setPerticipationRole(Character perticipationRole)
	{
		this.perticipationRole = perticipationRole;
	}

	public ParticipantListItemFormData()
	{
	}

	public Long getArrivalTime()
	{
		return arrivalTime;
	}

	public void setArrivalTime(Long arrivalTime)
	{
		this.arrivalTime = arrivalTime;
	}

	public Long getLeavingTime()
	{
		return leavingTime;
	}

	public void setLeavingTime(Long leavingTime)
	{
		this.leavingTime = leavingTime;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	@Override
	public DbData getAsDbData()
	{
		return new ParticipantListItem(perticipationRole, arrivalTime, leavingTime, comment);
	}

	@Override
	public String printOut()
	{
		return perticipationRole + " " + arrivalTime + " " + leavingTime + " " + comment;
	}

}
