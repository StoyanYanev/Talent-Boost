package org.talentboost.spring.spring;

import java.util.List;

import org.talentboost.spring.spring.data.UserAccount;

public interface IRepository {
	public String getCapitalOf(String country);
	public List<String> getCountries();
	public List<UserAccount> getAccounts();
}
