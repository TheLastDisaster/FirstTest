package service;


import java.util.List;

import entity.Smbms_user;

import util.ResultData;

public interface UserService {
	
	public ResultData isLogin(String userCode,String userPassword);
	
	public List<Smbms_user> getAllUsers(Integer startUp,Integer size);
	
	public Smbms_user getUserById(Integer id);
	
	public Integer updateUser(Smbms_user user);
	
	public Integer addUser(Smbms_user user);
	
	public List<Smbms_user> queryUsers(String name,Integer startUp,Integer size);
	
	public Integer delUserById(Integer id);
	
	public Integer getsize();
	
	public int getSizeByName(String uerName);
}
