package com.intelliworx.persistence.company;

public interface ICompanyDAO {

	public ICompanyDTO findByPrimaryKey(int id);
	
	public ICompanyDTO findByCompanyCode(String code);
	
	public void insert(ICompanyDTO companyDTO);
	
	public void update(ICompanyDTO companyDTO);
	
	public void delete(ICompanyDTO companyDTO);
}
