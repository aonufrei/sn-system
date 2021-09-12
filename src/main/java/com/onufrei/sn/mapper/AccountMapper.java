package com.onufrei.sn.mapper;

import com.onufrei.sn.dto.AccountDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {
	int add(@Param("account") AccountDto accountDto);

	int update(@Param("account") AccountDto accountDto);

	void delete(@Param("id") Long accountId);

	AccountDto getByUsername(@Param("username") String username);

	Boolean exist(@Param("username") String username, @Param("password") String password);
}
