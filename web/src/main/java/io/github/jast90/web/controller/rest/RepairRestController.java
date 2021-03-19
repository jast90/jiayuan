package io.github.jast90.web.controller.rest;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.convenience.entity.Repair;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.web.client.convenience.RepairClient;
import io.github.jast90.web.common.result.CommonResult;
import io.github.jast90.web.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/16
 */
@RestController
public class RepairRestController implements RepairClient {

    @Autowired
    private RepairClient repairClient;

    @Autowired
    private SessionUtil sessionUtil;

    @PostMapping("/repair/page")
    @Override
    public CommonResult<Page<Repair>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, Repair> requestBody) {
        if(sessionUtil.user()){
            requestBody.getDomain().setHouseId(sessionUtil.getUserHouseId());
        }
        return repairClient.queryPage((requestBody));
    }

    @GetMapping("/repair/{id}")
    @Override
    public CommonResult<Repair> queryById(long id) {
        return repairClient.queryById(id);
    }

    @PostMapping("/repair")
    @Override
    public CommonResult<Repair> add(@RequestBody Repair entity) {
        entity.setCreateUserId(sessionUtil.getUid());
        return repairClient.add(entity);
    }

    @PutMapping("/repair")
    @Override
    public CommonResult<Repair> update(@RequestBody Repair entity) {
        return repairClient.update(entity);
    }

    @DeleteMapping("/repair/{id}")
    @Override
    public CommonResult<Repair> delete(long id) {
        return repairClient.delete(id);
    }

    @PostMapping("/repair/list")
    @Override
    public CommonResult<List<Repair>> queryList() {
        return repairClient.queryList();
    }

    @PostMapping("/repair/condition")
    @Override
    public CommonResult<List<Repair>> queryListByCondition(@RequestBody Repair repair) {
        return repairClient.queryListByCondition(repair);
    }
}
