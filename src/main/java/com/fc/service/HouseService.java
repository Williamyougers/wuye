package com.fc.service;

import com.fc.entity.Admin;
import com.fc.entity.House;
import com.fc.vo.ResultVo;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface HouseService {
    List<House> findAll(Integer pageNum, Integer pageSize);
}
