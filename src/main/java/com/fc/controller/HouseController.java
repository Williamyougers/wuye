package com.fc.controller;

import com.fc.entity.Admin;
import com.fc.entity.House;
import com.fc.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("house")
public class HouseController {
    @Autowired
    private HouseService houseService;
    ModelAndView mv;
    @RequestMapping("houselist")
    public List<House> houseList(House house,Integer pageNum,Integer pageSize){
        List<House> resultVo =  houseService.findAll(house,pageNum,pageSize);
mv.addObject("house");
mv.setViewName("forward:/house/house-list.jsp");
        return resultVo;
    }
}
