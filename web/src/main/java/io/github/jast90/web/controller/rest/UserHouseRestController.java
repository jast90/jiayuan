package io.github.jast90.web.controller.rest;

import com.google.common.collect.Lists;
import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.resource.entity.House;
import io.github.jast90.resource.form.HouseConditionForm;
import io.github.jast90.user.entity.UserHouse;
import io.github.jast90.web.client.resource.HouseClient;
import io.github.jast90.web.client.user.UserHouseClient;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jast90 on 2021/3/16
 */
@RestController
public class UserHouseRestController implements UserHouseClient {

    @Autowired
    private UserHouseClient userHouseClient;

    @Autowired
    private HouseClient houseClient;

    @PostMapping("/user/house/page")
    @Override
    public CommonResult<Page<UserHouse>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, UserHouse> requestBody) {
        CommonResult<Page<UserHouse>> pageCommonResult = userHouseClient.queryPage(requestBody);
        return pageCommonResult;
    }

    @GetMapping("/user/house/{id}")
    @Override
    public CommonResult<UserHouse> queryById(@PathVariable("id") long id) {
        return userHouseClient.queryById(id);
    }

    @PostMapping("user/house")
    @Override
    public CommonResult<UserHouse> add(@RequestBody UserHouse entity) {
        return userHouseClient.add(entity);
    }

    @PutMapping("user/house")
    @Override
    public CommonResult<UserHouse> update(@RequestBody UserHouse entity) {
        return userHouseClient.update(entity);
    }

    @DeleteMapping("user/house/{id}")
    @Override
    public CommonResult<UserHouse> delete(@PathVariable("id")long id) {
        return userHouseClient.delete(id);
    }

    @PostMapping("user/house/list")
    @Override
    public CommonResult<List<UserHouse>> queryList() {
        return userHouseClient.queryList();
    }

    @PostMapping("user/house/list/condition")
    @Override
    public CommonResult<List<UserHouse>> queryListByCondition(@RequestBody UserHouse userHouse) {
        return userHouseClient.queryListByCondition(userHouse);
    }
}
