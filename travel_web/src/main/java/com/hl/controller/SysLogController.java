package com.hl.controller;

import com.github.pagehelper.PageInfo;
import com.hl.domain.SysLog;
import com.hl.service.SysLogService;
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
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    SysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "4")Integer size){
        PageInfo<SysLog> sysLogs = sysLogService.findAll(page, size);
        ModelAndView mv = new ModelAndView("syslog-list");
        mv.addObject("pageInfo", sysLogs);
        return mv;
    }
}
