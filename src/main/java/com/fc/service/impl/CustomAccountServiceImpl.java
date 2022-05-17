package com.fc.service.impl;

import com.fc.dao.CustomAccountMapper;
import com.fc.entity.CustomAccount;
import com.fc.service.CustomAccountService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomAccountServiceImpl implements CustomAccountService {
    @Autowired
    private CustomAccountMapper customAccountMapper;

    @Override
    public List<CustomAccount> getList() {
        return customAccountMapper.selectByExample(null);
    }

    @Override
    public ResultVO add(CustomAccount customAccount) {
        ResultVO resultVO = new ResultVO();

        int affectedRows = customAccountMapper.insertSelective(customAccount);

        if (affectedRows > 0){
            resultVO.setCode(200);
            resultVO.setMessage("true");
            resultVO.setSuccess(true);
        }else {
            resultVO.setCode(-1000);
            resultVO.setMessage("false");
            resultVO.setSuccess(false);
        }
        return resultVO;
    }
}
