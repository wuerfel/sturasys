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
import models.ProtocolItem;

public class ProtocolItemFormData implements FormData
{

	public ProtocolItemFormData(String transcript)
	{
		super();
		this.transcript = transcript;
	}

	private ProtocolFormData protocol;
	/**
	 * the transcript of the agenda item
	 */
	private String transcript;
	/**
	 * the agenda item the protocol refers to
	 */

	private AgendaItemFormData agendaItem;

	public ProtocolFormData getProtocol()
	{
		return protocol;
	}

	public void setProtocol(ProtocolFormData protocol)
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

	public AgendaItemFormData getAgendaItem()
	{
		return agendaItem;
	}

	public void setAgendaItem(AgendaItemFormData agendaItem)
	{
		this.agendaItem = agendaItem;
	}

	public ProtocolItemFormData()
	{
	}

	@Override
	public DbData getAsDbData()
	{

		return new ProtocolItem(transcript);
	}

	@Override
	public String printOut()
	{
		return transcript;
	}

}
