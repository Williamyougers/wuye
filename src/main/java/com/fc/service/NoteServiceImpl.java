package com.fc.service;

import com.fc.dao.NoticeMapper;
import com.fc.entity.Notice;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NoteServiceImpl implements NoticeService{
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public ResultVO add(Notice notice) {
        if (notice.getNdate() == null) {
            notice.setNdate(new Date());
        }


        int affectedRows = noticeMapper.insertSelective(notice);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "公告添加成功", true, notice);
        } else {
            resultVO = new ResultVO(-1000, "公告添加失败", false, null);
        }

        return resultVO;
    }
}
