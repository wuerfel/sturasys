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

import models.Ballot;
import models.DbData;

public class BallotFormData implements FormData
{

	public BallotFormData(String title, String description, Integer voteCountYes, Integer voteCountNo,
			Integer voteCountAbstention)
	{
		super();
		this.title = title;
		this.description = description;
		this.voteCountYes = voteCountYes;
		this.voteCountNo = voteCountNo;
		this.voteCountAbstention = voteCountAbstention;
	}

	/**
	 * the title of the vote
	 */
	@NotEmpty
	private String title;
	/**
	 * the description of the request
	 */
	@NotEmpty
	private String description;

	/**
	 * the number of votes for yes
	 */
	@NotEmpty
	private Integer voteCountYes;
	/**
	 * the number of votes for no
	 */
	@NotEmpty
	private Integer voteCountNo;
	/**
	 * the number of abstained votes
	 */
	@NotEmpty
	private Integer voteCountAbstention;

	/**
	 * the request the ballot is referring to (if there is any)
	 */
	// private Request request;

	public BallotFormData()
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Integer getVoteCountYes()
	{
		return voteCountYes;
	}

	public void setVoteCountYes(Integer voteCountYes)
	{
		this.voteCountYes = voteCountYes;
	}

	public Integer getVoteCountNo()
	{
		return voteCountNo;
	}

	public void setVoteCountNo(Integer voteCountNo)
	{
		this.voteCountNo = voteCountNo;
	}

	public Integer getVoteCountAbstention()
	{
		return voteCountAbstention;
	}

	public void setVoteCountAbstention(Integer voteCountAbstention)
	{
		this.voteCountAbstention = voteCountAbstention;
	}

	@Override
	public DbData getAsDbData()
	{

		return new Ballot( title, description, voteCountYes, voteCountNo, voteCountAbstention);
	}

	@Override
	public String printOut()
	{

		return title + " " + description + " " + voteCountYes + " " + voteCountNo + " "
				+ voteCountAbstention;
	}

	// public Request getRequest() {
	// return request;
	// }
	//
	// public void setRequest(Request request) {
	// this.request = request;
	// }

}
