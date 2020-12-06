package com.hl.controller;

import com.hl.domain.Permission;
import com.hl.domain.Role;
import com.hl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author hl2333
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("addPermissionToRole.do")
    public String addPermission(String[] ids, String roleId){
        roleService.addPermission(ids, roleId);
        return "redirect:findAll.do";
    }
    @RequestMapping("findRoleByIdAndAllPermission.do")
    public ModelAndView findPermission(String id){
        List<Permission> permissions = roleService.findPermissions(id);
        ModelAndView mv = new ModelAndView("role-permission-add");
        mv.addObject("permissionList", permissions);
        mv.addObject("roleId", id);
        return mv;
    }
    @RequestMapping("deleteRole.do")
    public String delete(String id){
        roleService.deleteRole(id);
        return "redirect:findAll.do";
    }
    @RequestMapping("findById.do")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView("role-show");
        Role role = roleService.findById(id);
        mv.addObject("role", role);
        return mv;
    }
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
