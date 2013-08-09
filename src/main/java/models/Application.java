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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	/**
	 * the title of this application
	 */
	private String title;
	/**
	 * the time when the application came in
	 */
	private Long timeStamp;
	/**
	 * the current processing status of this application
	 */
	private Integer status;
	/**
	 * the description
	 */
	private String description;
	/**
	 * the expected number of students attending this event
	 */
	private Integer noOfStudents;
	/**
	 * the expected number of people in total attending this event
	 */
	private Integer noOfParticipants;
	/**
	 * the entrance fee of the event related to this application
	 */
	private String fee;
	/**
	 * the requested funding sum
	 */
	private String reqFundingSum;
	/**
	 * the target audience of the event related to this application
	 */
	private String targetAudience;
	/**
	 * the applicant who's placed this application
	 */
	@ManyToOne
	private User applicant;
	/**
	 * the amount of money provided by the council
	 */
	private String accommodation;
	/**
	 * the place where the event's taking place
	 */
	private String placeOfEvent;
	/**
	 * the starttime of the event
	 */
	private Long startTime;
	/**
	 * the duration of this event
	 */
	private Long duration;
	@OneToOne
	@JoinColumn(name = "FINANCEPLAN_ID", unique = true, nullable = true, updatable = true)
	private FinancePlan financiation;
	/**
	 * the decision made about the application (may be empty)
	 */
	@OneToOne
	private Decision decision;
	/**
	 * the agenda items in which the application is discussed
	 */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="application")
	private List<AgendaItem> agendaItems;

	public Application() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(Integer noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public Integer getNoOfParticipants() {
		return noOfParticipants;
	}

	public void setNoOfParticipants(Integer noOfParticipants) {
		this.noOfParticipants = noOfParticipants;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getReqFundingSum() {
		return reqFundingSum;
	}

	public void setReqFundingSum(String reqFundingSum) {
		this.reqFundingSum = reqFundingSum;
	}

	public String getTargetAudience() {
		return targetAudience;
	}

	public void setTargetAudience(String targetAudience) {
		this.targetAudience = targetAudience;
	}

	public User getApplicant() {
		return applicant;
	}

	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}

	public String getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}

	public String getPlaceOfEvent() {
		return placeOfEvent;
	}

	public void setPlaceOfEvent(String placeOfEvent) {
		this.placeOfEvent = placeOfEvent;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public FinancePlan getFinanciation() {
		return financiation;
	}

	public void setFinanciation(FinancePlan financiation) {
		this.financiation = financiation;
	}

	public Decision getDecision() {
		return decision;
	}

	public void setDecision(Decision decision) {
		this.decision = decision;
	}

	public List<AgendaItem> getAgendaItems() {
		return agendaItems;
	}

	public void setAgendaItems(List<AgendaItem> agendaItems) {
		this.agendaItems = agendaItems;
	}

}
