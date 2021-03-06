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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import models.forms.FormData;
import models.forms.ProtocolItemFormData;

@Entity
public class ProtocolItem implements DbData
{

	public ProtocolItem(String transcript)
	{
		super();
		this.transcript = transcript;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@ManyToOne
	private Protocol protocol;
	/**
	 * the transcript of the agenda item
	 */
	private String transcript;
	/**
	 * the agenda item the protocol refers to
	 */
	@OneToOne
	private AgendaItem agendaItem;

	public Protocol getProtocol()
	{
		return protocol;
	}

	public void setProtocol(Protocol protocol)
	{
		this.protocol = protocol;
	}

	public String getTranscript()
	{
		return transcript;
	}

	public void setTranscript(String transcript)
	{
		this.transcript = transcript;
	}

	public AgendaItem getAgendaItem()
	{
		return agendaItem;
	}

	public void setAgendaItem(AgendaItem agendaItem)
	{
		this.agendaItem = agendaItem;
	}

	public ProtocolItem()
	{
	}

	@Override
	public FormData getAsFormData()
	{
		return new ProtocolItemFormData(transcript);
	}

}
