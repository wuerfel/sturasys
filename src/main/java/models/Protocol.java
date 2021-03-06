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

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import models.forms.FormData;
import models.forms.ProtocolFormData;

@Entity
public class Protocol implements DbData
{

	public Protocol(Long startingTimestamp, Long endingTimestamp)
	{
		super();
		this.startingTimestamp = startingTimestamp;
		this.endingTimestamp = endingTimestamp;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	/**
	 * the date and time the meeting has started
	 */
	private Long startingTimestamp;
	/**
	 * the date and time the meeting has ended
	 */
	private Long endingTimestamp;
	/**
	 * holds the respective items of the protocol
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "protocol")
	private List<ProtocolItem> items;
	/**
	 * holds the list of participants
	 */
	@OneToOne
	private ParticipantList participants;

	public Protocol()
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

	public ParticipantList getParticipants()
	{
		return participants;
	}

	public void setParticipants(ParticipantList participants)
	{
		this.participants = participants;
	}

	@Override
	public FormData getAsFormData()
	{

		return new ProtocolFormData(startingTimestamp, endingTimestamp);
	}

}
