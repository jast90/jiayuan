package io.github.jast90.user.controller;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.user.entity.User;
import io.github.jast90.user.form.LoginForm;
import io.github.jast90.user.form.UserChangePasswordForm;
import io.github.jast90.user.form.UserConditionForm;
import io.github.jast90.user.service.UserService;
import io.github.jast90.web.common.controller.BaseController;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/15
 */
@RestController
public class UserRestController extends BaseController<UserService, User> {
    @PostMapping("/user/page")
    @Override
    public CommonResult<Page<User>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, User> requestBody) {
        return super.queryPage(requestBody);
    }

    @GetMapping("/user/{id}")
    @Override
    public CommonResult<User> queryById(@PathVariable("id") long id) {
        return super.queryById(id);
    }

    @PostMapping("user")
    @Override
    public CommonResult<User> add(@RequestBody User entity) {
        return super.add(entity);
    }

    @PutMapping("user")
    @Override
    public CommonResult<User> update(@RequestBody User entity) {
        return super.update(entity);
    }

    @DeleteMapping("user/{id}")
    @Override
    public CommonResult<User> delete(@PathVariable("id")long id) {
        return super.delete(id);
    }

    @PostMapping("user/list")
    @Override
    public CommonResult<List<User>> queryList() {
        return super.queryList();
    }

    @PostMapping("user/list/condition")
    public CommonResult<List<User>> queryListByCondition(@RequestBody UserConditionForm form) {
        return super.queryListByCondition(form);
    }

    @PostMapping("user/login")
    public CommonResult<User> login(@RequestBody LoginForm loginForm){
        return service.login(loginForm.getLoginName(),loginForm.getPassword());
    }

    @PutMapping("user/change/password")
    public CommonResult<User> changePassword(@RequestBody UserChangePasswordForm userChangePasswordForm){
        return service.changePassword(userChangePasswordForm);
    }
}
