package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserMapper;
import entity.Smbms_user;
import service.UserService;
import util.ResultData;

@Service
@Transactional//事务管理方式
public class UserServiceImpl implements UserService{
	@Resource//按照名称name装配bean
	private UserMapper userDao;

	@Override
	public ResultData isLogin(String userCode, String userPassword) {
		Smbms_user user= userDao.getUserByUserCode(userCode);
		ResultData rd=new ResultData();
		if(user==null){
			rd.setFlag(1);
			rd.setMsg("用户名不存在！");
		}else{
			if(userPassword.equals(user.getUserPassword())){
				rd.setFlag(0);
				rd.setMsg("登陆成功！");
				rd.setData(user);
			}else{
				rd.setFlag(2);
				rd.setMsg("密码不正确！");
			}
		}
		return rd;
	}

	@Override
	public List<Smbms_user> getAllUsers(Integer startUp,Integer size) {
		List<Smbms_user> users=userDao.getAllUsers(startUp, size);
		return users;
	}

	@Override
	public Smbms_user getUserById(Integer id) {
		Smbms_user user=userDao.getUserById(id);
		return user;
	}

	@Override
	public Integer updateUser(Smbms_user user) {
		int len =userDao.updateUser(user);
		return len;
	}

	@Override
	public Integer addUser(Smbms_user user) {
		int len =userDao.addUser(user);
		return len;
	}

	@Override
	public List<Smbms_user> queryUsers(String name,Integer startUp,Integer size) {
		List<Smbms_user> users=userDao.queryUsers(name,startUp,size);
		return users;
	}

	@Override
	public Integer delUserById(Integer id) {
		return userDao.delUserById(id);
	}

	@Override
	public Integer getsize() {
		return userDao.getSize();
	}

	@Override
	public int getSizeByName(String uerName) {
		return userDao.getSizeByName(uerName);
	}
	
}
