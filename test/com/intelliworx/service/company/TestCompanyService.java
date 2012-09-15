package com.intelliworx.service.company;


import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intelliworx.persistence.address.IAddressDTO;
import com.intelliworx.persistence.company.ICompanyDTO;

public class TestCompanyService {
	
	private ICompanyService companyService;
	
	@Before public void setUp() { 
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring/applicationContext.xml",
						"spring/spring-dataAccessContext.xml",
						"spring/beanRefFactory.xml", "mybatis/*.*" });
		BeanFactory beanFactory = context; 
		companyService = (ICompanyService) beanFactory.getBean("companyService");
    }
	
	@Test
	public void testFindCompany() {
		
		final int companyId = 1;
		ICompanyDTO company = companyService.find(companyId);
		assertNotNull(company);
		
		assertEquals("INTELLIWORX LIMITED", company.getName());
		assertEquals("123435", company.getRegistrationNumber());
		assertEquals("INTWX", company.getCode());
		assertNull(company.getDateModified());
		
		LocalDate incorporationDate = company.getIncorporationDate();
		int incYear = incorporationDate.getYear();
		int incMonth = incorporationDate.getMonthOfYear();
		int incDay = incorporationDate.getDayOfMonth();
		
		assertEquals(2011, incYear);
		assertEquals(9, incMonth);
		assertEquals(23, incDay);
		
		LocalDateTime dateCreated = company.getDateCreated();
		int createdYear = dateCreated.getYear();
		int createdMonth = dateCreated.getMonthOfYear();
		int createdDay = dateCreated.getDayOfMonth();
		
		assertEquals(2012, createdYear);
		assertEquals(9, createdMonth);
		assertEquals(15, createdDay);
		
		IAddressDTO address = company.getAddress();
		assertNotNull(address);
		
		assertEquals(1, address.getPrimaryKey().intValue());
		assertEquals("2 Haytor Rise", address.getAddress1());
		assertEquals("Coventry", address.getAddress2());
		assertEquals("CV2 3LE", address.getPostalCode());
		assertNull(address.getAddress3());
		assertNull(address.getAddress4());
		assertNull(address.getAddress5());
		assertEquals("info@intelliworx.co.uk", address.getEmailAddress());
		assertEquals("07547032355", address.getTelephone());
		assertNull(address.getDateModified());
	}

}
