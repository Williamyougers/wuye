package com.fc.controller;

import com.fc.entity.CustomAccount;
import com.fc.service.CustomAccountService;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("customAccount")
public class CustomAccountController {
    @Autowired
    private CustomAccountService customAccountService;

    @RequestMapping("customAccountList")
    public String getList(@RequestParam(defaultValue = "1") Integer pageNum,
                          Model model){
        PageHelper.startPage(pageNum,3);

        List<CustomAccount> list = customAccountService.getList();

        PageInfo<CustomAccount> pageInfo = new PageInfo<>(list);

        model.addAttribute("customAccounts",pageInfo.getList());

        return "forward:custom-list.jsp";
    }

    @PostMapping("customAccountAdd")
    public ModelAndView add(CustomAccount customAccount, ModelAndView mv){
       ResultVO vo =  customAccountService.add(customAccount);

       if (vo.getCode() == 200){
           mv.setViewName("forward:custom-list.jsp");
       }
       else {
           mv.setViewName("forward:custom-add.jsp");
       }
       return mv;
    }
}
