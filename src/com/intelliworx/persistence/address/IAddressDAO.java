package com.intelliworx.persistence.address;

public interface IAddressDAO {

	public IAddressDTO findByPrimaryKey(int id);
	
	public void insert(IAddressDTO addressDTO);
	
	public void update(IAddressDTO addressDTO);
	
	public void delete(IAddressDTO addressDTO);
}

