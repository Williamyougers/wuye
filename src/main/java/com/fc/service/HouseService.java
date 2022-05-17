package com.fc.service;

import com.fc.entity.House;

import java.util.List;

public interface HouseService {
    List<House> findAll(House house,Integer pageNum, Integer pageSize);
}
