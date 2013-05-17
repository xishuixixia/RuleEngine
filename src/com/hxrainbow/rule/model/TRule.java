package com.hxrainbow.rule.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 规则表
 * 
 * @author guolei
 * @version 1.0
 * @created 2013-4-9
 */
@Entity
@Table(name = "t_rule")
public class TRule{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;//主键
	private String name;//规则名称
	@Temporal(TemporalType.DATE)
	@Column(name="date_entered")
	private Date dateEntered;//创建时间
	@Temporal(TemporalType.DATE)
	@Column(name="date_modified")
	private Date dateModified;//修改时间
	@Column(name="scene_id")
	private Integer sceneId; //场景
	@Column(name="condition_c")
	private String condition;//规则条件
	private String action;//动作
	private Integer enabled;//是否启用 1表示启用 2表示不启动
	@Temporal(TemporalType.DATE)
	private Date begin;//规则开始时间
	@Temporal(TemporalType.DATE)
	private Date end;//规则结束时间
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateEntered() {
		return dateEntered;
	}
	public void setDateEntered(Date dateEntered) {
		this.dateEntered = dateEntered;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	public Integer getSceneId() {
		return sceneId;
	}
	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
}