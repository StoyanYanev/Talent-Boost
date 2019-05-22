package org.talentboost.spring.spring;

import org.talentboost.spring.spring.data.UnauthorizedException;
import org.talentboost.spring.spring.data.UserAccount;

public interface IAccountManager {

	public UserAccount authenticate(String username)
			throws UnauthorizedException;
}
