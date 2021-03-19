package io.github.jast90.resource.controller;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.resource.entity.House;
import io.github.jast90.resource.form.HouseConditionForm;
import io.github.jast90.resource.service.HouseService;
import io.github.jast90.web.common.controller.BaseController;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/16
 */
@RestController
@RequestMapping("house")
public class HouseRestController extends BaseController<HouseService, House> {

    @PostMapping("page")
    @Override
    public CommonResult<Page<House>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, House> requestBody) {
        return super.queryPage(requestBody);
    }

    @GetMapping("{id}")
    @Override
    public CommonResult<House> queryById(@PathVariable("id") long id) {
        return super.queryById(id);
    }

    @PostMapping("")
    @Override
    public CommonResult<House> add(@RequestBody House entity) {
        return super.add(entity);
    }

    @PutMapping("")
    @Override
    public CommonResult<House> update(@RequestBody House entity) {
        return super.update(entity);
    }

    @DeleteMapping("{id}")
    @Override
    public CommonResult<House> delete(@PathVariable("id")long id) {
        return super.delete(id);
    }

    @PostMapping("list")
    @Override
    public CommonResult<List<House>> queryList() {
        return super.queryList();
    }

    @PostMapping("condition")
    public CommonResult<List<House>> queryListByCondition(@RequestBody HouseConditionForm form) {
        return super.queryListByCondition(form);
    }

    @PutMapping("{id}")
    public CommonResult updateStatusToJoined(@PathVariable("id") Long id){
        return service.updateStatusToJoined(id);
    }
}
