package io.github.jast90.web.controller;

import com.google.common.collect.Lists;
import io.github.jast90.user.entity.User;
import io.github.jast90.user.form.LoginForm;
import io.github.jast90.user.form.UserChangePasswordForm;
import io.github.jast90.web.common.result.CommonResult;
import io.github.jast90.web.common.result.MyResult;
import io.github.jast90.web.service.UserService;
import io.github.jast90.web.vo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jast90 on 2021/3/8
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @GetMapping("/login")
    public String login(){
        return "page/login";
    }

    @GetMapping("/")
    public String index(){
        return "page/index";
    }

    @ResponseBody
    @PostMapping("login")
    public CommonResult<User> login(@RequestBody LoginForm loginForm){
        CommonResult<User> result = userService.login(loginForm);
        if(result.getCode()==MyResult.SUCCESS.getCode()){
            User user = result.getData();
            session.setAttribute("s_sysUser",user);
            switch (user.getUserType()){
                case 1:{
                    session.setAttribute("menuList",adminMenu());
                    break;
                }
                default:
                    session.setAttribute("menuList",ownerMenu());
            }
        }
        return result;
    }

    @GetMapping("logout")
    public String logout(){
        session.removeAttribute("s_sysUser");
        session.removeAttribute("menuList");
        return "redirect:/";
    }


    private List<Menu> adminMenu(){
        List<Menu> list = Lists.newArrayList();
        list.add(new Menu(1L,null,"fa-users","/user/list","用户"));
        list.add(new Menu(3L,null,"fa-users","/user/house/list","业主"));
        list.add(new Menu(2L,null,"fa-calendar", "/house/list","房屋"));
        list.add(new Menu(5L,null,"fa-bullhorn","/house/fee/list","费用"));
        list.add(new Menu(5L,null,"fa-bullhorn","/repair/list","报修"));
        list.add(new Menu(5L,null,"fa-bullhorn","/complaint/list","投诉"));
        list.add(new Menu(5L,null,"fa-bullhorn","/announcement/list","公告"));
        list.add(new Menu(5L,null,"fa-bullhorn","/message/list","留言"));
        return list;
    }

    private List<Menu> ownerMenu(){
        List<Menu> list = Lists.newArrayList();
        list.add(new Menu(5L,null,"fa-bullhorn","/house/fee/list","费用"));
        list.add(new Menu(5L,null,"fa-bullhorn","/repair/list","报修"));
        list.add(new Menu(5L,null,"fa-bullhorn","/complaint/list","投诉"));
        list.add(new Menu(5L,null,"fa-bullhorn","/announcement/list","公告"));
        list.add(new Menu(5L,null,"fa-bullhorn","/message/list","留言"));
        return list;
    }
}
