package com.fc.service.impl;

import com.fc.dao.MaintainMapper;
import com.fc.entity.Maintain;
import com.fc.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintainServiceImpl implements MaintainService {
    @Autowired
    private MaintainMapper maintainMapper;

    @Override
    public List<Maintain> getList() {
        return maintainMapper.selectByExample(null);
    }



}
