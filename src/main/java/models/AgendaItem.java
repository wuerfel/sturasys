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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import models.forms.FormData;

@Entity
public class AgendaItem implements DbData
{

	public AgendaItem(Integer itemNumber, String title, String description, Boolean publiclyAccessable)
	{
		super();
		this.itemNumber = itemNumber;
		this.title = title;
		this.description = description;
		this.publiclyAccessible = publiclyAccessable;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	/**
	 * the agenda the item belongs to
	 */
	@ManyToOne
	private Agenda agenda;
	/**
	 * the order number within the agenda
	 */
	private Integer itemNumber;
	/**
	 * the title of the agenda item
	 */
	private String title;
	/**
	 * the description
	 */
	private String description;
	/**
	 * the application this item is attached to
	 */
	@ManyToOne
	private Application application;
	/**
	 * indicates whether the item is public or not
	 */
	private Boolean publiclyAccessible;
	/**
	 * the transcript for the agenda item
	 */
	@OneToOne(mappedBy = "agendaItem")
	private ProtocolItem protocolItem;
	/**
	 * the ballots referring to the agenda item
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "agendaItem")
	private List<Ballot> ballots;

	public AgendaItem()
	{
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Integer getItemNumber()
	{
		return itemNumber;
	}

	public void setItemNumber(Integer itemNumber)
	{
		this.itemNumber = itemNumber;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Application getApplication()
	{
		return application;
	}

	public void setApplication(Application application)
	{
		this.application = application;
	}

	public Boolean getPubliclyAccessable()
	{
		return publiclyAccessible;
	}

	public void setPubliclyAccessable(Boolean publiclyAccessable)
	{
		this.publiclyAccessible = publiclyAccessable;
	}

	public Agenda getAgenda()
	{
		return agenda;
	}

	public void setAgenda(Agenda agenda)
	{
		this.agenda = agenda;
	}

	public ProtocolItem getProtocolItem()
	{
		return protocolItem;
	}

	public void setProtocolItem(ProtocolItem protocolItem)
	{
		this.protocolItem = protocolItem;
	}

	public List<Ballot> getBallots()
	{
		return ballots;
	}

	public void setBallots(List<Ballot> ballots)
	{
		this.ballots = ballots;
	}

	@Override
	public FormData getAsFormData()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
