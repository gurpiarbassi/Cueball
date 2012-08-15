package com.intelliworx.persistence.company;

import java.util.Date;

import com.intelliworx.persistence.IPersistenceEntity;

public interface ICompanyDTO extends IPersistenceEntity {

	public String getName();
	public void setName(String name);
	public String getRegistrationNumber();
	public void setRegistrationNumber(String registrationNumber);
	public Integer getAddressId();
	public void setAddressId(Integer addressId);
	public String getCode();
	public void setCode(String code);
	public Integer getTaxSchemeId();
	public void setTaxSchemeId(Integer taxSchemeId);
	public Date getDateCreated();
	public void setDateCreated(Date dateCreated);
	public Date getDateModified();
	public void setDateModified(Date dateModified);

}
