package com.onufrei.sn.typehandler;

import com.onufrei.sn.constants.CommentType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.SMALLINT)
public class CommentTypeTypeHandler extends BaseTypeHandler<CommentType> {

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, CommentType commentType, JdbcType jdbcType) throws SQLException {
		preparedStatement.setInt(i, commentType.getValue());
	}

	@Override
	public CommentType getNullableResult(ResultSet resultSet, String s) throws SQLException {
		return CommentType.fromValue(resultSet.getInt(s));
	}

	@Override
	public CommentType getNullableResult(ResultSet resultSet, int i) throws SQLException {
		return CommentType.fromValue(resultSet.getInt(i));
	}

	@Override
	public CommentType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		return CommentType.fromValue(callableStatement.getInt(i));
	}
}
