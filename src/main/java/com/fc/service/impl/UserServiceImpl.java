package com.fc.service.impl;

import com.fc.dao.AdminMapper;
import com.fc.entity.Admin;
import com.fc.entity.AdminExample;
import com.fc.service.UserService;
import com.fc.util.MD5Util;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private AdminMapper adminMapper;
    @Override
    public ResultVo adminLogin(String password, String username) {
        ResultVo resultVo;
        AdminExample example = new AdminExample();

        AdminExample.Criteria criteria = example.createCriteria();



        criteria.andNameEqualTo(username);

        List<Admin> admins = adminMapper.selectByExample(example);
        if (admins.size()>0){
            resultVo = new ResultVo(1,"登录成功",true,admins.get(0));
        }else {
            resultVo = new ResultVo(-1,"用户名或密码错误",false,null);
        }
        return resultVo;
    }

//        if (admins!=null){
//            if (admins.get(0).getPassword().equals(MD5Util.encode(password))) {
//                resultVo = new ResultVo(200,"登录成功",true,resultVo.getData());
//            }else {
//                resultVo = new ResultVo(-1,"用户名或密码错误",false,null);
//
//            }
//        }else{
//            resultVo = new ResultVo(-1,"用户不存在",false,null);
//        }
//        return resultVo;
//    }
}
