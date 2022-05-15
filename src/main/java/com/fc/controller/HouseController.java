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

    @RequestMapping("houseList")
    public ModelAndView findByOwnerId(@RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "3") Integer pageSize,
                                  ModelAndView mv) {
        PageHelper.startPage(pageNum,pageSize);

        List<House> list = houseService.findAll(pageNum, pageSize);
        PageInfo<House> pageInfo = new PageInfo<>(list);
        mv.addObject("house",pageInfo.getList());
        mv.setViewName("forward:/house/house-list.jsp");
        return mv;
    }

    @RequestMapping("findByOwnerid")
    public ModelAndView findByOwnerid(String ownerid, ModelAndView mv) {
        List<House> houses = houseService.findByOwnerId(ownerid);

        mv.addObject("houses", houses);

        mv.setViewName("forward:/house/user-house-list.jsp");

        return mv;
    }
}
