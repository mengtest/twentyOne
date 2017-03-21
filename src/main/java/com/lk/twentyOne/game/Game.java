package com.lk.twentyOne.game;

import java.util.Date;
import java.util.List;

import com.lk.twentyOne.card.AbstractCard;
import com.lk.twentyOne.card.Card;

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
	private int challengePoint = 21;
	
	private Player player1;
	private Player player2;
	
	private Date updateDate;
	
	/**
	 * 初始化游戏
	 */
	public Game() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 拼点结算
	 * 先循环生效场上的王牌
	 */
	public void pk() {
		if (player1.isNoAction() && player2.isNoAction()) {
			executeCardsEffect(player1.getEfficientTrumpCard(), player1, player2);
			executeCardsEffect(player2.getEfficientTrumpCard(), player2, player1);
			
			executeCardsEffect(player1.getNumberCard(), player1, player2);
			executeCardsEffect(player2.getNumberCard(), player2, player1);
			
			int result = checkPoint();
			boolean win = false;
			if (result == 1) {
				win = attack(player1, player2);
			} else if (result == -1) {
				win = attack(player2, player1);
			}
			
			if (win) {
				// TODO 有人胜利
			}
		}
	}
	
	/**
	 * 拼点之后造成伤害
	 * @param fromPlayer
	 * @param toPlayer
	 * @return 返回true时表示游戏结束
	 */
	private boolean attack(Player fromPlayer, Player toPlayer) {
		int damage = fromPlayer.getDamage() - toPlayer.getProtect();
		int remainHP = toPlayer.getHealthPoint() - damage;
		toPlayer.setHealthPoint(remainHP);
		
		return remainHP < 1;
	}

	/**
	 * 返回拼点结果
	 * 
	 * @return 1：玩家1赢，-1：玩家2赢，0：平局
	 */
	private int checkPoint() {
		pkTimes++;
		
		int n1 = challengePoint - player1.getPoint();
		int n2 = challengePoint - player2.getPoint();
		
		if ((n1 < 0 && n2 < 0) || (n1 == n2)) {
			return 0;
		}
		
		
		return n1 < n2 ? 1 : -1;
	}

	/**
	 * 执行场上生效的王牌
	 * @param cards
	 * @param fromPlayer
	 * @param toPlayer
	 */
	private void executeCardsEffect(List<Card> cards, Player fromPlayer, Player toPlayer) {
		for (Card card : cards) {
			executeCardsEffect(card, fromPlayer, toPlayer);
		}
	}
	
	private void executeCardsEffect(Card cards, Player fromPlayer, Player toPlayer) {
		cards.effect(this);
	}
	
	public void update() {
		updateDate.setTime(System.currentTimeMillis());
	}

	public Date getUpdateDate() {
		return updateDate;
	}
}
