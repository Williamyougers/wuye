package com.fc.service.impl;

import com.fc.dao.HouseMapper;
import com.fc.entity.House;
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
    ModelAndView mv;

    @Override
    public List<House> findAll(House house,Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<House> list = houseMapper.findAll();
        PageInfo<House> pageInfo = new PageInfo<>(list);
        mv.addObject("pageInfo",pageInfo);

        return list;
    }
}
