package com.intelliworx.service.company;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intelliworx.persistence.company.ICompanyDTO;

public class TestSpring {

	public static void main(String[] args){
	
		
		ApplicationContext context= new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext.xml", "spring/spring-dataAccessContext.xml", "spring/beanRefFactory.xml", "mybatis/*.*"});
	    BeanFactory factory = context;
	    ICompanyService myBean = (ICompanyService) factory.getBean("companyService");
	    ICompanyDTO x = myBean.find(1);
		System.out.println(x);
	    
	    
//	XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(
//			"spring-beans.xml"));
//
//			CompanyService myBean = (CompanyService) factory
//			.getBean("testSpringBean");
//			myBean.find(1);
	}
			
}
