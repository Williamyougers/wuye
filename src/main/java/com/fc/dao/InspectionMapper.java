package com.fc.dao;

import com.fc.entity.Inspection;
import com.fc.entity.InspectionExample;
import java.util.List;

import com.fc.vo.ResultVo;
import com.sun.javafx.beans.IDProperty;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionMapper {
    long countByExample(InspectionExample example);

    int deleteByExample(InspectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Inspection record);

    int insertSelective(Inspection record);

    List<Inspection> selectByExample(InspectionExample example);

    Inspection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Inspection record, @Param("example") InspectionExample example);

    int updateByExample(@Param("record") Inspection record, @Param("example") InspectionExample example);

    int updateByPrimaryKeySelective(Inspection record);

    int updateByPrimaryKey(Inspection record);




}