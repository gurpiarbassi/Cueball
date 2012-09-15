package com.intelliworx.persistence.company;

public interface ICompanyDAO {

	public ICompanyDTO findByPrimaryKey(int id);
	
	public ICompanyDTO findByCompanyCode(String code);
	
	public void insert(ICompanyDTO companyDTO);
}
