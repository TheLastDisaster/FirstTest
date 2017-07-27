package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import dao.BillMapper;

import entity.Smbms_bill;

import service.BIllService;
@Service
public class BillServiceImpl implements BIllService{
	@Resource
	private BillMapper billDao;

	@Override
	public List<Smbms_bill> getAllBills(Integer startUp,Integer size) {
		return billDao.getAllBills(startUp,size);
	}

	@Override
	public int addBill(Smbms_bill bill) {
		return billDao.addBill(bill);
	}

	@Override
	public Smbms_bill getBillById(Integer id) {
		return billDao.getBillById(id);
	}

	@Override
	public Integer updateBill(Smbms_bill bill) {
		return billDao.updateBill(bill);
	}

	@Override
	public Integer delBillById(Integer id) {
		return billDao.delBillById(id);
	}

	@Override
	public List<Smbms_bill> getBillsByMsg( Integer startUp,
			 Integer size,
			 String productName,
			Integer isPayment,
			String proName) {
		// TODO Auto-generated method stub
		return billDao.getBillsByMsg(startUp, size, productName, isPayment, proName);
	}

	@Override
	public int getSize(String productName, Integer isPayment, String proName) {
		// TODO Auto-generated method stub
		return billDao.getSize(productName, isPayment, proName);
	}
	
}
