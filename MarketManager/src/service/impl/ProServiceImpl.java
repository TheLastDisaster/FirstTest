package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.ProService;

import dao.ProMapper;

import entity.Smbms_provider;

@Service
@Transactional
public class ProServiceImpl implements ProService{
	@Resource
	private ProMapper proDao;

	@Override
	public List<Smbms_provider> getAllPro() {
		List<Smbms_provider> pros= proDao.getAllPro();
		return pros;
	}

	@Override
	public Integer addPro(Smbms_provider pro) {
		return proDao.addPro(pro);
	}

	@Override
	public Smbms_provider getProById(Integer id) {
		return proDao.getProById(id);
	}

	@Override
	public Integer updatePro(Smbms_provider pro) {
		return proDao.updatePro(pro);
	}

	@Override
	public Integer delProById(Integer id) {
		return proDao.delProById(id);
	}

	@Override
	public List<Smbms_provider> getProByName(String proName) {
		return proDao.getProByName(proName);
	}
}
