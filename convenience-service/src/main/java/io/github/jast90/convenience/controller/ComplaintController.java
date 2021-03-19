package io.github.jast90.convenience.controller;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.convenience.entity.Complaint;
import io.github.jast90.convenience.service.ComplaintService;
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
@RequestMapping("/complaint")
public class ComplaintController extends BaseController<ComplaintService, Complaint> {

    @PostMapping("page")
    @Override
    public CommonResult<Page<Complaint>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, Complaint> requestBody) {
        return super.queryPage(requestBody);
    }

    @GetMapping("{id}")
    @Override
    public CommonResult<Complaint> queryById(@PathVariable("id") long id) {
        return super.queryById(id);
    }

    @PostMapping("")
    @Override
    public CommonResult<Complaint> add(@RequestBody Complaint entity) {
        return super.add(entity);
    }

    @PutMapping("")
    @Override
    public CommonResult<Complaint> update(@RequestBody Complaint entity) {
        return super.update(entity);
    }

    @DeleteMapping("{id}")
    @Override
    public CommonResult<Complaint> delete(@PathVariable("id")long id) {
        return super.delete(id);
    }

    @PostMapping("list")
    @Override
    public CommonResult<List<Complaint>> queryList() {
        return super.queryList();
    }

    @PostMapping("condition")
    @Override
    public CommonResult<List<Complaint>> queryListByCondition(@RequestBody Complaint Complaint) {
        return super.queryListByCondition(Complaint);
    }
}
