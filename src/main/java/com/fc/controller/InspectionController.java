package com.fc.controller;

import com.fc.entity.Inspection;
import com.fc.service.InspectionService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

        PageHelper.startPage(pageNum, 10);

        List<Inspection> list = inspectionService.findAll();

        PageInfo<Inspection> pageInfo = new PageInfo<>(list);

        mv.addObject("inspections", pageInfo.getList());

        mv.setViewName("forward:inspection-list.jsp");
        ;

        return mv;
    }

    @PostMapping("inspectionAdd")
    public ModelAndView add(Inspection inspection, ModelAndView mv) {

        ResultVo vo = inspectionService.add(inspection);

        if (vo.getCode().equals(200)) {
            mv.setViewName("forward:inspectionList");
        } else {
            mv.setViewName("forward:inspection-add.jsp");
        }
        return mv;

    }

    @GetMapping("inspectionDelete")
    public ModelAndView inspectionDelete(Integer id, ModelAndView mv) {
        ResultVo resultVo = inspectionService.delete(id);
        System.err.println("resultVo" + resultVo);

        if (resultVo.getSuccess().equals(true)) {
            mv.setViewName("forward:inspectionList");
        }

        return mv;


    }

    @GetMapping ("edit")
    public ModelAndView findById(Inspection inspection, ModelAndView mv) {
        ResultVo resultVo = inspectionService.edit(inspection);
        if (resultVo.getSuccess().equals(true)) {
            mv.addObject("inspections",resultVo.getData());
            mv.setViewName("forward:inspection-edit.jsp");
        }else
            mv.setViewName("forward:inspection-list.jsp");

        return mv;


    }
}
