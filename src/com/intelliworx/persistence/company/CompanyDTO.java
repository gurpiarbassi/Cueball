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

	private static final long serialVersionUID = 1L;
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
		//setModified(this.name, name);
		this.name = name;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		//setModified(this.registrationNumber, registrationNumber);
		this.registrationNumber = registrationNumber;
	}
	public IAddressDTO getAddress() {
		return address;
	}
	public void setAddress(IAddressDTO address) {
		//setModified(this.address, address);
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		//setModified(this.code, code);
		this.code = code;
	}
	public Integer getTaxSchemeId() {
		return taxSchemeId;
	}
	public void setTaxSchemeId(Integer taxSchemeId) {
		//setModified(this.taxSchemeId, taxSchemeId);
		this.taxSchemeId = taxSchemeId;
	}
	public LocalDate getIncorporationDate() {
		return incorporationDate;
	}
	public void setIncorporationDate(LocalDate incorporationDate) {
		//setModified(this.incorporationDate, incorporationDate);
		this.incorporationDate = incorporationDate;
	}
	
	
}
