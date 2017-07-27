package service;

import java.util.List;

import entity.Smbms_provider;

public interface ProService {
	public List<Smbms_provider> getAllPro();
	
	public Integer addPro(Smbms_provider pro);
	
	public Smbms_provider getProById(Integer id);
	
	public Integer updatePro(Smbms_provider pro);
	
	public Integer delProById(Integer id);
	
	public List<Smbms_provider> getProByName(String proName);
}
