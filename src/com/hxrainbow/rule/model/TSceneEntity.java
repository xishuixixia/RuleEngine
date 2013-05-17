package com.hxrainbow.rule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * 场景实体中间表
 *
 * @author guolei
 * @version 1.0
 * @created 2013-4-9 上午10:24:16
 * @history 
 * @see
 */
@Entity
@Table(name = "t_scene_entity")
public class TSceneEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;                                     //主键
	@Column(name="entity_id")
	private Integer entityId;                               //实体id
	@Column(name="scene_id")
	private Integer sceneId;                              //场景id
	
	@Transient
	private String entityIdArr;
	
	@Transient
	private String entityName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEntityId() {
		return entityId;
	}
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}
	public Integer getSceneId() {
		return sceneId;
	}
	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}
	public String getEntityIdArr() {
		return entityIdArr;
	}
	public void setEntityIdArr(String entityIdArr) {
		this.entityIdArr = entityIdArr;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
}