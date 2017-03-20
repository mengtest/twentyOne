package com.lk.twentyOne.game;

import java.util.Date;
import java.util.List;

/**
 * 游戏对象
 * @author lk
 *
 */
public class Game {
	
	private int tableNum;
	
	private List<AbstractCard> cardsStack;
	
	private int round; // 回合（1玩家1，2玩家2
	private int stage; // 阶段（1出牌，2抽牌，3弃牌
	private int pkTimes = 0;
	private int challenge = 21;
	
	private Player player1;
	private Player player2;
	
	private Date updateDate;
	
	public Game() {
		// TODO Auto-generated constructor stub
	}
	
	public void victoryCheck() {
		
	}
}
