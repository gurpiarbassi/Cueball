package com.intelliworx.persistence.address;

import com.intelliworx.persistence.BaseDAO;

public class AddressDAOImpl extends BaseDAO implements IAddressDAO{

	private static final String NAMESPACE = "com.intelliworx.persistence.address.IAddressDAO.";
	private static final String FIND_BY_PK = NAMESPACE + "findByPrimaryKey";
	private static final String INSERT = NAMESPACE + "insert";
	private static final String UPDATE = NAMESPACE + "update";
	
	@Override
	public IAddressDTO findByPrimaryKey(int id) {
		return getSqlSession().selectOne(FIND_BY_PK, id);
	}

	@Override
	public void insert(IAddressDTO addressDTO) {
		insert(INSERT, addressDTO);		
	}

	@Override
	public void update(IAddressDTO addressDTO) {
		insert(UPDATE, addressDTO);
	}	
}
