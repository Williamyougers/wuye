package com.fc.service;

import com.fc.entity.House;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface HouseService {
    List<House> findByOwnerId(String id);

    List<House> findAll(Integer pageNum, Integer pageSize);
}
