package io.github.jast90.convenience.client.user;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.user.entity.User;
import io.github.jast90.user.form.LoginForm;
import io.github.jast90.user.form.UserChangePasswordForm;
import io.github.jast90.user.form.UserConditionForm;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by jast90 on 2021/3/16
 */
@FeignClient("user")
public interface UserClient {
    @PostMapping(value = "user/login",consumes = APPLICATION_JSON_VALUE)
    CommonResult<User> login(@RequestBody LoginForm loginForm);

    @PutMapping(value = "user/change/password",consumes = APPLICATION_JSON_VALUE)
    CommonResult<User> changePassword(@RequestBody UserChangePasswordForm userChangePasswordForm);

    @PostMapping(value = "/user/page",consumes = APPLICATION_JSON_VALUE)
    CommonResult<Page<User>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, User> requestBody) ;

    @GetMapping(value = "/user/{id}",consumes = APPLICATION_JSON_VALUE)
    CommonResult<User> queryById(@PathVariable("id") long id);

    @PostMapping(value = "user",consumes = APPLICATION_JSON_VALUE)
    CommonResult<User> add(@RequestBody User entity);

    @PutMapping(value = "user",consumes = APPLICATION_JSON_VALUE)
    CommonResult<User> update(@RequestBody User entity);

    @DeleteMapping(value = "user/{id}",consumes = APPLICATION_JSON_VALUE)
    CommonResult<User> delete(@PathVariable("id")long id);

    @PostMapping(value = "user/list",consumes = APPLICATION_JSON_VALUE)
    CommonResult<List<User>> queryList();

    @PostMapping(value = "user/list/condition",consumes = APPLICATION_JSON_VALUE)
    CommonResult<List<User>> queryListByCondition(@RequestBody UserConditionForm form);
}
