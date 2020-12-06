package com.hl.controller;

import com.github.pagehelper.PageInfo;
import com.hl.domain.Order;
import com.hl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author hl2333
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(Integer page, Integer size){
        PageInfo<Order> pageInfo = orderService.findAll(page, size);
        ModelAndView mv=new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("order-list");return mv;
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(Integer id){
        Order order = orderService.findById(id);
        ModelAndView mv = new ModelAndView("order-show");
        mv.addObject("order", order);
        return mv;
    }
    /*未分页
     @GetMapping("findAll.do")
    public ModelAndView findAll(){
        List<Order> all = orderService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders", all);
        mv.setViewName("order-list");
        return mv;
    }
    */
}
