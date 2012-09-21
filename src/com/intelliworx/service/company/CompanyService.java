package com.intelliworx.service.company;

import com.intelliworx.persistence.IPersistenceEntity;
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
	public void save(ICompanyDTO company) {
		IAddressDTO address = company.getAddress();
		if(company.getPrimaryKey() ==  null){
			//insert
			addressDAO.insert(address);
			companyDAO.insert(company);
			System.out.println("Inserted the company");
		}
		else if(company.getAction() == IPersistenceEntity.ACTION_DELETE){
			addressDAO.delete(address);
			companyDAO.delete(company);
		}
		else{
			//update
			companyDAO.update(company);
			addressDAO.update(address);
		}
	}
	
}
