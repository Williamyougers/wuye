package com.fc.service.impl;

import com.fc.dao.InspectionMapper;
import com.fc.entity.Inspection;
import com.fc.service.InspectionService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InspectionServiceImpl implements InspectionService {
    @Autowired
    private InspectionMapper inspectionMapper;
    @Override
    public List<Inspection> findAll() {
        return inspectionMapper.selectByExample(null);
    }

    @Override
    public ResultVo add(Inspection inspection) {
        ResultVo resultVo = new ResultVo();
        int affectedRows = inspectionMapper.insertSelective(inspection);

        if (affectedRows > 0) {
            resultVo.setCode(200);
        } else {
            resultVo.setCode(500);
        }

        return resultVo;
    }

    @Override
    public int edit(Integer id) {
        return inspectionMapper.findById(id);
    }

    @Override
    public ResultVo delete(Integer id) {
        ResultVo resultVo = new ResultVo();
        int affectedRows = inspectionMapper.deleteByPrimaryKey(id);

        if (affectedRows > 0) {
            resultVo.setCode(1);
            resultVo.setSuccess(true);
            resultVo.setMessage("删除成功");
        } else {
            System.err.println("Fail");
            resultVo.setSuccess(false);
        }

        return resultVo;
    }


}
