package entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Smbms_user implements Serializable {

	private static final long serialVersionUID = 6432795969744551829L;
	private String userCode,userName,userPassword,phone,address;
	private Integer id,gender,createdBy,modifyBy;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private Date creationDate,modifyDate;
	private Smbms_role userRole;
	
	public Smbms_role getUserRole() {
		return userRole;
	}
	public void setUserRole(Smbms_role userRole) {
		this.userRole = userRole;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	@Override
	public String toString() {
		return "Smbms_user [userCode=" + userCode + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", phone=" + phone
				+ ", address=" + address + ", id=" + id + ", gender=" + gender
				+ ", createdBy=" + createdBy + ", modifyBy=" + modifyBy
				+ ", birthday=" + birthday + ", creationDate=" + creationDate
				+ ", modifyDate=" + modifyDate + ", userRole=" + userRole + "]";
	}
	
}
