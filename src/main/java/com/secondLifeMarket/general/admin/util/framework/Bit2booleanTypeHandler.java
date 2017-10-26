package com.secondLifeMarket.general.admin.util.framework;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("rawtypes")
public class Bit2booleanTypeHandler implements TypeHandler {

	public void setParameter(PreparedStatement ps, int i, Object parameter,
			JdbcType jdbcType) throws SQLException {
		Boolean b = (Boolean) parameter;
        String value = b == true ? "1" : "0";
        ps.setString(i, value);
		
	}

	public Object getResult(ResultSet rs, String columnName)
			throws SQLException {
		 String str = rs.getString(columnName);
	        Boolean rt = Boolean.FALSE;
	        if (str.equalsIgnoreCase("1")){
	            rt = Boolean.TRUE;
	        }
	        return rt;
	}

	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		 Boolean b = rs.getBoolean(columnIndex);
	        return b == true ? "1" : "0";
	}

	public Object getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		 Boolean b = cs.getBoolean(columnIndex);
	        return b == true ? "1" : "0";
	}

    
}
