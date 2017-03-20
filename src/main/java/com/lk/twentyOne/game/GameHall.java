package com.lk.twentyOne.game;

import java.util.ArrayList;
import java.util.List;

/**
 * 游戏大厅
 * @author lk
 *
 */
public class GameHall {

	private List<GameTable> tables;
	
	public GameHall(int tableCount) {
		tables = new ArrayList<>();
		
		int index = 0;
		while (index++ < tableCount) {
			tables.add(new GameTable());
		}
	}
	
	public GameTable getTable(int index) {
		return tables.get(index);
	}
	
	public List<GameTable> getTables() {
		return tables;
	}
}
