package com.intelliworx.persistence.address;

import com.intelliworx.persistence.IPersistenceEntity;

public interface IAddressDTO extends IPersistenceEntity {

	public String getAddress1();
	public void setAddress1(String address1);
	public String getAddress2();
	public void setAddress2(String address2) ;
	public String getAddress3();
	public void setAddress3(String address3);
	public String getAddress4();
	public void setAddress4(String address4) ;
	public String getAddress5();
	public void setAddress5(String address5);
	public String getPostalCode();
	public void setPostalCode(String postalCode);
	public String getEmailAddress();
	public void setEmailAddress(String emailAddress);
	public String getTelephone();
	public void setTelephone(String telephone);
	public String getFax();
	public void setFax(String fax);
}
