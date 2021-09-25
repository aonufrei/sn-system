package com.onufrei.sn.mapper;

import com.onufrei.sn.model.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthorityMapper {

	int add(@Param("authority") Authority authority);

	int addToAccount(@Param("account_id") Long accountId, @Param("authority_id") Long authorityId);

	int update(@Param("id") Long id, @Param("authority") Authority authority);

	void delete(@Param("id") Long id);

	Authority getById(@Param("id") Long id);

	List<Authority> getAll();

}
