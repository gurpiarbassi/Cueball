package com.intelliworx.service.company;

import com.intelliworx.persistence.address.IAddressDAO;
import com.intelliworx.persistence.address.IAddressDTO;
import com.intelliworx.persistence.company.ICompanyDAO;
import com.intelliworx.persistence.company.ICompanyDTO;

public class CompanyService implements ICompanyService{

	private ICompanyDAO companyDAO;
	private IAddressDAO addressDAO;
	
	public ICompanyDAO getCompanyDAO() {
		return companyDAO;
	}

	public void setCompanyDAO(ICompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	public IAddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(IAddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	@Override
	public ICompanyDTO find(Integer companyId) {
		return this.companyDAO.findByPrimaryKey(companyId);
	}

	@Override
	public ICompanyDTO find(String companyCode) {
		return this.companyDAO.findByCompanyCode(companyCode);
	}

	@Override
	public ICompanyDTO save(ICompanyDTO company) {
		if(company.getPrimaryKey() ==  null){
			//insert
			IAddressDTO address = company.getAddress();
			addressDAO.insert(address);
			System.out.println("address inserted with id = " + address.getPrimaryKey());
			companyDAO.insert(company);
			System.out.println("company inserted with id = " + company.getPrimaryKey());
			return null;
		}
		else{
			//update
			return null;
		}
	}
	
}
