package com.fc.controller;

import com.fc.entity.Admin;
import com.fc.service.AdminService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("adminList")
    public String adminList(Model model,@RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "10") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Admin> list = adminService.findAll();
        PageInfo<Admin> pageInfo = new PageInfo<>(list);
        model.addAttribute("admins",pageInfo.getList());
        return "forward:admin-list.jsp";
    }
    @RequestMapping("adminDelete")
    public ResultVo adminDelete(Integer id,ModelAndView mv){
   return adminService.adminDelete(id);


    }
    @RequestMapping("adminAdd")
    public ModelAndView adminAdd(Admin admin,ModelAndView mv){
        adminService.adminAdd(admin);
        mv.addObject("admin",admin);
        mv.setViewName("redirect:adminList");
        return mv;

    }

}
