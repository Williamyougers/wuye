package com.fc.controller;

import com.fc.entity.Admin;
import com.fc.entity.House;
import com.fc.service.HouseService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("houseList")
    public ModelAndView houseList(@RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "10000000") Integer pageSize,
                                  ModelAndView mv) {
        PageHelper.startPage(pageNum, pageSize);
        List<House> list = houseService.findAll();
        PageInfo<House> pageInfo = new PageInfo<>(list);
        mv.addObject("houses", pageInfo.getList());
        mv.setViewName("forward:house-list.jsp");
        return mv;
    }

    @RequestMapping("findByOwnerid")
    public ModelAndView findByOwnerid(String ownerid, ModelAndView mv) {
        List<House> houses = houseService.findByOwnerId(ownerid);

        mv.addObject("houses", houses);

        mv.setViewName("forward:/house/user-house-list.jsp");

        return mv;
    }

    @PostMapping("houseAdd")
    public ModelAndView houseAdd(ModelAndView mv, House house) {
        ResultVo vo = houseService.add(house);
        if (vo.getCode() == 200) {
            mv.addObject("houses", vo.getData());
            mv.setViewName("forward:houseList");
        }
        return mv;
    }

    @GetMapping("findById")
    public ModelAndView findById(Integer id,ModelAndView mv){
        House house = houseService.findById(id);
        mv.addObject("house",house);
        mv.setViewName("house-edit.jsp");
        return mv;
    }

    @PostMapping("houseEdit")
    public ModelAndView update(House house, ModelAndView mv) {
            ResultVo vo = houseService.update(house);
            if (vo.getSuccess().equals(true)) {
                mv.addObject("houses", vo.getData());
                mv.setViewName("forward:houseList");
        }
        return mv;
    }

    @GetMapping("houseDelete")
    public ModelAndView delete(ModelAndView mv, Integer id) {
        ResultVo vo = houseService.delete(id);
        if (vo.getCode() == 200) {
            mv.addObject("house",vo.getData());
            mv.setViewName("forward:houseList");
        }
        return mv;
    }
}
