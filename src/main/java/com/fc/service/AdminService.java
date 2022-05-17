package com.fc.service;

import com.fc.vo.ResultVO;

public interface AdminService {
    ResultVO login(String username, String password);
}
