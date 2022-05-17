package com.fc.service.impl;

import com.fc.dao.AdminMapper;
import com.fc.entity.Admin;
import com.fc.entity.AdminExample;
import com.fc.service.AdminService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ResultVo login(String username, String password) {
        ResultVo vo = new ResultVo();
        vo.setCode(0);

        AdminExample example = new AdminExample();

        AdminExample.Criteria criteria = example.createCriteria();

        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        List<Admin> admins = adminMapper.selectByExample(example);

        if (admins != null && admins.size() > 0) {
            vo.setCode(200);
            vo.setSuccess(true);
            vo.setData(admins.get(0));
        }
if (admins==null&&admins.size()==0){
    ModelAndView mv = null;

    vo.setCode(-1);
    mv.setViewName("redirect:loginFail.html");

}

        return vo;
    }

    @Override
    public List<Admin> findAll() {
        return adminMapper.selectByExample(null);
    }

    @Override
    public ResultVo adminDelete( Integer id) {
        ResultVo resultVo = new ResultVo();

        if (id == null) {
            resultVo.setCode(-1);
            resultVo.setMessage("删除失败");
            resultVo.setSuccess(false);
        } else {
            int affectedRows = adminMapper.deleteByPrimaryKey(id);

            if (affectedRows > 0) {
                resultVo.setCode(1);
                resultVo.setSuccess(true);
                resultVo.setMessage("删除成功");
            }else {
                System.err.println("Fail");
            }
        }

        return resultVo;


    }

    @Override
    public ResultVo adminAdd(Admin admin) {
        ResultVo resultVo = new ResultVo();
        int affectedRows = adminMapper.insertSelective(admin);

        if (affectedRows > 0) {
            resultVo.setCode(200);
            resultVo.setSuccess(true);
            resultVo.setMessage("添加失败");
        } else {
            resultVo.setCode(500);
            resultVo.setSuccess(false);
            resultVo.setMessage("添加失败");
            resultVo.setData(admin);
        }
        return resultVo;
    }

    @Override
    public ResultVo findById(Integer id) {
        ResultVo resultVo = new ResultVo();

        int affectedRows = adminMapper.selectByPrimaryKey(id);

        if (affectedRows>0){
            resultVo.setCode(200);
            resultVo.setSuccess(true);
            resultVo.setMessage("编辑成功");
            resultVo.setData(id);
        }else {
            resultVo.setCode(500);
            resultVo.setSuccess(false);
            resultVo.setMessage("编辑失败");
            resultVo.setData(null);
        }
        return resultVo;
    }


}
