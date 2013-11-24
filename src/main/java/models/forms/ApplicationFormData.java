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

import models.Application;
import models.DbData;

public class ApplicationFormData implements FormData
{
	public ApplicationFormData(String title, Long timeStamp, Integer status, String description, Integer noOfStudents,
			Integer noOfParticipants, String fee, String reqFundingSum, String targetAudience, String accommodation,
			String placeOfEvent, Long startTime, Long duration)
	{
		super();
		this.title = title;
		this.timeStamp = timeStamp;
		this.status = status;
		this.description = description;
		this.noOfStudents = noOfStudents;
		this.noOfParticipants = noOfParticipants;
		this.fee = fee;
		this.reqFundingSum = reqFundingSum;
		this.targetAudience = targetAudience;
		this.accommodation = accommodation;
		this.placeOfEvent = placeOfEvent;
		this.startTime = startTime;
		this.duration = duration;
	}

	/**
	 * the title of this application
	 */
	@NotEmpty
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
	@NotEmpty
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
	@NotEmpty
	private String fee;
	/**
	 * the requested funding sum
	 */
	@NotEmpty
	private String reqFundingSum;
	/**
	 * the target audience of the event related to this application
	 */
	@NotEmpty
	private String targetAudience;
	/**
	 * the amount of money provided by the council
	 */
	
	private String accommodation;
	/**
	 * the place where the event's taking place
	 */
	@NotEmpty
	private String placeOfEvent;
	/**
	 * the starttime of the event
	 */
	private Long startTime;
	/**
	 * the duration of this event
	 */
	private Long duration;

	public ApplicationFormData()
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

	public Long getTimeStamp()
	{
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp)
	{
		this.timeStamp = timeStamp;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Integer getNoOfStudents()
	{
		return noOfStudents;
	}

	public void setNoOfStudents(Integer noOfStudents)
	{
		this.noOfStudents = noOfStudents;
	}

	public Integer getNoOfParticipants()
	{
		return noOfParticipants;
	}

	public void setNoOfParticipants(Integer noOfParticipants)
	{
		this.noOfParticipants = noOfParticipants;
	}

	public String getFee()
	{
		return fee;
	}

	public void setFee(String fee)
	{
		this.fee = fee;
	}

	public String getReqFundingSum()
	{
		return reqFundingSum;
	}

	public void setReqFundingSum(String reqFundingSum)
	{
		this.reqFundingSum = reqFundingSum;
	}

	public String getTargetAudience()
	{
		return targetAudience;
	}

	public void setTargetAudience(String targetAudience)
	{
		this.targetAudience = targetAudience;
	}

	public String getAccommodation()
	{
		return accommodation;
	}

	public void setAccommodation(String accommodation)
	{
		this.accommodation = accommodation;
	}

	public String getPlaceOfEvent()
	{
		return placeOfEvent;
	}

	public void setPlaceOfEvent(String placeOfEvent)
	{
		this.placeOfEvent = placeOfEvent;
	}

	public Long getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Long startTime)
	{
		this.startTime = startTime;
	}

	public Long getDuration()
	{
		return duration;
	}

	public void setDuration(Long duration)
	{
		this.duration = duration;
	}

	public String printOut()
	{
		return title + ", " + status;
	}

	public Application getAsApplication()
	{
		Application application = new Application();
		application.setAccommodation(accommodation);
		;
		application.setDescription(description);
		application.setFee(fee);
		application.setNoOfParticipants(noOfParticipants);
		application.setNoOfStudents(noOfStudents);
		application.setPlaceOfEvent(placeOfEvent);
		application.setReqFundingSum(reqFundingSum);
		application.setTargetAudience(targetAudience);
		application.setTitle(title);
		return application;
	}

	@Override
	public DbData getAsDbData()
	{

		return new Application(title, timeStamp, status, description, noOfStudents, noOfParticipants, fee,
				reqFundingSum, targetAudience, accommodation, placeOfEvent, startTime, duration);
	}
}
