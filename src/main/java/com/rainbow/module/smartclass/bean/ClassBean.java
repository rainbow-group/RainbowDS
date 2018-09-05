package com.rainbow.module.smartclass.bean;

import java.util.Date;

import com.rainbow.core.annotation.Column;

/**
 * @author Ray Rainbow
 */
public class ClassBean {

	@Column(name = "id")
	Integer id;

	@Column(name = "name")
	String name;

	@Column(name = "desc")
	String desc;

	@Column(name = "level")
	Integer level;

	@Column(name = "type")
	Integer type;

	@Column(name = "created_By")
	Integer createdBy;

	@Column(name = "created_Date")
	Date createdDate;

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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
