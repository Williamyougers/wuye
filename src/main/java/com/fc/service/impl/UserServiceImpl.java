package com.fc.service.impl;

import com.fc.dao.AdminMapper;
import com.fc.entity.Admin;
import com.fc.entity.AdminExample;
import com.fc.service.UserService;
import com.fc.util.MD5Util;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.relation.Role;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private AdminMapper adminMapper;

//    @Override
//    public Admin adminLogin(String username, String password) {
//
//            ResultVo resultVo;
//
//            AdminExample example = new AdminExample();
//
//        AdminExample.Criteria criteria = example.createCriteria();
//
//            criteria.andNameEqualTo(username);
//            criteria.andPasswordEqualTo(password);
//
//            List<Admin> users = adminMapper.selectByExample(example);
//
//            if (users.size() > 0) {
//                // 成功
//                resultVo = new ResultVo(200, "登录成功", true, users.get(0));
//            } else {
//                // 失败
//                resultVo = new ResultVo(0, "登录失败，用户名或密码错误", false, null);
//            }
//
//            return resultVo;
//        }

    @Override
    public Admin login(String username, String password) {
        @Autowired
        private AdminMapper adminMapper;


            AdminExample adminExample = new AdminExample();

        AdminExample.Criteria criteria = adminExample.createCriteria();

            criteria.andNameEqualTo(username);

            List<Admin> admins = adminMapper.selectByExample(adminExample);

            if (admins != null && admins.size() != 0) {
                Admin user = admins.get(0);

                if (user.getPassword().equals(password)) {
                    return adminMapper.selectByPrimaryKey(user.getId());
                }
            }

            return null;

        }}}



//    @Override
//    public ResultVo adminLogin(String password, String username) {
//        ResultVo resultVo;
//        //创建标准
//        AdminExample example = new AdminExample();
//
//        AdminExample.Criteria criteria = example.createCriteria();
//
//        criteria.andNameEqualTo(username);
//
//        List<Admin> admins = adminMapper.selectByExample(example);
//        if (admins.size()>0||username.equals(admins.get())){
//            resultVo = new ResultVo(1,"登录成功",true,admins.get(0));
//        }else {
//            resultVo = new ResultVo(-1,"用户名或密码错误",false,null);
//        }
//        return resultVo;
//    }

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

