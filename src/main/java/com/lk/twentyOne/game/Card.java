package com.lk.twentyOne.game;

public interface Card {

	void execute(Game game);
	
	void effect(Game game);

	String getName();

	String getDescription();
}
