package com.vmware.talentboost.spring.test;

import java.util.ArrayList;
import java.util.List;

import com.vmware.talentboost.spring.IRepository;
import com.vmware.talentboost.spring.data.UserAccount;

public class AuthenticateTestRepositoryStub implements IRepository{
	public String getCapitalOf(String country) {
		return null;
	}
	public List<String> getCountries() {
		return null;
	}

	public List<UserAccount> getAccounts() {
		List<UserAccount> accounts = new ArrayList<UserAccount>();
		accounts.add(new UserAccount("dushan", "player"));
		accounts.add(new UserAccount("tanya", "player"));
		accounts.add(new UserAccount("oggy", "admin"));
		return accounts;
	}
	
}
