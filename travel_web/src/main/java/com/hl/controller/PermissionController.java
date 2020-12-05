package com.hl.controller;

import com.hl.domain.Permission;
import com.hl.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hl2333
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @RequestMapping("deletePermission.do")
    public String deleteById(String id){
        permissionService.deleteById(id);
        return "redirect:findAll.do";
    }
    @RequestMapping("findById.do")
    public ModelAndView findById(String id){
        Permission permission = permissionService.findById(id);
        ModelAndView mv = new ModelAndView("permission-show");
        mv.addObject("permission", permission);
        return mv;
    }
    @RequestMapping("save.do")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "0")Integer page,
                                @RequestParam(defaultValue = "4")Integer size){
        ModelAndView mv = new ModelAndView("permission-list");
        mv.addObject("pageInfo",
                permissionService.findAll(page, size));
        return mv;
    }
}
