package io.github.jast90.user.controller;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.user.entity.UserHouse;
import io.github.jast90.user.service.UserHouseService;
import io.github.jast90.web.common.controller.BaseController;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/15
 */
@RestController
public class UserHouseRestController extends BaseController<UserHouseService,UserHouse> {
    @PostMapping("/user/house/page")
    @Override
    public CommonResult<Page<UserHouse>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, UserHouse> requestBody) {
        return super.queryPage(requestBody);
    }

    @GetMapping("/user/house/{id}")
    @Override
    public CommonResult<UserHouse> queryById(@PathVariable("id") long id) {
        return super.queryById(id);
    }

    @PostMapping("user/house")
    @Override
    public CommonResult<UserHouse> add(@RequestBody UserHouse entity) {
        return super.add(entity);
    }

    @PutMapping("user/house")
    @Override
    public CommonResult<UserHouse> update(@RequestBody UserHouse entity) {
        return super.update(entity);
    }

    @DeleteMapping("user/house/{id}")
    @Override
    public CommonResult<UserHouse> delete(@PathVariable("id") long id) {
        return super.delete(id);
    }

    @PostMapping("user/house/list")
    @Override
    public CommonResult<List<UserHouse>> queryList() {
        return super.queryList();
    }

    @PostMapping("user/house/list/condition")
    @Override
    public CommonResult<List<UserHouse>> queryListByCondition(@RequestBody UserHouse userHouse) {
        return super.queryListByCondition(userHouse);
    }
}
