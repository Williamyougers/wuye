package com.fc.service.impl;

import com.fc.dao.CustomAccountMapper;
import com.fc.entity.CustomAccount;
import com.fc.entity.CustomAccountExample;
import com.fc.service.UserService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private CustomAccountMapper mapper;

    @Override
    public ResultVO login(String username, String password) {
        ResultVO vo = new ResultVO();
        vo.setCode(0);

        CustomAccountExample example = new CustomAccountExample();

        CustomAccountExample.Criteria criteria = example.createCriteria();

        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        List<CustomAccount> customAccounts = mapper.selectByExample(example);

        if (customAccounts != null && customAccounts.size() > 0) {
            vo.setCode(200);
            vo.setSuccess(true);
            vo.setData(customAccounts.get(0));
        }

        return vo;
    }
}
