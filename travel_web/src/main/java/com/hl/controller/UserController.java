package com.hl.controller;

import com.github.pagehelper.PageInfo;
import com.hl.domain.UserInfo;
import com.hl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hl2333
 */
@Controller()
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("findById.do")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        modelAndView.setViewName("user-show");
        modelAndView.addObject("user", userInfo);
        return modelAndView;
    }
    @RequestMapping("save.do")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("findAll.do")
    public ModelAndView findAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "4") Integer size){
        ModelAndView mv = new ModelAndView();
        PageInfo all = userService.findAll(page, size);
        mv.addObject("pageInfo", all);

        mv.setViewName("user-list");
        return mv;
    }
}
