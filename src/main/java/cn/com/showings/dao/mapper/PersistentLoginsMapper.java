package cn.com.showings.dao.mapper;


import cn.com.showings.pojo.PersistentLogins;

public interface PersistentLoginsMapper {
    int deleteByPrimaryKey(String series);

    int insert(PersistentLogins record);

    int insertSelective(PersistentLogins record);

    PersistentLogins selectByPrimaryKey(String series);

    int updateByPrimaryKeySelective(PersistentLogins record);

    int updateByPrimaryKey(PersistentLogins record);
}