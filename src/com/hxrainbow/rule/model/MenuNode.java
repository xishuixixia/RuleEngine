package com.hxrainbow.rule.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuNode implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String value;
	
	private boolean check;
	
	private String parentId;
	
	private List<MenuNode> children=new ArrayList<MenuNode>();

	public List<MenuNode> getChildren() {
		return children;
	}

	public void addChild(MenuNode ch) {
		children.add(ch);
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean getCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

}
