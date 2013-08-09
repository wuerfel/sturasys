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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class FinancePlan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="financePlan")
	List<FinancePlanItem> revenues;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="financePlan")
	List<FinancePlanItem> outgoings;
	
	/**
	 * link to the application
	 */
	@OneToOne(mappedBy="financiation")
	Application application;

	public FinancePlan() {
	}

}
