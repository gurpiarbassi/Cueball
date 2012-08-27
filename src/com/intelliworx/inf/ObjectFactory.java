package com.intelliworx.inf;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;

public class ObjectFactory implements BeanFactoryAware
{
  private static BeanFactory beanFactory;
  private static ObjectFactory instance;

  /**
   * Beanfactory populated by Spring
   * @param beanFactory the current bean factory
   * @throws BeansException
   */
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException
  {
    this.beanFactory = beanFactory;
  }

  /**
   * Construct the factory to allow objects to be created programatically. This will be
   * instantiated by Spring. Subsequent calls to this constructor will set the local factory to
   * that from the static variable
   */
  public ObjectFactory()
  {
    if (instance == null)
    {
      instance = this;
    }
    else
    {
      this.beanFactory = instance.beanFactory;
    }
  }

  /**
   * Static method to access the stored bean factory
   * @return the current bean factory
   */
  public static ObjectFactory getInstance()
  {
    if (instance == null)
    {
      ObjectFactory of = new ObjectFactory();
      BeanFactoryLocator bf = ContextSingletonBeanFactoryLocator.getInstance("classpath:spring/beanRefFactory.xml");
      of.setBeanFactory(bf.useBeanFactory("com.intelliworx.inf").getFactory());
    }
    return instance;
  }

  /**
   * Call the bean factory to create an instance of the specified class
   * @param clazz the class to create
   * @return an instance of the specified class
   */
  public Object getInstance(Class clazz)
  {
    return beanFactory.getBean(clazz.getName());
  }

  /**
   * Call the bean factory to create an instance of a bean with the spoecified name
   *
   * @param name the name of the bean to create
   * @return an instance of the specified class
   */
  public Object getInstance(String name)
  {
    return beanFactory.getBean(name);
  }
}