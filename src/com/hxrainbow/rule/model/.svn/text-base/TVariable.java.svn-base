package com.hxrainbow.rule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 变量实体类
 * 
 * @author guolei
 * @version 1.0
 * @created 2013-4-9
 */
@Entity
@Table(name = "t_variable")
public class TVariable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;//主键
	private String name;//变量名称
	@Column(name="default_value")
	private String defaultValue;//默认值
	private Integer type;//类型  1字符型 2数字型 3 日期型 4 动态
	@Column(name="dynamic_id")
	private Integer dynamicId;//动态变量id
	
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
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getDynamicId() {
		return dynamicId;
	}
	public void setDynamicId(Integer dynamicId) {
		this.dynamicId = dynamicId;
	}
}