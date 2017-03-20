package com.lk.twentyOne.game;

public abstract class AbstractCard implements Card {

	private String name;
	private String description;
	
	@Override
	abstract public void execute(Game game);
	
	@Override
	abstract public void effect(Game game);

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}
}
