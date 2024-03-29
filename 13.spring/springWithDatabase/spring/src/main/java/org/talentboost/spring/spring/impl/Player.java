package org.talentboost.spring.spring.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import org.talentboost.spring.spring.IPlayer;
import org.talentboost.spring.spring.data.PlayerResponse;
import org.talentboost.spring.spring.data.UserAccount;

@Service
public class Player implements IPlayer {
	
	private UserAccount user;
	
	public String tryLogin(){
		System.out.println("Login as: ");
		return getInput();
	}
	
	public void authorize(UserAccount user){
		this.user = user;
	}
	
	public PlayerResponse ask(String question){
		System.out.println("Guess the capital of " + question + ":");
		String answer = getInput();
		if (answer.equals("skip")) {
			return new PlayerResponse(true, null, null);
		} else {
			return new PlayerResponse(false, question, answer);
		}
	}
	private String getInput(){
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Something terrible has happened";
	}
	public void quit(String message){
		System.out.println(message);
	}
	public UserAccount getCurrentUser(){
		return user;
	}
}
