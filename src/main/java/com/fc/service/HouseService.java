package com.fc.service;

import com.fc.entity.House;

import java.util.List;

public interface HouseService {
    List<House> findAll();

    int houseAdd(House house);
}
