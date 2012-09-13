package com.intelliworx.inf.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.dao.DataAccessException;

import com.intelliworx.inf.PersistenceDates;

public class DateTimeTypeHandler extends BaseTypeHandler<Date> {

	@Override
	public Date getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		String value = rs.getString(columnName);
		if (rs.wasNull()) {
			return null;
		} else {
			try {
				return getDateObject(value);
			} catch (DataAccessException pe) {
				throw new SQLException(pe.getMessage());
			}
		}
	}

	@Override
	public Date getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		String value = rs.getString(columnIndex);
		if (rs.wasNull()) {
			return null;
		} else {
			try {
				return getDateObject(value);
			} catch (DataAccessException pe) {
				throw new SQLException(pe.getMessage());
			}
		}
	}

	@Override
	public Date getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		String value = cs.getString(columnIndex);
		if (cs.wasNull()) {
			return null;
		} else {
			try {
				return getDateObject(value);
			} catch (DataAccessException pe) {
				throw new SQLException(pe.getMessage());
			}
		}
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int columnIndex,
			Date param, JdbcType jdbcType) throws SQLException {
		String dateString = toString(param);
		ps.setString(columnIndex, dateString);
	}

	@Override
	public void setParameter(PreparedStatement ps, int columnIndex, Date param,
			JdbcType jdbcType) throws SQLException {
		String dateString = toString(param);
		if (dateString == null) {
			ps.setNull(columnIndex, Types.VARCHAR);
			return;
		}
		ps.setString(columnIndex, dateString);
	}

	protected String toString(Object parameter) {
		return PersistenceDates.databaseDate((Date) parameter);
	}

	protected Date getDateObject(String value) {
		return PersistenceDates.date(value);
	}

}
