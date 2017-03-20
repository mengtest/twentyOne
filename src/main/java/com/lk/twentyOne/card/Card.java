package com.lk.twentyOne.card;

import com.lk.twentyOne.game.Game;

public interface Card {
	
	String getName();

	String getDescription();

	void execute(Game game);
	
	void effect(Game game);
}
