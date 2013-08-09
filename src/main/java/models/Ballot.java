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
public class Ballot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	/**
	 * the title of the vote
	 */
	private String title;
	/**
	 * the description of the request
	 */
	private String description;
	/**
	 * the agenda item which the vote has been held
	 */
	private AgendaItem agendaItem;
	/**
	 * the number of votes for yes
	 */
	private Integer voteCountYes;
	/**
	 * the number of votes for no
	 */
	private Integer voteCountNo;
	/**
	 * the number of abstained votes
	 */
	private Integer voteCountAbstention;

	/**
	 * the request the ballot is referring to (if there is any)
	 */
	// private Request request;

	public Ballot() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AgendaItem getAgendaItem() {
		return agendaItem;
	}

	public void setAgendaItem(AgendaItem agendaItem) {
		this.agendaItem = agendaItem;
	}

	public Integer getVoteCountYes() {
		return voteCountYes;
	}

	public void setVoteCountYes(Integer voteCountYes) {
		this.voteCountYes = voteCountYes;
	}

	public Integer getVoteCountNo() {
		return voteCountNo;
	}

	public void setVoteCountNo(Integer voteCountNo) {
		this.voteCountNo = voteCountNo;
	}

	public Integer getVoteCountAbstention() {
		return voteCountAbstention;
	}

	public void setVoteCountAbstention(Integer voteCountAbstention) {
		this.voteCountAbstention = voteCountAbstention;
	}

	// public Request getRequest() {
	// return request;
	// }
	//
	// public void setRequest(Request request) {
	// this.request = request;
	// }

}
