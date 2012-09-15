package com.intelliworx.inf.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;


public class LocalDateTypeHandler implements TypeHandler<LocalDate>
{

    public void setParameter(PreparedStatement ps, int columnIndex, LocalDate parameter, JdbcType jdbcType) throws SQLException
    {
        if (parameter != null)
        {
            ps.setString(columnIndex, parameter.toString(DateTimeFormat.forPattern("yyyy-MM-dd")));
        }
        else
        {
        	ps.setNull(columnIndex, Types.VARCHAR);
        }
    }

    public LocalDate getResult(ResultSet rs, String columnName) throws SQLException
    {
        String value = rs.getString(columnName);
        if (value != null)
        {
            return new LocalDate(value);
        }
        else
        {
            return null;
        }
    }

    public LocalDate getResult(CallableStatement cs, int columnIndex) throws SQLException
    {
    	String value = cs.getString(columnIndex);
        if (value != null)
        {
        	return new LocalDate(value);
        }
        else
        {
            return null;
        }
    }

	@Override
	public LocalDate getResult(ResultSet rs, int columnIndex) throws SQLException {

		String value = rs.getString(columnIndex);
        if (value != null)
        {
        	return new LocalDate(value);
        }
        else
        {
            return null;
        }
	}
}
