package io.github.jast90.web.client.fee;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.fee.entity.HouseFee;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/15
 */
@FeignClient("fee")
public interface HouseFeeClient {

    @PostMapping("/house/fee/page")
    CommonResult<Page<HouseFee>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, HouseFee> requestBody);

    @GetMapping("/house/fee/{id}")
    CommonResult<HouseFee> queryById(@PathVariable("id") long id) ;

    @PostMapping("/house/fee")
    CommonResult<HouseFee> add(@RequestBody HouseFee entity) ;

    @PutMapping("/house/fee")
    CommonResult<HouseFee> update(@RequestBody HouseFee entity) ;

    @DeleteMapping("/house/fee/{id}")
    CommonResult<HouseFee> delete(@PathVariable("id")long id) ;

    @PostMapping("/house/fee/list")
    CommonResult<List<HouseFee>> queryList();

    @PostMapping("/house/fee/list/condition")
    CommonResult<List<HouseFee>> queryListByCondition(@RequestBody HouseFee houseFee);
}
