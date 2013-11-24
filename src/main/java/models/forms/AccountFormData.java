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

import models.Account;
import models.DbData;

public class AccountFormData implements FormData
{

	/**
	 * the number of this bank account
	 */

	private long accountNumber;

	/**
	 * the bank identifier code
	 */
	@NotEmpty
	private String bankCode;

	/**
	 * the name of the bank institute
	 */
	@NotEmpty
	private String bank;

	/**
	 * the iban number
	 */
	@NotEmpty
	private String iban;

	public AccountFormData()
	{
	}

	public AccountFormData(long accNum, String bank, String bankCode, String iban)
	{
		this.accountNumber = accNum;
		this.bank = bank;
		this.bankCode = bankCode;
		this.iban = iban;
	}

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

	public String printOut()
	{
		return accountNumber + ", " + bankCode + ", " + bank + ", " + iban;
	}

	public Account getAsAccount()
	{
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setBank(bank);
		account.setBankCode(bankCode);
		account.setIban(iban);

		return account;
	}

	@Override
	public DbData getAsDbData()
	{
		Account acc = new Account(accountNumber, bank, bankCode, iban);
		return acc;
	}

}
