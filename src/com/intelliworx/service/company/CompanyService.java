package com.intelliworx.service.company;

import com.intelliworx.domain.company.ICompany;
import com.intelliworx.persistence.company.ICompanyDAO;
import com.intelliworx.persistence.company.ICompanyDTO;

public class CompanyService implements ICompanyService{

	private ICompanyDAO companyDAO;
	
	public ICompanyDAO getCompanyDAO() {
		return companyDAO;
	}

	public void setCompanyDAO(ICompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	@Override
	public void save(ICompany company) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ICompanyDTO find(Integer companyId) {
		// TODO Auto-generated method stub
		return this.companyDAO.find(companyId);
	}

//	@Override
//	public ICompany find(String companyCode) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public ICompany createCompany() {
		// TODO Auto-generated method stub
		return null;
	}

}
