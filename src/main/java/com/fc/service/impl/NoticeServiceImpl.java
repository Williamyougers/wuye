package com.fc.service.impl;

import com.fc.dao.NoticeMapper;
import com.fc.entity.Notice;
import com.fc.service.NoticeService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> getList() {
        return noticeMapper.selectByExample(null);
    }

    @Override
    public ResultVo delete(Integer id) {
        ResultVo resultVo = new ResultVo();
        int affectedRows = noticeMapper.deleteByPrimaryKey(id);

        if (affectedRows > 0) {
            resultVo.setCode(1);
            resultVo.setSuccess(true);
            resultVo.setMessage("删除成功");
        } else {
            System.err.println("Fail");
            resultVo.setSuccess(false);
        }

        return resultVo;
    }

    @Override
    public List<Notice> findAll() {
        return noticeMapper.selectByExample(null);
    }

    @Override
    public ResultVo add(Notice notice) {
        ResultVo resultVo = new ResultVo();
        int affectedRows = noticeMapper.insertSelective(notice);

        if (affectedRows > 0) {
            resultVo.setCode(200);
        } else {
            resultVo.setCode(500);
        }

        return resultVo;
    }


}
