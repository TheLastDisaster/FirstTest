package dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import entity.Smbms_user;

public interface UserMapper {
	@Select("select * from smbms_user where userCode=#{userCode}")
	public Smbms_user getUserByUserCode(String userCode);
	
	public List<Smbms_user> getAllUsers(@Param("startUp")Integer startUp,@Param("size")Integer size);
	
	public Smbms_user getUserById(Integer id);
	
	public Integer updateUser(Smbms_user user);
	
	public Integer addUser(Smbms_user user);
	
	public List<Smbms_user> queryUsers(@Param("name")String name,@Param("startUp")Integer startUp,@Param("size")Integer size);
	
	public Integer delUserById(Integer id);
	
	public int getSize();
	
	public int getSizeByName(String uerName);
}
