package com.lk.twentyOne.game;

import java.util.List;

import com.lk.twentyOne.javabean.UserInfo;

/**
 * 玩家
 * @author lk
 *
 */
public class Player {
	
	private int healthPoint = 5;
	private List<Card> numberCard;
	private List<Card> trumpCard;
	private List<Card> efficientTrumpCard;
	
	private UserInfo user;

	public int getHealthPoint() {
		return healthPoint;
	}

	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}

	public List<Card> getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(List<Card> numberCard) {
		this.numberCard = numberCard;
	}

	public List<Card> getTrumpCard() {
		return trumpCard;
	}

	public void setTrumpCard(List<Card> trumpCard) {
		this.trumpCard = trumpCard;
	}

	public List<Card> getEfficientTrumpCard() {
		return efficientTrumpCard;
	}

	public void setEfficientTrumpCard(List<Card> efficientTrumpCard) {
		this.efficientTrumpCard = efficientTrumpCard;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
	
}
