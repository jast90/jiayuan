package io.github.jast90.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by jast90 on 2021/3/9
 */
@Controller
public class PagesController extends BaseController{

    @GetMapping(value = "user/list")
    public String user(){
        return getViewName("user");
    }

    @GetMapping(value = "user/house/list")
    public String userHouse(){
        return getViewName("userHouse");
    }

    @GetMapping(value = "house/list")
    public String house(){
        return getViewName("house");
    }

    @GetMapping(value = "house/fee/list")
    public String houseFee(){
        return getViewName("houseFee");
    }

    @GetMapping(value = "repair/list")
    public String repair(){
        return getViewName("repair");
    }

    @GetMapping(value = "complaint/list")
    public String complaint(){
        return getViewName("complaint");
    }

    @GetMapping(value = "announcement/list")
    public String announcement(){
        return getViewName("announcement");
    }

    @GetMapping(value = "message/list")
    public String message(){
        return getViewName("message");
    }
}
