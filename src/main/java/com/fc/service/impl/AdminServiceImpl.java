package com.fc.service.impl;

import com.fc.dao.AdminMapper;
import com.fc.entity.Admin;
import com.fc.entity.AdminExample;
import com.fc.service.AdminService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ResultVO login(String username, String password) {
        ResultVO vo = new ResultVO();
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
