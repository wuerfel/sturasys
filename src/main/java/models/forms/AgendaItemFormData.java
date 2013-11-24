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

import org.hibernate.validator.constraints.NotEmpty;

import models.AgendaItem;
import models.DbData;

public class AgendaItemFormData implements FormData
{

	/**
	 * the order number within the agenda
	 */
	private Integer itemNumber;
	/**
	 * the title of the agenda item
	 */
	@NotEmpty
	private String title;
	/**
	 * the description
	 */
	@NotEmpty
	private String description;

	/**
	 * indicates whether the item is public or not
	 */
	private Boolean publiclyAccessible;

	public AgendaItemFormData()
	{
	}

	public AgendaItemFormData(String desc, Integer itemNumber, boolean publiclyAccessible, String title)
	{
		this.description = desc;
		this.itemNumber = itemNumber;
		this.publiclyAccessible = publiclyAccessible;
		this.title = title;
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

	public Boolean getPubliclyAccessable()
	{
		return publiclyAccessible;
	}

	public void setPubliclyAccessable(Boolean publiclyAccessable)
	{
		this.publiclyAccessible = publiclyAccessable;
	}

	@Override
	public DbData getAsDbData()
	{

		return new AgendaItem(itemNumber, title, description, publiclyAccessible);
	}

	@Override
	public String printOut()
	{

		return title + "\n" + itemNumber + "\n" + "public: " + publiclyAccessible + "\n" + description;
	}

}
