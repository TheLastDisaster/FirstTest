package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Smbms_bill;



public interface BIllService {
	
	public List<Smbms_bill> getAllBills(@Param("startUp")Integer startUp,@Param("size")Integer size);
	
	public int addBill(Smbms_bill bill);
	
	public int getSize(String productName,Integer isPayment,String proName);
	
	public Smbms_bill getBillById(Integer id);
	
	public Integer updateBill(Smbms_bill bill);
	
	public Integer delBillById(Integer id);
	
	public List<Smbms_bill> getBillsByMsg(Integer startUp,Integer size,String productName,Integer isPayment,String proName);
}
