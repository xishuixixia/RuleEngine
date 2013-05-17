package com.hxrainbow.rule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 规则条件实体类
 * 
 * @author guolei
 * @version 1.0
 * @created 2013-4-9
 */
@Entity
@Table(name = "t_action_meta_variable")
public class TActionMetaVariable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id; //主键
	private String name;//动作类型变量名称
	private String identify;//动作类型变量标识
	@Column(name="action_meta_id")
	private Integer actionMetaId;//动作类型id
	
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
	public String getIdentify() {
		return identify;
	}
	public void setIdentify(String identify) {
		this.identify = identify.trim();
	}
	public Integer getActionMetaId() {
		return actionMetaId;
	}
	public void setActionMetaId(Integer actionMetaId) {
		this.actionMetaId = actionMetaId;
	}
}