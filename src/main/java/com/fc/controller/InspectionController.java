package com.fc.controller;

import com.fc.entity.Inspection;
import com.fc.service.InspectionService;
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
@RequestMapping("inspection")
public class InspectionController {
    @Autowired
    private InspectionService inspectionService;

    @RequestMapping("inspectionList")
    public ModelAndView getlist(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                ModelAndView mv) {

        PageHelper.startPage(pageNum,10);

        List<Inspection> list= inspectionService.findAll();

        PageInfo<Inspection> pageInfo = new PageInfo<>(list);

        mv.addObject ("inspections",pageInfo.getList());

        mv.setViewName("forward:inspection-list.jsp"); ;

        return mv;
    }
    @PostMapping("inspectionAdd")
    public ModelAndView add(Inspection inspection,ModelAndView mv){

        ResultVo vo = inspectionService.add(inspection);

        if (vo.getCode().equals(200)){
            mv.setViewName("forward:inspectionList");
        }else {
            mv.setViewName("forward:inspection-add.jsp");
        }
        return mv;

    }
    @PostMapping ("findById")
    public ModelAndView findById(ModelAndView mv, Inspection inspection){
        int edit = inspectionService.edit(inspection.getId());

        mv.addObject("inspections",edit);

        mv.setViewName("forward:inspection-edit.jsp");

        return mv;
    }



}
