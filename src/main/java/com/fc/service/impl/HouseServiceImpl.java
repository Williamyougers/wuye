package com.fc.service.impl;

import com.fc.dao.HouseMapper;
import com.fc.entity.House;
import com.fc.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
@Autowired
private HouseMapper mapper;
    @Override
    public List<House> findAll() {
        return mapper.selectByExample(null);
    }

    @Override
    public int houseAdd(House house) {
        return mapper.insert(house);
    }
}
