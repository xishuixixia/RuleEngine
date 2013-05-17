package com.hxrainbow;

import java.io.Serializable;

public class Member implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private Integer loginNum;
	private Integer isInvite;
	private Integer from;
	private Integer fromSize;
	
	private Integer question;//答题数
	private Integer answerRight;//答对数
	
	private Integer avatar;//1表示有 0表示没有
	private Integer nickname;//1表示有 0表示没有
	private Integer requiredInfo;//1表示完成 0表示没有完成
	private Integer nonRequiredInfo;//非必填字段数量
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getLoginNum() {
		return loginNum;
	}
	public void setLoginNum(Integer loginNum) {
		this.loginNum = loginNum;
	}
	public Integer getFrom() {
		return from;
	}
	public void setFrom(Integer from) {
		this.from = from;
	}
	public Integer getFromSize() {
		return fromSize;
	}
	public void setFromSize(Integer fromSize) {
		this.fromSize = fromSize;
	}
	public Integer getIsInvite() {
		return isInvite;
	}
	public void setIsInvite(Integer isInvite) {
		this.isInvite = isInvite;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuestion() {
		return question;
	}
	public void setQuestion(Integer question) {
		this.question = question;
	}
	public Integer getAnswerRight() {
		return answerRight;
	}
	public void setAnswerRight(Integer answerRight) {
		this.answerRight = answerRight;
	}
	public Integer getAvatar() {
		return avatar;
	}
	public void setAvatar(Integer avatar) {
		this.avatar = avatar;
	}
	public Integer getNickname() {
		return nickname;
	}
	public void setNickname(Integer nickname) {
		this.nickname = nickname;
	}
	public Integer getRequiredInfo() {
		return requiredInfo;
	}
	public void setRequiredInfo(Integer requiredInfo) {
		this.requiredInfo = requiredInfo;
	}
	public Integer getNonRequiredInfo() {
		return nonRequiredInfo;
	}
	public void setNonRequiredInfo(Integer nonRequiredInfo) {
		this.nonRequiredInfo = nonRequiredInfo;
	}
	
}
