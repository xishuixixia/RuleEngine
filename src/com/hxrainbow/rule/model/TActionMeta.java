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
@Table(name = "t_action_meta")
public class TActionMeta{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id; //主键
	private String name;//动作类型名称
	@Column(name="method_c")
	private String methodC;//动作类型对应的方法
	private String description;
	
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
	public String getMethodC() {
		return methodC;
	}
	public void setMethodC(String methodC) {
		this.methodC = methodC;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}