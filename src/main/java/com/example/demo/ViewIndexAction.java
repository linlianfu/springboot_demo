package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author eleven
 * @date 2018/12/22
 * @description
 */
@Slf4j
@Controller
@RequestMapping("view")
public class ViewIndexAction {


    /**
     * 请求url:http://127.0.0.1:8080/view/getIndex
     * @return
     */
    @ResponseBody
    @RequestMapping("getIndex")
    public ModelAndView getIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("userName","eleven");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("getViewInfo")
    public String getViewInfo(){
        log.info("1111");
        return "111";
    }
}
