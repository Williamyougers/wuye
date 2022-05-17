package com.fc.service;

import com.fc.entity.Inspection;
import com.fc.vo.ResultVo;

import java.util.List;

public interface InspectionService{
    List<Inspection> findAll();

    ResultVo add(Inspection inspection);



    int edit(Integer id);
}
