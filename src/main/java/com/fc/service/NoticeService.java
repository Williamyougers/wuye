package com.fc.service;

import com.fc.entity.Notice;
import com.fc.vo.ResultVo;

import java.util.List;

public interface NoticeService {

    ResultVo add(Notice notice);

    List<Notice> getList();

    ResultVo delete(Integer id);

    List<Notice> findAll();
}
