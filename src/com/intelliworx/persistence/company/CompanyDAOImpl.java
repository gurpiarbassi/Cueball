package com.intelliworx.persistence.company;

import com.intelliworx.persistence.BaseDAO;

public class CompanyDAOImpl extends BaseDAO implements ICompanyDAO {

	private static final String NAMESPACE = "com.intelliworx.persistence.company.ICompanyDAO.";
	private static final String FIND_BY_PK = NAMESPACE + "findByPrimaryKey";
	private static final String FIND_BY_CODE = NAMESPACE + "findByCompanyCode";
	private static final String INSERT = NAMESPACE + "insert";
	private static final String UPDATE = NAMESPACE + "update";
	private static final String DELETE = NAMESPACE + "delete";
	
	@Override
	public ICompanyDTO findByPrimaryKey(int id) {
		return getSqlSession().selectOne(FIND_BY_PK, id);
	}

	@Override
	public ICompanyDTO findByCompanyCode(String code) {
		return getSqlSession().selectOne(FIND_BY_CODE, code);
	}

	@Override
	public void insert(ICompanyDTO companyDTO) {
		insert(INSERT, companyDTO);
	}

	@Override
	public void update(ICompanyDTO companyDTO) {
		update(UPDATE, companyDTO);
	}
	
	@Override
	public void delete(ICompanyDTO companyDTO) {
		delete(DELETE, companyDTO);
	}
}
