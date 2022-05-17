package com.fc.controller;

import com.fc.entity.Notice;
import com.fc.service.NoticeService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("noticelist")
    public ModelAndView getList(@RequestParam(defaultValue = "1") Integer pageNum, ModelAndView mv) {
        PageHelper.startPage(pageNum, 10000);

        List<Notice> list = noticeService.getList();

        PageInfo<Notice> pageInfo = new PageInfo<>(list);

        mv.addObject("notice", pageInfo.getList());

        mv.setViewName("forward:notice-list.jsp");

        return mv;
    }


    @PostMapping("noticeadd")
    public ModelAndView add(Notice notice, ModelAndView mv) {

        ResultVo vo = noticeService.add(notice);

        if (vo.getCode().equals(200)) {
            mv.setViewName("forward:notice-list.jsp");
        } else {
            mv.setViewName("forward:notice-add.jsp");
        }
        return mv;

    }

    @GetMapping("noticeDelete")
    public ModelAndView noticedelete(Integer id, ModelAndView mv) {
        ResultVo resultVo = noticeService.delete(id);
        System.err.println("resultVo" + resultVo);

        if (resultVo.getSuccess().equals(true)) {
            mv.setViewName("forward:noticelist");
        }

        return mv;


    }

}
