package com.hxrainbow.rule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * 实体属性
 *
 * @author guolei
 * @version 1.0
 * @created 2013-4-9 上午10:46:46
 * @history 
 * @see
 */
@Entity
@Table(name = "t_entity_item")
public class TEntityItem{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;//主键
	@Column(name="name")
	private String name;//字段显示名称
	@Column(name="field")
	private String field;//字段
	@Column(name="type_id")
	private Integer typeId;//实体类型id
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="type_id",insertable=false,updatable=false)
	private TEntity entity;
	
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
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public TEntity getEntity() {
		return entity;
	}
	public void setEntity(TEntity entity) {
		this.entity = entity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}