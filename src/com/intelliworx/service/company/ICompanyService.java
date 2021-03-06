package com.intelliworx.service.company;

import com.intelliworx.persistence.company.ICompanyDTO;

public interface ICompanyService {
	
	public ICompanyDTO find(Integer companyId);
	
	public ICompanyDTO find(String companyCode);
	
	public void save(ICompanyDTO company);
	
}
