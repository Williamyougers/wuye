package com.fc.service.impl;

import com.fc.dao.AdminMapper;
import com.fc.entity.Admin;
import com.fc.entity.AdminExample;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    ResultVo resultVo;
    @Autowired
    AdminMapper adminMapper;
    @Override
    public ResultVo adminLogin(String password, String name) {

        AdminExample example = new AdminExample();

        AdminExample.Criteria criteria = example.createCriteria();

        criteria.andPasswordEqualTo(password);

        criteria.andNameEqualTo(name);

        List<Admin> admins = adminMapper.selectByExample(example);

        if (admins.size()>0){
            resultVo = new ResultVo(200,"登录成功",true,resultVo.getData());
        }else{
            resultVo = new ResultVo(-1,"登录失败",false,null);
        }
        return resultVo;
    }
}
