package com.lk.twentyOne.game;

import java.util.ArrayList;
import java.util.List;

import com.lk.twentyOne.javabean.UserInfo;
import com.lk.twentyOne.util.StringUtil;

/**
 * 游戏桌
 * 游戏桌对象可供两名玩家游戏
 * @author lk
 *
 */
public class GameTable {
	
	private List<Player> players;
	private int allowPlayerNumber;
	private int status; // 状态（0空，1未开始游戏，2正在游戏
	
	private String gameId;
	
	public GameTable() {
		this.players = new ArrayList<>();
		this.allowPlayerNumber = 2;
		this.status = 0;
	}
	
	public void startGame() {
		if (!allowStartGame()) {
			return;
		}
		
		gameId = StringUtil.getUUID();
		
		
		status = 2;
	}
	
	public boolean allowStartGame() {
		if (status != 1 && players.size() != allowPlayerNumber) {
			return false;
		}
		
		for (Player player : players) {
			if (!player.ready) {
				return false;
			}
		}
		return true;
	}
	
	class Player {
		private UserInfo user;
		private boolean ready;
		
		public UserInfo getUser() {
			return user;
		}
		public void setUser(UserInfo user) {
			this.user = user;
		}
		public boolean isReady() {
			return ready;
		}
		public void setReady(boolean ready) {
			this.ready = ready;
		}
	}
}
