package com.fc.service;

import com.fc.entity.House;
import com.fc.vo.ResultVo;

import java.util.List;

public interface HouseService {
    List<House> findByOwnerId(String id);

    List<House> findAll();

    ResultVo add(House house);

    ResultVo update(House house);

    House findById(Integer id);

    ResultVo delete(Integer id);
}
