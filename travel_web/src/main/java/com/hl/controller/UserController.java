package com.hl.controller;

import com.github.pagehelper.PageInfo;
import com.hl.domain.Role;
import com.hl.domain.UserInfo;
import com.hl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author hl2333
 */
@Controller()
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(Integer[] ids, Integer userId){
        userService.addRole(ids, userId);
        return "redirect:findAll.do";
    }
    @RequestMapping("findUserByIdAndAllRole.do")
    public ModelAndView findRole(String id){
        ModelAndView mv = new ModelAndView("user-role-add");
        mv.addObject("userId", id);
        List<Role> roles = userService.findRoles(id);
        mv.addObject("roleList", roles);
        return mv;
    }
    @RequestMapping("findById.do")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        modelAndView.setViewName("user-show");
        modelAndView.addObject("user", userInfo);
        return modelAndView;
    }
    @RequestMapping("save.do")
    @PreAuthorize("authentication.principal.username == 'admin'")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("findAll.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
