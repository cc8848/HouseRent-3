package com.magic.rent.mapper;

import com.magic.rent.pojo.Payment;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMapper {
    int deleteByPrimaryKey(int id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}