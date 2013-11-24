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
import models.Decision;

public class DecisionFormData implements FormData
{

	public DecisionFormData(String decisionNumber, Character status, String comment)
	{
		super();
		this.decisionNumber = decisionNumber;
		this.status = status;
		this.comment = comment;
	}

	/**
	 * functional identifier
	 */
	private String decisionNumber;
	/**
	 * can be be <i>A</i> for approved or <i>R</i> for rejected
	 */
	private Character status;

	/**
	 * holds comments and restrictions
	 */
	private String comment;

	public DecisionFormData()
	{
	}

	public String getDecisionNumber()
	{
		return decisionNumber;
	}

	public void setDecisionNumber(String decisionNumber)
	{
		this.decisionNumber = decisionNumber;
	}

	public Character getStatus()
	{
		return status;
	}

	public void setStatus(Character status)
	{
		this.status = status;
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
		return new Decision(decisionNumber, status, comment);
	}

	@Override
	public String printOut()
	{
		return decisionNumber + " " + status + " " + comment;
	}

}
