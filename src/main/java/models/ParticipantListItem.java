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
public class ParticipantListItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	/**
	 * the list to which the item belongs
	 */
	private ParticipantList participantList;
	/**
	 * holds the participant
	 */
	// private User participant;
	/**
	 * specifies if a participant was present and in which role. can be A,E,U,G
	 * A means attendant or present E means excused absent U means unexcused
	 * absent G means guest
	 */
	private Character perticipationRole;
	/**
	 * the time the participant arrived
	 */
	private Long arrivalTime;
	/**
	 * the time the participant left
	 */
	private Long leavingTime;
	/**
	 * an additional comment field
	 */
	private String comment;

	public ParticipantList getParticipantList() {
		return participantList;
	}

	public void setParticipantList(ParticipantList participantList) {
		this.participantList = participantList;
	}

	// public User getParticipant() {
	// return participant;
	// }
	//
	// public void setParticipant(User participant) {
	// this.participant = participant;
	// }

	public Character getPerticipationRole() {
		return perticipationRole;
	}

	public void setPerticipationRole(Character perticipationRole) {
		this.perticipationRole = perticipationRole;
	}

	public ParticipantListItem() {
	}

	public Long getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Long arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Long getLeavingTime() {
		return leavingTime;
	}

	public void setLeavingTime(Long leavingTime) {
		this.leavingTime = leavingTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
