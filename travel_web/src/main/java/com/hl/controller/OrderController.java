package com.hl.controller;

import com.hl.domain.Order;
import com.hl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ModelAndView findAll(){
        List<Order> all = orderService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders", all);
        mv.setViewName("orders-list");
        return mv;
    }
}
