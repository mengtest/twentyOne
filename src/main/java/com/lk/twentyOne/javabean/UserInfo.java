package com.lk.twentyOne.javabean;

import java.util.Date;

public class UserInfo extends Id {
	private String username; // 用户账号
	private String nickname; // 昵称
	private String email; // 邮箱，找回密码使用

	private Date updateDate; // 更新时间
	private Date createDate; // 创建时间
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
