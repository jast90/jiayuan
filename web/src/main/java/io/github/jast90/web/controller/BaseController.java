package io.github.jast90.web.controller;

/**
 * Created by jast90 on 2021/3/9
 */
public class BaseController {

    private String prefix = "page";


    protected String getViewName(String viewName){
        return String.format("%s/%s",prefix,viewName);
    }

}
