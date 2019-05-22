package org.talentboost.spring.spring;

import org.talentboost.spring.spring.data.PlayerResponse;

public interface IQuestionManager {
	public boolean checkQuestion(PlayerResponse guess);
	public String getQuestion();
	public void removeQuestion(String country);
	public boolean allGuessed();
}
