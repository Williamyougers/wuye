package com.fc.service;

import com.fc.vo.ResultVO;
//import com.fc.vo.ResultVo;


public interface UserService {
//    ResultVo adminLogin( String username,String password);

    ResultVO login(String username, String password);
}
