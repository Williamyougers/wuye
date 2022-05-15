package com.fc.service.impl;

import com.fc.dao.HouseMapper;
import com.fc.entity.House;
import com.fc.entity.HouseExample;
import com.fc.service.HouseService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public List<House> findByOwnerId(String id) {
        HouseExample example = new HouseExample();

        HouseExample.Criteria criteria = example.createCriteria();

        criteria.andOwneridEqualTo(id);

        return houseMapper.selectByExample(example);
    }

    @Override
    public List<House> findAll(Integer pageNum, Integer pageSize) {
        return houseMapper.selectByExample(null);
    }
}
