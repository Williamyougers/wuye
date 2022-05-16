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
    public List<House> findAll() {
        return houseMapper.selectByExample(null);
    }

    @Override
    public ResultVo add(House house) {
        ResultVo resultVo = new ResultVo();
        int affectedRows = houseMapper.insertSelective(house);
        if (affectedRows > 0){
            resultVo.setCode(200);
            resultVo.setMessage("添加成功！");
            resultVo.setSuccess(true);
        }else {
            resultVo.setCode(-1);
            resultVo.setSuccess(false);
            resultVo.setMessage("添加失败！");
        }
        return resultVo;
    }

    @Override
    public ResultVo update(House house) {
        ResultVo resultVo = new ResultVo();
        int affectedRows = houseMapper.updateByPrimaryKeySelective(house);
        if (affectedRows > 0){
            resultVo.setCode(200);
            resultVo.setMessage("修改信息成功！");
            resultVo.setSuccess(true);
            resultVo.setData(house);
        }else {
            resultVo.setCode(-1);
            resultVo.setMessage("修改信息失败！");
            resultVo.setSuccess(false);
        }
        return null;
    }

    @Override
    public ResultVo findById(Integer id) {
        ResultVo resultVo = new ResultVo();
        House house = houseMapper.selectByPrimaryKey(id);
        if (house != null && house.equals("")){
            resultVo.setCode(200);
            resultVo.setSuccess(true);
            resultVo.setData(house);
        }else {
            resultVo.setCode(-1);
            resultVo.setSuccess(false);
            resultVo.setMessage("未查到此人！");
        }
        return resultVo;
    }

    @Override
    public ResultVo delete(Integer id) {
        ResultVo resultVo = new ResultVo();
        int affectedRows = houseMapper.deleteByPrimaryKey(id);
        if (affectedRows > 0){
            resultVo.setCode(200);
            resultVo.setSuccess(true);
        }else {
            resultVo.setCode(-1);
            resultVo.setSuccess(false);
            resultVo.setMessage("删除失败！");
        }
        return resultVo;
    }
}
