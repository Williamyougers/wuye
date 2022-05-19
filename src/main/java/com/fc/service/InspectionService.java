package com.fc.service;

import com.fc.entity.Inspection;
import com.fc.vo.ResultVo;

import java.util.List;

public interface InspectionService{
    List<Inspection> findAll();

    ResultVo add(Inspection inspection);

    ResultVo delete(Integer id);

    ResultVo edit(Inspection inspection);
}
