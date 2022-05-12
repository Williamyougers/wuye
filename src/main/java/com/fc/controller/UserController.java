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

    public ModelAndView adminLogin(Admin admin,
                                   ModelAndView mv,
                                   HttpSession session,
                                   String username ,
                                   String password,
                                   HttpServletResponse response
                                   ){

//        System.err.println(username);
//        System.err.println(password);
//       ResultVo result= userService.adminLogin(username,password);
//        Cookie cookie ;
//        if (result.getCode() == 1){
//           session.setAttribute("admin",result.getData());
//            cookie = new Cookie("JSESSIONID",session.getId());
//           cookie.setMaxAge(30*60);
//           mv.setViewName("forward:../index.jsp");
//       }else {
////           cookie.setMaxAge(0);
//           mv.setViewName("redirect:/login.jsp");
//       }
//       return mv;
        // 调用业务层的登录方法
        ResultVo resultVo = userService.adminLogin(admin.getName(), admin.getPassword());
        Cookie cookie;
        // 登录成功的情况
        if (resultVo.getCode() == 200) {

            session.setAttribute("admin", resultVo.getData());

                cookie = new Cookie("JSESSIONID", session.getId());

                // 半个钟头
                cookie.setMaxAge(30 * 60);
            } else {
                cookie = new Cookie("JSESSIONID", null);

                // 浏览器关闭时自动销毁
                cookie.setMaxAge(-1);
            }

            // 发送到浏览器
            response.addCookie(cookie);

            mv.setViewName("/index.jsp");
            return mv;
//        } else {
//            // 登录失败的情况
//            mv.addObject("resultInfo", resultVo);
//            mv.setViewName("redirect:/login.jsp");
//        }


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
