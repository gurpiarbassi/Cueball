package com.intelliworx.persistence.company;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.intelliworx.domain.company.ICompany;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
 
public class CompanyDAO implements ICompanyDAO{
	
	    private HibernateTemplate hibernateTemplate;
	 
	    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
	        this.hibernateTemplate = hibernateTemplate;
	    }
	 
	    public HibernateTemplate getHibernateTemplate(){
	        return hibernateTemplate;
	    }
	 
	    public ICompanyDTO find(int id){
	    	Session session = hibernateTemplate.getSessionFactory().openSession();
	    	ICompanyDTO dto = null;
	    	try{
	    		dto = (ICompanyDTO)session.load(ICompanyDTO.class, id);
	    	}
	    	catch(HibernateException he){
	    		he.printStackTrace();
	    	}
	    	finally {
	            if (session != null) {
	                try {
	                    session.close();
	                } catch (HibernateException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	    	return dto;
	    }
}
