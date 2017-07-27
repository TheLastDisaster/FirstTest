package entity;

import java.io.Serializable;
import java.util.Date;

public class Smbms_provider implements Serializable{
	private static final long serialVersionUID = 3767996435751479654L;
	private int id,createdBy,modifyBy;
	private Date creationDate,modifyDate;
	private String proCode,ProName,ProDesc,ProContact,ProPhone,ProAddress,ProFax;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public int getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
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
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	public String getProName() {
		return ProName;
	}
	public void setProName(String proName) {
		ProName = proName;
	}
	public String getProDesc() {
		return ProDesc;
	}
	public void setProDesc(String proDesc) {
		ProDesc = proDesc;
	}
	public String getProContact() {
		return ProContact;
	}
	public void setProContact(String proContact) {
		ProContact = proContact;
	}
	public String getProPhone() {
		return ProPhone;
	}
	public void setProPhone(String proPhone) {
		ProPhone = proPhone;
	}
	public String getProAddress() {
		return ProAddress;
	}
	public void setProAddress(String proAddress) {
		ProAddress = proAddress;
	}
	public String getProFax() {
		return ProFax;
	}
	public void setProFax(String proFax) {
		ProFax = proFax;
	}
	@Override
	public String toString() {
		return "Smbms_provider [id=" + id + ", createdBy=" + createdBy
				+ ", modifyBy=" + modifyBy + ", creationDate=" + creationDate
				+ ", modifyDate=" + modifyDate + ", proCode=" + proCode
				+ ", ProName=" + ProName + ", ProDesc=" + ProDesc
				+ ", ProContact=" + ProContact + ", ProPhone=" + ProPhone
				+ ", ProAddress=" + ProAddress + ", ProFax=" + ProFax + "]";
	}
	
}
