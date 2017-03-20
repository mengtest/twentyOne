package com.lk.twentyOne.game;

import java.util.List;

import com.lk.twentyOne.card.Card;
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
	
	private int point = 0;
	private int damage = 1;
	private int protect = 0;
	
	private boolean noAction;

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

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getProtect() {
		return protect;
	}

	public void setProtect(int protect) {
		this.protect = protect;
	}

	public boolean isNoAction() {
		return noAction;
	}

	public void setNoAction(boolean noAction) {
		this.noAction = noAction;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}
