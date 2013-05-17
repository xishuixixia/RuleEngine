package com.hxrainbow.rule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_user")
public class TestUser {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;//主键
	
	@Column(name="name")
	private String name;//字段显示名称
	@Column(name="point")
	private Integer point;//字段
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name.trim();
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	
	
	
}
