package io.github.jast90.web.client.convenience;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.convenience.entity.Repair;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/16
 */
@FeignClient("convenience")
public interface RepairClient {

    @PostMapping("/repair/page")
    CommonResult<Page<Repair>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, Repair> requestBody);

    @GetMapping("/repair/{id}")
    CommonResult<Repair> queryById(@PathVariable("id") long id);

    @PostMapping("/repair")
    CommonResult<Repair> add(@RequestBody Repair entity) ;

    @PutMapping("/repair")
    CommonResult<Repair> update(@RequestBody Repair entity);

    @DeleteMapping("/repair/{id}")
    CommonResult<Repair> delete(@PathVariable("id")long id);

    @PostMapping("/repair/list")
    CommonResult<List<Repair>> queryList() ;

    @PostMapping("/repair/condition")
    CommonResult<List<Repair>> queryListByCondition(@RequestBody Repair Repair) ;
}
