package com.fc.controller;

import com.fc.entity.Admin;
import com.fc.entity.House;
import com.fc.service.HouseService;
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
@RequestMapping("house")
public class HouseController {
    @Autowired
    private HouseService houseService;
    ModelAndView mv;
    @RequestMapping("/houseList")
    public String houseList(Model model,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,3);
        List<House> list = houseService.findAll();
        PageInfo<House> pageInfo = new PageInfo<>(list);
        model.addAttribute("houses",pageInfo.getList());
        return "forward:house-list.jsp";
    }
    @RequestMapping("/houseAdd")
    public int houseAdd(House house){

        return houseService.houseAdd(house);
    }
}
