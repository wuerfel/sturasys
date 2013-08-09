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

@Entity
public class AgendaItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	/**
	 * the agenda the item belongs to
	 */
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
	 * the request this item is attached to
	 */
	// private Request request;
	/**
	 * indicates weather the item is public or not
	 */
	private Boolean publiclyAccessable;

	public AgendaItem() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// public Request getRequest() {
	// return request;
	// }
	//
	// public void setRequest(Request request) {
	// this.request = request;
	// }

	public Boolean getPubliclyAccessable() {
		return publiclyAccessable;
	}

	public void setPubliclyAccessable(Boolean publiclyAccessable) {
		this.publiclyAccessable = publiclyAccessable;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

}
