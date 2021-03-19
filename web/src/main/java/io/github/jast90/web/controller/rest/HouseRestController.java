package io.github.jast90.web.controller.rest;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.resource.entity.House;
import io.github.jast90.web.client.resource.HouseClient;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/16
 */
@RestController
public class HouseRestController implements HouseClient {
    @Autowired
    private HouseClient houseClient;

    @PostMapping("house/page")
    @Override
    public CommonResult<Page<House>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, House> requestBody) {
        return houseClient.queryPage(requestBody);
    }

    @GetMapping("house/{id}")
    @Override
    public CommonResult<House> queryById(@PathVariable("id") long id) {
        return houseClient.queryById(id);
    }

    @PostMapping("house")
    @Override
    public CommonResult<House> add(@RequestBody House entity) {
        return houseClient.add(entity);
    }

    @PutMapping("house")
    @Override
    public CommonResult<House> update(@RequestBody House entity) {
        return houseClient.update(entity);
    }

    @DeleteMapping("house/{id}")
    @Override
    public CommonResult<House> delete(@PathVariable("id") long id) {
        return houseClient.delete(id);
    }

    @PostMapping("house/list")
    @Override
    public CommonResult<List<House>> queryList() {
        return houseClient.queryList();
    }

    @PostMapping("house/condition")
    @Override
    public CommonResult<List<House>> queryListByCondition(@RequestBody House house) {
        return houseClient.queryListByCondition(house);
    }
}
