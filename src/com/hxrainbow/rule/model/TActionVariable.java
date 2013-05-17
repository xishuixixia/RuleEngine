package com.hxrainbow.rule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 动作对应的变量的值中间表
 * 
 * @author guolei
 * @version 1.0
 * @created 2013-4-9
 */
@Entity
@Table(name = "t_action_variable")
public class TActionVariable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id; //主键
	@Column(name="action_id")
	private Integer actionId;//动作id
	@Column(name="variable_id")
	private Integer variableId;//变量id
	@Column(name="variable_value")
	private String variableValue;//动作值
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getActionId() {
		return actionId;
	}
	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}
	public Integer getVariableId() {
		return variableId;
	}
	public void setVariableId(Integer variableId) {
		this.variableId = variableId;
	}
	public String getVariableValue() {
		return variableValue;
	}
	public void setVariableValue(String variableValue) {
		this.variableValue = variableValue;
	}
	
}