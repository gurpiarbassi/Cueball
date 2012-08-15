package com.intelliworx.persistence.company;

import java.util.Date;

import com.intelliworx.persistence.PersistenceEntity;

/**
 * Represents a Company entity
 * @author gurps
 *
 */
public class CompanyDTO extends PersistenceEntity implements ICompanyDTO{

	private String name;
	private String registrationNumber;
	private Integer addressId;
	private String code;
	private Integer taxSchemeId;
	private Date dateCreated;
	private Date dateModified;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getTaxSchemeId() {
		return taxSchemeId;
	}
	public void setTaxSchemeId(Integer taxSchemeId) {
		this.taxSchemeId = taxSchemeId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	
}
