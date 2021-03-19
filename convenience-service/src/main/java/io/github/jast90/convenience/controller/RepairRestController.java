package io.github.jast90.convenience.controller;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.convenience.entity.Repair;
import io.github.jast90.convenience.service.RepairService;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.web.common.controller.BaseController;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/16
 */
@RestController
@RequestMapping("/repair")
public class RepairRestController extends BaseController<RepairService, Repair> {

    @PostMapping("page")
    @Override
    public CommonResult<Page<Repair>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, Repair> requestBody) {
        return super.queryPage(requestBody);
    }

    @GetMapping("{id}")
    @Override
    public CommonResult<Repair> queryById(@PathVariable("id") long id) {
        return super.queryById(id);
    }

    @PostMapping("")
    @Override
    public CommonResult<Repair> add(@RequestBody Repair entity) {
        return super.add(entity);
    }

    @PutMapping("")
    @Override
    public CommonResult<Repair> update(@RequestBody Repair entity) {
        return super.update(entity);
    }

    @DeleteMapping("{id}")
    @Override
    public CommonResult<Repair> delete(@PathVariable("id")long id) {
        return super.delete(id);
    }

    @PostMapping("list")
    @Override
    public CommonResult<List<Repair>> queryList() {
        return super.queryList();
    }

    @PostMapping("condition")
    @Override
    public CommonResult<List<Repair>> queryListByCondition(@RequestBody Repair Repair) {
        return super.queryListByCondition(Repair);
    }
}
