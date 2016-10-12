package com.magic.rent.mapper;

import com.magic.rent.pojo.CredentialsType;

public interface CredentialsTypeMapper {
    int deleteByPrimaryKey(int id);

    int insert(CredentialsType record);

    int insertSelective(CredentialsType record);

    CredentialsType selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(CredentialsType record);

    int updateByPrimaryKey(CredentialsType record);
}