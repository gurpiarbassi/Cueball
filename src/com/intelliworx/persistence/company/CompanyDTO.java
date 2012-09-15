package com.intelliworx.persistence.company;

import org.joda.time.LocalDate;

import com.intelliworx.persistence.PersistenceEntity;
import com.intelliworx.persistence.address.IAddressDTO;

/**
 * Represents a Company entity
 * @author gurps
 *
 */
public class CompanyDTO extends PersistenceEntity implements ICompanyDTO{

	private String name;
	private String registrationNumber;
	private IAddressDTO address;
	private String code;
	private Integer taxSchemeId;
	private LocalDate incorporationDate;
	
	
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
	public IAddressDTO getAddress() {
		return address;
	}
	public void setAddress(IAddressDTO address) {
		this.address = address;
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
	public LocalDate getIncorporationDate() {
		return incorporationDate;
	}
	public void setIncorporationDate(LocalDate incorporationDate) {
		this.incorporationDate = incorporationDate;
	}
	
	
}
