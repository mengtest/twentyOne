package com.lk.twentyOne.card;

import com.lk.twentyOne.game.Game;

public class NumberCard implements Card {

	private int number;

	@Override
	public String getName() {
		return number + "";
	}

	@Override
	public String getDescription() {
		return "数字牌-" + number;
	}

	@Override
	public void execute(Game game) {
		
	}

	@Override
	public void effect(Game game) {
		// TODO Auto-generated method stub
		
	}
	

}
