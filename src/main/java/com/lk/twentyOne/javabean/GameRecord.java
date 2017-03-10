package com.lk.twentyOne.javabean;

import java.util.Date;

public class GameRecord extends Id {
	private UserInfo user; // 玩家
	private UserInfo rival;  // 对方玩家

	private int totalDamage;  // 造成伤害
	private int totalTime;  // 耗时(ms)
	private boolean win;  // 是否胜利
	private Date createDate; // 创建时间

	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public UserInfo getRival() {
		return rival;
	}
	public void setRival(UserInfo rival) {
		this.rival = rival;
	}
	public int getTotalDamage() {
		return totalDamage;
	}
	public void setTotalDamage(int totalDamage) {
		this.totalDamage = totalDamage;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	public boolean isWin() {
		return win;
	}
	public void setWin(boolean win) {
		this.win = win;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
