package org.talentboost.spring.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.talentboost.spring.spring.IAccountManager;
import org.talentboost.spring.spring.IRepository;
import org.talentboost.spring.spring.data.UnauthorizedException;
import org.talentboost.spring.spring.data.UserAccount;

@Service
public class AccountManager implements IAccountManager {
	private IRepository repo;
	@Autowired
	public AccountManager(IRepository repo) {
		this.repo = repo;
	}

	public UserAccount authenticate(String username)
			throws UnauthorizedException {
		for(UserAccount account : repo.getAccounts()) {
			if (account.username.equals(username)) {
				return account;
			}
		}
		throw new UnauthorizedException();
	}

}
