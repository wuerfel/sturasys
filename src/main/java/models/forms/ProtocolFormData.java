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
import models.Protocol;

public class ProtocolFormData implements FormData
{

	public ProtocolFormData(Long startingTimestamp, Long endingTimestamp)
	{
		super();
		this.startingTimestamp = startingTimestamp;
		this.endingTimestamp = endingTimestamp;
	}

	/**
	 * the date and time the meeting has started
	 */
	private Long startingTimestamp;
	/**
	 * the date and time the meeting has ended
	 */
	private Long endingTimestamp;

	public ProtocolFormData()
	{
	}

	public Long getStartingTimestamp()
	{
		return startingTimestamp;
	}

	public void setStartingTimestamp(Long startingTimestamp)
	{
		this.startingTimestamp = startingTimestamp;
	}

	public Long getEndingTimestamp()
	{
		return endingTimestamp;
	}

	public void setEndingTimestamp(Long endingTimestamp)
	{
		this.endingTimestamp = endingTimestamp;
	}

	@Override
	public DbData getAsDbData()
	{
		// TODO Auto-generated method stub
		return new Protocol(startingTimestamp, endingTimestamp);
	}

	@Override
	public String printOut()
	{

		return startingTimestamp + " " + endingTimestamp;
	}

}
