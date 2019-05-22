package org.talentboost.spring.spring;

import org.talentboost.spring.spring.data.PlayerResponse;
import org.talentboost.spring.spring.data.UserAccount;

public interface IPlayer {
	public String tryLogin();
	public void authorize(UserAccount user);
	public PlayerResponse ask(String question);
	public void quit(String message);

	public UserAccount getCurrentUser();
}
