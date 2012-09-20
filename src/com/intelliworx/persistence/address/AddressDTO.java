package com.intelliworx.persistence.address;

import com.intelliworx.persistence.PersistenceEntity;

public class AddressDTO extends PersistenceEntity implements IAddressDTO{

	private static final long serialVersionUID = 1L;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String address5;
	private String postalCode;
	private String emailAddress;
	private String telephone;
	private String fax;
	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		setModified(this.address1, address1);
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		setModified(this.address2, address2);
		this.address2 = address2;
	}
	public String getAddress3() {
		setModified(this.address3, address3);
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getAddress4() {
		return address4;
	}
	public void setAddress4(String address4) {
		setModified(this.address4, address4);
		this.address4 = address4;
	}
	public String getAddress5() {
		return address5;
	}
	public void setAddress5(String address5) {
		setModified(this.address5, address5);
		this.address5 = address5;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		setModified(this.postalCode, postalCode);
		this.postalCode = postalCode;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		setModified(this.emailAddress, emailAddress);
		this.emailAddress = emailAddress;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		setModified(this.telephone, telephone);
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		setModified(this.fax, fax);
		this.fax = fax;
	}
}
