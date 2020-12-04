package com.hl.controller;

import com.github.pagehelper.PageInfo;
import com.hl.domain.UserInfo;
import com.hl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hl2333
 */
@Controller()
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(Integer page, Integer size){
        ModelAndView mv = new ModelAndView();
        PageInfo all = userService.findAll(page, size);
        mv.addObject("pageInfo", all);

        mv.setViewName("user-list");
        return mv;
    }
}
