package io.github.jast90.web.controller.rest;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.user.entity.User;
import io.github.jast90.user.form.LoginForm;
import io.github.jast90.user.form.UserChangePasswordForm;
import io.github.jast90.web.client.user.UserClient;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/16
 */
@RestController
public class UserRestController{
    @Autowired
    private UserClient userClient;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${user.default.password}")
    private String defaultPassword;

    @PostMapping("user/login")
    public CommonResult<User> login(@RequestBody LoginForm loginForm) {
        return userClient.login(loginForm);
    }

    @PutMapping("user/change/password")
    public CommonResult<User> changePassword(@RequestBody UserChangePasswordForm userChangePasswordForm) {
        return userClient.changePassword(userChangePasswordForm);
    }

    @PostMapping("/user/page")
    public CommonResult<Page<User>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, User> requestBody) {
        return userClient.queryPage(requestBody);
    }

    @GetMapping("/user/{id}")
    public CommonResult<User> queryById(@PathVariable("id") long id) {
        return userClient.queryById(id);
    }

    @PostMapping("user")
    public CommonResult<User> add(@RequestBody User entity) {
        if(entity.getPassword()==null){
            entity.setPassword(defaultPassword);
        }
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return userClient.add(entity);
    }

    @PutMapping("user")
    public CommonResult<User> update(@RequestBody User entity) {
        return userClient.update(entity);
    }

    @DeleteMapping("user/{id}")
    public CommonResult<User> delete(@PathVariable("id") long id) {
        return userClient.delete(id);
    }

    @PostMapping("user/list")
    public CommonResult<List<User>> queryList() {
        return userClient.queryList();
    }

    @PostMapping("user/condition")
    public CommonResult<List<User>> queryListByCondition(@RequestBody User user) {
        return userClient.queryListByCondition(user);
    }
}
