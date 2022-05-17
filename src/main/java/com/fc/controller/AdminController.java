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

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    //查询全部
    @RequestMapping("adminList")
    public String adminList(Model model,@RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "1000000000") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Admin> list = adminService.findAll();
        PageInfo<Admin> pageInfo = new PageInfo<>(list);
        model.addAttribute("admins",pageInfo.getList());
        return "forward:admin-list.jsp";
    }

    //删除
    @RequestMapping("adminDelete")
    public String adminDelete(Integer id,ModelAndView mv){
//        ResultVo resultVo = new ResultVo();
        ResultVo resultVo = adminService.adminDelete(id);
        System.err.println("resultVo"+resultVo);
   if (resultVo.getSuccess() == true){
      return "forward:adminList";
   }else {
       return "forward:adminEdit";
   }

    }

    //添加
    @RequestMapping("adminAdd")
    public ModelAndView adminAdd(Admin admin,ModelAndView mv){
        adminService.adminAdd(admin);
        mv.addObject("admin",admin);
        mv.setViewName("redirect:adminList");
        return mv;

    }
    @RequestMapping("findById")
    public ModelAndView findById(Integer id, ModelAndView mv){
      ResultVo vo = adminService.findById(id);
        mv.addObject("id",id);
       if (vo.getCode().equals(200)){
           mv.setViewName("forward:admin-edit.jsp");
       }
       return mv;

    }

}
