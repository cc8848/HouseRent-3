package com.magic.rent.mapper;

import com.magic.rent.pojo.Credentials;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsMapper {

    int deleteByPrimaryKey(int id);

    int insert(Credentials record);

    int insertSelective(Credentials record);

    Credentials selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(Credentials record);

    int updateByPrimaryKey(Credentials record);
}