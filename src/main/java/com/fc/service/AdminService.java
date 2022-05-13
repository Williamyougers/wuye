package com.fc.service;

import com.fc.entity.Admin;
import com.fc.vo.ResultVo;

import java.util.List;

public interface AdminService {
    ResultVo login(String username, String password);
}
