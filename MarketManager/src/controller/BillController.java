package controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Smbms_bill;
import entity.Smbms_provider;
import entity.Smbms_user;

import service.BIllService;
import service.ProService;
import util.Page;

@Controller
@RequestMapping("/bill")
public class BillController {
	@Autowired
	private BIllService billService;
	@Autowired
	private ProService proService;
	private Page page;
	
	@RequestMapping(value="/billList/{id}")
	public String showBills(@PathVariable("id")Integer id,Model model,String productName,String proName,Integer isPayment,
			Integer n) throws UnsupportedEncodingException{
		if(isPayment==null||isPayment==0){
			isPayment=null;
		}
		if(proName!=null){
			proName=URLDecoder.decode(proName,"utf-8");
		}
		if(productName!=null){
			productName=URLDecoder.decode(productName,"utf-8");
		}
		page=new Page();
		page.setN(1);
		page.setSize(5);
		page.setTotalSize(billService.getSize(productName, isPayment, proName));
		page.setTotalPage(page.getTotalSize()%page.getSize()==0?page.getTotalSize()/page.getSize():page.getTotalSize()/page.getSize()+1);
		if(n!=null){
			page.setN(n);
		}
		model.addAttribute("proName", proName);
		model.addAttribute("productName", productName);
		model.addAttribute("isPayment", isPayment);
		model.addAttribute("page",page);
		model.addAttribute("n",n);
		if(id==0){
			List<Smbms_bill> bills=billService.getAllBills((page.getN()-1)*page.getSize(),page.getSize());
			model.addAttribute("bills", bills);
		}else{
			List<Smbms_bill> bills=billService.getBillsByMsg((page.getN()-1)*page.getSize(),page.getSize(), productName, isPayment, proName);
			model.addAttribute("bills", bills);
		}
		return "billList";
	}
	
	@RequestMapping("/addBill/{id}")
	public String addBill(@PathVariable("id")Integer id,Smbms_bill bill,Model model,HttpServletRequest request){
		if(id==0){//显示添加详细页面
			List<Smbms_provider> pros=proService.getAllPro();
			model.addAttribute("billPros",pros);
			return "billAdd";
		}else {//进行添加操作
			bill.setCreatedBy(((Smbms_user)request.getSession().getAttribute("user")).getId());
			bill.setCreationDate(new Date());
			bill.setModifyBy(((Smbms_user)request.getSession().getAttribute("user")).getId());
			bill.setModifyDate(new Date());
			int len=billService.addBill(bill);
			if(len>0){
				return "redirect:../billList/0";
			}else {
				return "redirect:0";
			}
		}
	}
	
	
	@RequestMapping("/billView/{id}")
	public String showBillById(@PathVariable("id")Integer id,Model model){
		Smbms_bill bill=billService.getBillById(id);
		model.addAttribute("bill", bill);
		return "billView";
	}
	
	
	@RequestMapping("/updateBillView/{id}")
	public String updateBillView(@PathVariable("id")Integer id,Model model){
		Smbms_bill bill=billService.getBillById(id);
		model.addAttribute("bill", bill);
		List<Smbms_provider> pros=proService.getAllPro();
		Map<Integer, String> proNames=new HashMap<Integer, String>();
		for(Smbms_provider p:pros){
			proNames.put(p.getId(), p.getProName());
		}
		model.addAttribute("proNames", proNames);
		Map<Integer, String> isPay=new HashMap<Integer, String>();
		isPay.put(1, "否");
		isPay.put(2, "是");
		model.addAttribute("isPay", isPay);
		return "billUpdate";
	}
	
	@RequestMapping("/updateBill/{id}")
	public String updateBill(@PathVariable("id")Integer id,Smbms_bill bill,Model model,HttpServletRequest request){
		if(bill.getCreatedBy()==null){
			bill.setCreatedBy(((Smbms_user)request.getSession().getAttribute("user")).getId());
		}
		if(bill.getCreationDate()==null){
			bill.setCreationDate(new Date());
		}
		bill.setModifyBy(((Smbms_user)request.getSession().getAttribute("user")).getId());
		bill.setModifyDate(new Date());
		int len=billService.updateBill(bill);
		if(len>0){
			return "redirect:../billList/0";
		}else {
			return "redirect:../updateBillView/"+id;
		}
	}
	
	@RequestMapping("/delBill/{id}")
	public String delBill(@PathVariable("id")Integer id){
		int len=billService.delBillById(id);
		if(len>0){
			return "redirect:../billList/0";
		}else {
			return "redirect:../billView/"+id;
		}
	}
}
