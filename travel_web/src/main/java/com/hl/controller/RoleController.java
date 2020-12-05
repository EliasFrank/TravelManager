package com.hl.controller;

import com.hl.domain.Role;
import com.hl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hl2333
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "0")Integer page,
                                @RequestParam(defaultValue = "5")Integer size){
        ModelAndView modelAndView = new ModelAndView("role-list");
        modelAndView.addObject("pageInfo", roleService.findAll(page, size));
        return modelAndView;
    }
    @RequestMapping("save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";
    }
}
