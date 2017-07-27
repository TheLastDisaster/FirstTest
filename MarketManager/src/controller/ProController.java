package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Smbms_provider;
import entity.Smbms_user;

import service.ProService;

@Controller
@RequestMapping("/pro")
public class ProController {
	@Autowired
	private ProService proService;
	
	@RequestMapping(value="/proList/{id}")
	public String showPros(@PathVariable("id")Integer id,String proName ,Model model){
		if(id==0){
			List<Smbms_provider> pros= proService.getAllPro();
			model.addAttribute("pros", pros);
		}else{
			List<Smbms_provider> pros=proService.getProByName(proName);
			model.addAttribute("pros", pros);
		}
		return "providerList";
	}
	
	@RequestMapping(value="/addPro",method=RequestMethod.PUT)
	public String addPro(Smbms_provider pro,HttpServletRequest request){
		pro.setCreatedBy(((Smbms_user)request.getSession().getAttribute("user")).getId());
		pro.setCreationDate(new Date());
		pro.setModifyBy(((Smbms_user)request.getSession().getAttribute("user")).getId());
		pro.setModifyDate(new Date());
		int len=proService.addPro(pro);
		if(len>0){
			return "redirect:proList/0";
		}else{
			return "providerAdd";
		}
	}
	
	@RequestMapping(value="/proView/{id}",method=RequestMethod.GET)
	public String showProDetail(@PathVariable("id")Integer id,Model model){
		Smbms_provider pro=proService.getProById(id);
		model.addAttribute("pro",pro);
		return "providerView";
	}
	
	@RequestMapping(value="/updatePro/{id}",method=RequestMethod.POST)
	public String showUpdateDetail(@PathVariable("id")Integer id,Model model){
		Smbms_provider pro=proService.getProById(id);
		model.addAttribute("pro", pro);
		return "providerUpdate";
	}
	
	@RequestMapping(value="/doUpdatePro/{id}",method=RequestMethod.POST)
	public String UpdatePro(Smbms_provider pro,HttpServletRequest request){
		pro.setModifyDate(new Date());
		pro.setModifyBy(((Smbms_user)request.getSession().getAttribute("user")).getId());
		System.out.println(pro);
		int len=proService.updatePro(pro);
		if(len>0){
			return "redirect:../proList/0";
		}else{
			return "redirect:../updatePro/"+pro.getId();
		}
	}
	
	
	@RequestMapping(value="/delPro/{id}",method=RequestMethod.POST)
	public String delPro(@PathVariable("id")Integer id){
		int len=proService.delProById(id);
		if(len>0){
			return "redirect:../proList/0";
		}else{
			return "redirect:../proView/"+id;
		}
	}
}
