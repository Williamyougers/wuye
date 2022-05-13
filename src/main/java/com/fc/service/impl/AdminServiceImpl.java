package com.fc.service.impl;

import com.fc.dao.AdminMapper;
import com.fc.entity.Admin;
import com.fc.entity.AdminExample;
import com.fc.entity.CustomAccount;
import com.fc.entity.CustomAccountExample;
import com.fc.service.AdminService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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
}
