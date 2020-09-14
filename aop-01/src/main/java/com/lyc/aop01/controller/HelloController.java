package com.lyc.aop01.controller;

import com.lyc.aop01.config.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Hello 控制层
 *
 * @author zc 2017-02-18
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "say", method = RequestMethod.GET)
    @ResponseBody
    public String say() {
        return girlProperties.getCupSize();
    }

    @GetMapping(value = "/say/one")
    @ResponseBody
    public String sayOne(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return "id:" + myId;
    }
}
