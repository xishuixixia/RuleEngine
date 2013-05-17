package com.hxrainbow.rule.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * 实体
 *
 * @author guolei
 * @version 1.0
 * @created 2013-4-9 上午10:46:46
 * @history 
 * @see
 */
@Entity
@Table(name = "t_entity")
public class TEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;//主键
	private String name;//实体名称(显示名称)
	private String identify;//实体标识
	@Column(name="package_c")
	private String packageC;//包名
	
	@OneToMany(fetch=FetchType.LAZY,targetEntity=TEntityItem.class,cascade=CascadeType.REMOVE)
	@JoinColumn(name="type_id")
	private List<TEntityItem> prorperties=new ArrayList<TEntityItem>();
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
		this.identify = identify;
	}
	public String getPackageC() {
		return packageC;
	}
	public void setPackageC(String packageC) {
		this.packageC = packageC;
	}
	public List<TEntityItem> getProrperties() {
		return prorperties;
	}
	public void setProrperties(List<TEntityItem> prorperties) {
		this.prorperties = prorperties;
	}
	public String getEntityClazz(){
		int index =  packageC.lastIndexOf(".");
		return packageC.substring(index+1);
	}
	
}