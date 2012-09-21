package com.intelliworx.persistence;

import org.joda.time.LocalDateTime;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BaseDAO extends SqlSessionDaoSupport{

	public void insert(String statement, IPersistenceEntity entity){
		entity.setDateCreated(new LocalDateTime());
		getSqlSession().insert(statement, entity);
	}
	
	public void update(String statement, IPersistenceEntity entity){
//		if(entity.isModified()){
			entity.setDateModified(new LocalDateTime());
			getSqlSession().update(statement, entity);	
			
//		}
	}
	
	public void delete(String statement, IPersistenceEntity entity){
		getSqlSession().delete(statement, entity);
	}
}
