package io.github.jast90.fee.controller;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.fee.entity.HouseFee;
import io.github.jast90.fee.service.HouseFeeService;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.web.common.controller.BaseController;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/15
 */
@RestController
public class HouseFeeController extends BaseController<HouseFeeService, HouseFee> {

    @PostMapping("/house/fee/page")
    @Override
    public CommonResult<Page<HouseFee>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, HouseFee> requestBody) {
        return super.queryPage(requestBody);
    }

    @GetMapping("/house/fee/{id}")
    @Override
    public CommonResult<HouseFee> queryById(@PathVariable("id") long id) {
        return super.queryById(id);
    }

    @PostMapping("/house/fee")
    @Override
    public CommonResult<HouseFee> add(@RequestBody HouseFee entity) {
        return super.add(entity);
    }

    @PutMapping("/house/fee")
    @Override
    public CommonResult<HouseFee> update(@RequestBody HouseFee entity) {
        return super.update(entity);
    }

    @DeleteMapping("/house/fee/{id}")
    @Override
    public CommonResult<HouseFee> delete(@PathVariable("id")long id) {
        return super.delete(id);
    }

    @PostMapping("/house/fee/list")
    @Override
    public CommonResult<List<HouseFee>> queryList() {
        return super.queryList();
    }

    @PostMapping("/house/fee/list/condition")
    @Override
    public CommonResult<List<HouseFee>> queryListByCondition(@RequestBody HouseFee houseFee) {
        return super.queryListByCondition(houseFee);
    }
}
