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

import models.forms.AgendaFormData;
import models.forms.FormData;

@Entity
public class Agenda implements DbData
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	/**
	 * the place of the meeting
	 */
	private String place;
	/**
	 * holds the respective items of the agenda
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "agenda")
	private List<AgendaItem> items;

	public String getPlace()
	{
		return place;
	}

	public void setPlace(String place)
	{
		this.place = place;
	}

	public List<AgendaItem> getItems()
	{
		return items;
	}

	public void setItems(List<AgendaItem> items)
	{
		this.items = items;
	}

	public Agenda()
	{
	}

	public Agenda(String place)
	{
		this.place = place;
	}

	@Override
	public FormData getAsFormData()
	{
		return new AgendaFormData(place);
	}

}
