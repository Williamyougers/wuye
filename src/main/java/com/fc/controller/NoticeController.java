package com.fc.controller;

import com.fc.entity.Notice;
import com.fc.service.NoticeService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @PostMapping("add")
    public ResultVo add(Notice notice){
    return noticeService.add(notice);
    }
}
