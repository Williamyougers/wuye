package com.fc.service;

import com.fc.entity.Admin;
//import com.fc.vo.ResultVo;

import javax.management.relation.Role;


public interface UserService {
//    ResultVo adminLogin( String username,String password);

    Admin login(String username, String password);
}
