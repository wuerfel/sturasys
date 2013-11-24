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
import javax.persistence.ManyToOne;

import models.forms.AccountFormData;
import models.forms.FormData;

@Entity
public class Account implements DbData
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	/**
	 * the number of this bank account
	 */
	private long accountNumber;

	/**
	 * the bank identifier code
	 */
	private String bankCode;

	/**
	 * the name of the bank institute
	 */
	private String bank;

	/**
	 * the iban number
	 */
	private String iban;

	/**
	 * the user related to this account
	 */

	@ManyToOne
	private User user;

	public long getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public String getBankCode()
	{
		return bankCode;
	}

	public void setBankCode(String bankCode)
	{
		this.bankCode = bankCode;
	}

	public String getBank()
	{
		return bank;
	}

	public void setBank(String bank)
	{
		this.bank = bank;
	}

	public String getIban()
	{
		return iban;
	}

	public void setIban(String iban)
	{
		this.iban = iban;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Account()
	{
	}

	public Account(long accNum, String bank, String bankCode, String iban)
	{
		this.accountNumber = accNum;
		this.bank = bank;
		this.bankCode = bankCode;
		this.iban = iban;
	}

	@Override
	public FormData getAsFormData()
	{
		AccountFormData accFormData = new AccountFormData(accountNumber, bank, bankCode, iban);
		return accFormData;
	}

}
