package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Smbms_role implements Serializable{
	private static final long serialVersionUID = -5069581837165950154L;
	private int id,createdBy,modifyBy;
	private String roleName,roleCode;
	private Date creationDate,modifyDate;
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
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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
		return "Smbms_role [id=" + id + ", createdBy=" + createdBy
				+ ", modifyBy=" + modifyBy + ", roleName=" + roleName
				+ ", roleCode=" + roleCode + ", creationDate=" + creationDate
				+ ", modifyDate=" + modifyDate + "]";
	}
	
	
	
}
