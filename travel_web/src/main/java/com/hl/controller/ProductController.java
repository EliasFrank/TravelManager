package com.hl.controller;

import com.hl.domain.Product;
import com.hl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author hl2333
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("findAll.do")
//    @ResponseBody
    public ModelAndView findAll(Integer page, Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", productService.findAll(page, size));
        mv.setViewName("product-list");
        return mv;
    }
    /*查询所有订单，不分页
    @GetMapping("findAll.do")
    @ResponseBody
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("productList", productService.findAll());
        mv.setViewName("product-list");
        return mv;
    }*/

    @PostMapping("save.do")
    public String addProduct(Product product){
        productService.save(product);
        return "redirect:findAll.do";
    }
}
