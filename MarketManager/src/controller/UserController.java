package controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import entity.Smbms_user;

import service.UserService;
import util.Page;
import util.ResultData;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired//按照类型加载bean
	private UserService userService;
	private Page page;
	
	@RequestMapping(value="/login")
	@ResponseBody//json方式时特有的注解，将该方法的处理结果写入http response body（响应流）中，输送给客户端
	public String isLogin(String userCode,String userPassword,HttpServletRequest request){
		ResultData rd = userService.isLogin(userCode, userPassword);
		if(rd.getFlag()==0)
		request.getSession().setAttribute("user",rd.getData());
		return JSON.toJSONString(rd);
	}
	
	@RequestMapping(value="/loginOut")
	public String loginOut(HttpServletRequest request){
		request.getSession().removeAttribute("user");
		System.out.println(request.getSession().getAttribute("user"));
		return "center";
	}
	
	@RequestMapping(value="/userList/{flag}")
	public String showUsers(@PathVariable("flag")Integer flag,Map<String, Object> model,String name,Integer n){	
		page=new Page();
		page.setN(1);
		page.setSize(5);
		page.setTotalSize(userService.getsize());
		page.setTotalPage(page.getTotalSize()%page.getSize()==0?page.getTotalSize()/page.getSize():page.getTotalSize()/page.getSize()+1);
		if(n!=null){
			page.setN(n);
		}
		model.put("page", page);
		model.put("name", name);
		if(flag==null||flag==0){
			//从左导航栏进入
			List<Smbms_user> users=userService.getAllUsers((page.getN()-1)*page.getSize(),page.getSize());
			model.put("users", users);
		}else{
			//模糊查询
			page.setTotalSize(userService.getSizeByName(name));
			page.setTotalPage(page.getTotalSize()%page.getSize()==0?page.getTotalSize()/page.getSize():page.getTotalSize()/page.getSize()+1);
			if(n>page.getTotalPage()){
				page.setN(page.getTotalPage());
			}
			List<Smbms_user> users=userService.queryUsers(name,(page.getN()-1)*page.getSize(),page.getSize());
			model.put("users", users);
		}
		return "UserList";
	}
	
	@RequestMapping(value="/findUser/{id}",method=RequestMethod.GET)
	public String showUserDetails(@PathVariable("id")Integer id,Model model){
		Smbms_user user=userService.getUserById(id);
		//将user对象放到request里
		model.addAttribute("user", user);//session里已经有了一个user对象 但是jsp会先从requset里找user 找不到再找session里的user
		return "userView";
	}
	
	@RequestMapping(value="/findUser/{id}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable("id")Integer id,Model model){
		Smbms_user user=userService.getUserById(id);
		Map<String, String> sexs=new HashMap<String, String>();
		sexs.put("1", "男");
		sexs.put("2", "女");
		model.addAttribute("sexs", sexs);
		Map<String, String> userTypes=new HashMap<String, String>();
		userTypes.put("1", "系统管理员");
		userTypes.put("2", "经理");
		userTypes.put("3", "普通员工");
		model.addAttribute("userTypes", userTypes);
		//将user对象放到request里
		model.addAttribute("user", user);//session里已经有了一个user对象 但是jsp会先从requset里找user 找不到再找session里的user
		return "userUpdate";
	}
	@RequestMapping(value="/userUpdate",method=RequestMethod.PUT)
	public String showNewUsers(Smbms_user user,HttpServletRequest request){
		user.setModifyBy(((Smbms_user)request.getSession().getAttribute("user")).getId());
		user.setModifyDate(new Date());
		int len=userService.updateUser(user);
		if(len>0){
			return "redirect:userList/0";
		}else{
			return "userUpdate";
		}
	}
	
	@RequestMapping(value="/userAdd")
	public String userAdd(){
		return "userAdd";
	}
	
	@RequestMapping(value="/addUser")
	public String addUser(Smbms_user user,HttpServletRequest request){
		user.setCreatedBy(((Smbms_user)request.getSession().getAttribute("user")).getId());
		user.setCreationDate(new Date());
		user.setModifyBy(((Smbms_user)request.getSession().getAttribute("user")).getId());
		user.setModifyDate(new Date());
		int len=userService.addUser(user);
		if(len>0){
			return "redirect:userList/0";
		}else{
			return "userAdd";
		}
	}
	
	@RequestMapping(value="/delUser/{id}",method=RequestMethod.DELETE)
	public String delUser(@PathVariable("id")Integer id){
		int len=userService.delUserById(id);
		if(len>0){
			return "redirect:../userList/0";
		}else{
			return "userView";
		}
	}
	
	@RequestMapping(value="/pwdUpdate")
	public String pwdUpdate(Integer id,String oldPassword,String newPassword) throws IOException{
		Smbms_user user=userService.getUserById(id);
		if(user.getUserPassword().equals(oldPassword)){
			user.setUserPassword(newPassword);
			userService.updateUser(user);
			return "center";
		}else{
			return "updatePwd";
		}
		
	}
}
