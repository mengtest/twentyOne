package com.lk.twentyOne.card;

import com.lk.twentyOne.game.Game;

public abstract class AbstractCard implements Card {

	@Override
	abstract public void execute(Game game);
	
	@Override
	abstract public void effect(Game game);

	@Override
	abstract public String getName();

	@Override
	abstract public String getDescription();
}
