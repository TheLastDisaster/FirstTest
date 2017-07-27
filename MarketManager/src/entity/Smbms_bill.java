package entity;

import java.io.Serializable;
import java.util.Date;

public class Smbms_bill implements Serializable{
	private static final long serialVersionUID = -8561623140625071356L;
	private Integer id,isPayment,createdBy,modifyBy;
	private double productCount,totalPrice;
	private String billCode,productName,productDesc,productUnit;
	private Date creationDate,modifyDate;
	private Integer providerId;
	private Smbms_provider provider;
	
	

	public Smbms_provider getProvider() {
		return provider;
	}

	public void setProvider(Smbms_provider provider) {
		this.provider = provider;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIsPayment() {
		return isPayment;
	}
	
	public void setIsPayment(Integer isPayment) {
		this.isPayment = isPayment;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}

	public double getProductCount() {
		return productCount;
	}

	public void setProductCount(double productCount) {
		this.productCount = productCount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	@Override
	public String toString() {
		return "Smbms_bill [id=" + id + ", isPayment=" + isPayment
				+ ", createdBy=" + createdBy + ", modifyBy=" + modifyBy
				+ ", productCount=" + productCount + ", totalPrice="
				+ totalPrice + ", billCode=" + billCode + ", productName="
				+ productName + ", productDesc=" + productDesc
				+ ", productUnit=" + productUnit
				+ ", creationDate=" + creationDate + ", modifyDate="
				+ modifyDate + ", providerId=" + providerId + ", provider="
				+ provider + "]";
	}


	
}
