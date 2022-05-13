package com.fc.service;

import com.fc.vo.ResultVo;
//import com.fc.vo.ResultVo;


public interface UserService {
//    ResultVo adminLogin( String username,String password);

    ResultVo login(String username, String password);
}
