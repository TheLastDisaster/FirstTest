package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Smbms_bill;

public interface BillMapper {
	
	public int addBill(Smbms_bill bill);

	public List<Smbms_bill> getAllBills(@Param("startUp")Integer startUp,@Param("size")Integer size);
	
	public Smbms_bill getBillById(Integer id);
	
	public int getSize(@Param("productName")String productName,@Param("isPayment")Integer isPayment,@Param("proName")String proName);
	
	public Integer updateBill(Smbms_bill bill);
	
	public Integer delBillById(Integer id);
	
	public List<Smbms_bill> getBillsByMsg(@Param("startUp")Integer startUp,@Param("size")Integer size,@Param("productName")String productName,@Param("isPayment")Integer isPayment,@Param("proName")String proName);

}
