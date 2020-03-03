package com.osotnikov.examples.spring.shell.db.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the position database table.
 * 
 */
@Entity
@Table(name="position")
@NamedQuery(name="Position.findAll", query="SELECT p FROM Position p")
public class Position implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="position_id")
	private int positionId;

	@Column(name="management_role")
	private String managementRole;

	@Column(name="max_scale")
	private BigDecimal maxScale;

	@Column(name="min_scale")
	private BigDecimal minScale;

	@Column(name="pay_type")
	private String payType;

	@Column(name="position_title")
	private String positionTitle;

	public Position() {
	}

	public String getManagementRole() {
		return this.managementRole;
	}

	public void setManagementRole(String managementRole) {
		this.managementRole = managementRole;
	}

	public BigDecimal getMaxScale() {
		return this.maxScale;
	}

	public void setMaxScale(BigDecimal maxScale) {
		this.maxScale = maxScale;
	}

	public BigDecimal getMinScale() {
		return this.minScale;
	}

	public void setMinScale(BigDecimal minScale) {
		this.minScale = minScale;
	}

	public String getPayType() {
		return this.payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPositionTitle() {
		return this.positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

}
