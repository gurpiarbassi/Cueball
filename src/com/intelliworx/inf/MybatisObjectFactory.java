package com.intelliworx.inf;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import com.intelliworx.persistence.IPersistenceEntity;


public class MybatisObjectFactory extends DefaultObjectFactory{
	
	private static final long serialVersionUID = 1L;
	
	  public MybatisObjectFactory()
	  {
	    super();
	  }

	  public Object create(Class aClass) {
		  Object o = null;
		    if (aClass.getName().equals("java.util.HashMap"))
		    {
		      return new HashMap();
		    }
		    if (aClass.getName().equals("java.util.List"))
		    {
		      return new ArrayList();
		    }
		    if (aClass.getName().equals("java.util.Collection"))
		    {
		      return new ArrayList();
		    }
		    o = ObjectFactory.getInstance().getInstance(aClass);
		    if (o instanceof IPersistenceEntity)
		    {
		      ((IPersistenceEntity)o).setPersisted();
		      ((IPersistenceEntity)o).setLoaded();
		    }

		    return o;
		  }
		  
	  /**
	   * Called from iBatis to create an instance of a particular object. The class information
	   * passed in is the class specified in the mybatis-config.xml file. If the request is for some
	   * form of list then return an empty array list. If this is a domain object then mark it as persisted.
	   *
	   * @param string the name of the statement being called
	   * @param aClass the class myBatis wishes to instantiate
	   * @return a class created through the Object Factory
	   * @throws InstantiationException
	   * @throws IllegalAccessException
	   */
	 /* public Object createInstance(String string, Class aClass) throws InstantiationException, IllegalAccessException
	  {
		  
	    Object o = null;
	    if (aClass.getName().equals("java.util.HashMap"))
	    {
	      return new HashMap();
	    }
	    if (aClass.getName().equals("java.util.List"))
	    {
	      return new ArrayList();
	    }
	    if (aClass.getName().equals("java.util.Collection"))
	    {
	      return new ArrayList();
	    }
	    o = ObjectFactory.getInstance().getInstance(aClass);
//	    if (o instanceof IPersistenceInfo)
//	    {
//	      ((IPersistenceInfo)o).setPersisted();
//	      ((IPersistenceInfo) o).setLoaded();
//	    }

	    return o;
	  }*/

	  /**
	   * Set a property value, configured in the sql-map-config file. Not used in this implementation.
	   * @param name the property name
	   * @param value the property value
	   */
	  public void setProperty(String name, String value)
	  {
	    // do nothing
	  }
}
