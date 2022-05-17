package com.fc.controller;

import com.fc.entity.Maintain;
import com.fc.service.MaintainService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("maintain")
public class MaintainController {
    @Autowired
    private MaintainService maintainService;

    @RequestMapping("maintainList")
    public String getList(@RequestParam(defaultValue = "1") Integer pageNum,
                          Model model){
        PageHelper.startPage(pageNum,3);

        List<Maintain> list = maintainService.getList();

        PageInfo<Maintain> pageInfo = new PageInfo<>(list);

        model.addAttribute("maintains",pageInfo.getList());

        return "forward:maintain-list.jsp";
    }


}
