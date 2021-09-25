package com.onufrei.sn.mapper;

import com.onufrei.sn.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {
	int add(@Param("account") Account account);

	int update(@Param("id") Long id, @Param("account") Account account);

	void delete(@Param("id") Long accountId);

	Account getByUsername(@Param("username") String username);

	Boolean exist(@Param("username") String username, @Param("password") String password);
}
