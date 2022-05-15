package com.fc.controller;

import com.fc.entity.Notice;
import com.fc.service.NoticeService;
import com.fc.vo.ResultVO;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @PostMapping("add")
    public ResultVO add(Notice notice){
    return noticeService.add(notice);
    }
}
