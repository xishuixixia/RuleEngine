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
 * 规则条件实体类
 * 
 * @author guolei
 * @version 1.0
 * @created 2013-4-9
 */
@Entity
@Table(name = "t_condition")
public class TCondition{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id; //主键
	private String name;//条件名称
	@Temporal(TemporalType.DATE)
	@Column(name="date_entered")
	private Date dateEntered;//创建日期
	@Temporal(TemporalType.DATE)
	@Column(name="date_modified")
	private Date dateModified;//修改日期
	@Column(name="type_id")
	private Integer typeId;//条件类型
	@Column(name="condition_c")
	private String condition;//条件
	private String description;//条件描述
	
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

	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}