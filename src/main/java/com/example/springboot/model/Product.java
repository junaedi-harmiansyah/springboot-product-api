package com.example.springboot.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "product", schema = "public")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, updatable = false, nullable = false)
	private Integer id;

	@Column(name = "name", length = 25, nullable = false)
	private String name;

	@Column(name = "marketing", length = 50, nullable = false)
	private String marketing;

	@Column(name = "status", nullable = false)
	private Integer status;

	@Column(name = "selling_price", nullable = false)
	private BigDecimal sellingPrice;

	@Column(name = "buy_price", nullable = false)
	private BigDecimal buyPrice;

	@Column(name = "margin", nullable = false)
	private BigDecimal margin;

	@Column(name = "buy_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Jakarta")
	private Date buyDate;

	@Column(name = "selling_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Jakarta")
	private Date sellingDate;

	@Column(name = "create_by", nullable = true)
	private String createBy;

	@Column(name = "create_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Jakarta")
	private Date createDate;

	@Column(name = "modified_by", nullable = true)
	private String modifiedBy;

	@Column(name = "modified_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Jakarta")
	private Date modifiedDate;

	@Column(name = "discription", nullable = true, length = 100)
	private String discription;

	@Column(name = "is_active", nullable = false)
	private Integer isActive;

	@Column(name = "marketing_id", nullable = false)
	private Integer marketingId;


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

	public String getMarketing() {
		return marketing;
	}

	public void setMarketing(String marketing) {
		this.marketing = marketing;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	public BigDecimal getMargin() {
		return margin;
	}

	public void setMargin(BigDecimal margin) {
		this.margin = margin;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public Date getSellingDate() {
		return sellingDate;
	}

	public void setSellingDate(Date sellingDate) {
		this.sellingDate = sellingDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getMarketingId() {
		return marketingId;
	}

	public void setMarketingId(Integer marketingId) {
		this.marketingId = marketingId;
	}

	
	
}
