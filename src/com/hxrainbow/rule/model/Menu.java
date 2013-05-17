package com.hxrainbow.rule.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class Menu implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;	
	private String name;
	private String url;
	private String image;
	private int parentId;
	private int sequence;
	
	private List<Menu> children=new LinkedList<Menu>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public List<Menu> getChildren() {
		return children;
	}
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	
}
