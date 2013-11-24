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
import models.FinancePlanItem;

public class FinancePlanItemFormData implements FormData
{

	public FinancePlanItemFormData(String title, Integer amount)
	{
		super();
		this.title = title;
		this.amount = amount;
	}

	/**
	 * the name of this point
	 */
	private String title;
	/**
	 * the monetary amount of this point
	 */
	private Integer amount;

	public FinancePlanItemFormData()
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

	public Integer getAmount()
	{
		return amount;
	}

	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}

	@Override
	public DbData getAsDbData()
	{

		return new FinancePlanItem(title, amount);
	}

	@Override
	public String printOut()
	{

		return title+" "+amount;
	}

}
