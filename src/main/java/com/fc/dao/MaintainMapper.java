package com.fc.dao;

import com.fc.entity.Maintain;
import com.fc.entity.MaintainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaintainMapper {
    long countByExample(MaintainExample example);

    int deleteByExample(MaintainExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Maintain record);

    int insertSelective(Maintain record);

    List<Maintain> selectByExample(MaintainExample example);

    Maintain selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Maintain record, @Param("example") MaintainExample example);

    int updateByExample(@Param("record") Maintain record, @Param("example") MaintainExample example);

    int updateByPrimaryKeySelective(Maintain record);

    int updateByPrimaryKey(Maintain record);
}