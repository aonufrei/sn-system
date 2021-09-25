package com.onufrei.sn.mapper;

import com.onufrei.sn.model.Profile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProfileMapper {

	int add(@Param("profile") Profile profile);

	int update(@Param("id") Long id, @Param("profile") Profile profile);

	void delete(@Param("id") Long id);

	Profile getByAccountId(@Param("accountId") Long accountId);

	Profile getById(@Param("id") Long id);
}
