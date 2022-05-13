package com.fc.dao;

import com.fc.entity.CustomAccount;
import com.fc.entity.CustomAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomAccountMapper {
    long countByExample(CustomAccountExample example);

    int deleteByExample(CustomAccountExample example);

    int deleteByPrimaryKey(Integer accountid);

    int insert(CustomAccount record);

    int insertSelective(CustomAccount record);

    List<CustomAccount> selectByExample(CustomAccountExample example);

    CustomAccount selectByPrimaryKey(Integer accountid);

    int updateByExampleSelective(@Param("record") CustomAccount record, @Param("example") CustomAccountExample example);

    int updateByExample(@Param("record") CustomAccount record, @Param("example") CustomAccountExample example);

    int updateByPrimaryKeySelective(CustomAccount record);

    int updateByPrimaryKey(CustomAccount record);
}