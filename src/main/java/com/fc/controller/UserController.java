package com.fc.controller;

import com.fc.entity.Admin;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("adminLogin")

    public ModelAndView adminLogin(ModelAndView mv,
                                   HttpSession session,
                                   String username , String password
                                   ){

        System.err.println(username);
       ResultVo result= userService.adminLogin(username,password);
        Cookie cookie ;
        if (result.getCode() == 1){
           session.setAttribute("admin",result.getData());
            cookie = new Cookie("JSESSIONID",session.getId());
           cookie.setMaxAge(30*60);

           mv.setViewName("redirect:/index.jsp");
       }else {
//           cookie.setMaxAge(0);
           mv.setViewName("redirect:/login.jsp");
       }
       return mv;
    }
//    @RequestMapping("adminLogout")
//    public ModelAndView adminLogout(ModelAndView mv,
//                                   HttpSession session,
//                                   Admin admin,
//                                   Cookie cookie){
//
//
//        return mv;
//    }

}
