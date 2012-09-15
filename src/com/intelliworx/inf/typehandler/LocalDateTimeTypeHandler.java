package com.intelliworx.inf.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

public class LocalDateTimeTypeHandler implements TypeHandler<LocalDateTime> {

	public void setParameter(PreparedStatement ps, int columnIndex,
			LocalDateTime parameter, JdbcType jdbcType) throws SQLException {

		if (parameter != null) {
			ps.setString(columnIndex, parameter.toString(DateTimeFormat
					.forPattern("yyyy-MM-dd'T'HH:mm:ss")));
		} else {
			ps.setNull(columnIndex, Types.VARCHAR);
		}
	}

	public LocalDateTime getResult(ResultSet rs, String columnName)
			throws SQLException {
		String value = rs.getString(columnName);
		if (value != null) {
			System.out.println("value is " + value);
			return new LocalDateTime(value);
		} else {
			return null;
		}
	}

	public LocalDateTime getResult(CallableStatement cs, int columnIndex)
			throws SQLException {

		String value = cs.getString(columnIndex);
		if (value != null) {
			return new LocalDateTime(value);
		} else {
			return null;
		}
	}

	@Override
	public LocalDateTime getResult(ResultSet rs, int columnIndex)
			throws SQLException {
		String value = rs.getString(columnIndex);
		if (value != null) {
			return new LocalDateTime(value);
		} else {
			return null;
		}
	}
}
