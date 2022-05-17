package com.fc.service;

import com.fc.entity.Admin;
import com.fc.vo.ResultVo;

import java.util.List;

public interface AdminService {
    ResultVo login(String username, String password);

    List<Admin> findAll();

    ResultVo adminDelete(Integer id);

    ResultVo adminAdd(Admin admin);

    ResultVo findById(Integer id);
}
