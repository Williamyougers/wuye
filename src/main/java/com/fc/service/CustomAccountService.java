package com.fc.service;

import com.fc.entity.CustomAccount;
import com.fc.vo.ResultVO;

import java.util.List;

public interface CustomAccountService {
    List<CustomAccount> getList();

    ResultVO add(CustomAccount customAccount);
}
