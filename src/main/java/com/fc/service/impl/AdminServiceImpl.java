package com.fc.service.impl;

import com.fc.dao.AdminMapper;
import com.fc.entity.Admin;
import com.fc.entity.AdminExample;
import com.fc.service.AdminService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ResultVo login(String username, String password) {
        ResultVo vo = new ResultVo();
        vo.setCode(0);

        AdminExample example = new AdminExample();

        AdminExample.Criteria criteria = example.createCriteria();

        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        List<Admin> admins = adminMapper.selectByExample(example);

        if (admins != null && admins.size() > 0) {
            vo.setCode(300);
            vo.setSuccess(true);
            vo.setData(admins.get(0));
        }

        return vo;
    }

    @Override
    public List<Admin> findAll() {
        return adminMapper.selectByExample(null);
    }

    @Override
    public ResultVo adminDelete(Integer id) {
        ResultVo resultVo = new ResultVo();

        if (id == null) {
            resultVo.setCode(0);
            resultVo.setMessage("删除失败");
            resultVo.setSuccess(false);
        } else {
            int affectedRows = adminMapper.deleteByPrimaryKey(id);

            if (affectedRows > 0) {
                resultVo.setCode(1);
                resultVo.setSuccess(true);
                resultVo.setMessage("删除成功");
            }
        }

        return resultVo;


    }

    @Override
    public ResultVo adminAdd(Admin admin) {
        ResultVo resultVo = new ResultVo();
        int affectedRows = adminMapper.insertSelective(admin);

        if (affectedRows > 0) {
            resultVo.setCode(1);
            resultVo.setSuccess(true);
        } else {
            resultVo.setCode(0);
            resultVo.setSuccess(false);
            resultVo.setMessage("添加失败");
            resultVo.setData(admin);
        }
        return resultVo;
    }

}
