package com.magic.rent.mapper;

import com.magic.rent.pojo.Contract;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractMapper {
    int deleteByPrimaryKey(int id);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);
}