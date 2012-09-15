package com.intelliworx.service.company;

import com.intelliworx.persistence.company.ICompanyDTO;

public interface ICompanyService {

	//public void save(ICompany company);
	
	public ICompanyDTO find(Integer companyId);
	
	public ICompanyDTO find(String companyCode);
	
	public ICompanyDTO save(ICompanyDTO company);
	
	//public ICompany createCompany();
}
