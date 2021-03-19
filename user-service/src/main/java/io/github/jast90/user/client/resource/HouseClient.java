package io.github.jast90.user.client.resource;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.resource.entity.House;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/16
 */
@FeignClient("resource")
public interface HouseClient {

    @PostMapping("house/page")
    CommonResult<Page<House>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, House> requestBody);

    @GetMapping("house/{id}")
    CommonResult<House> queryById(@PathVariable("id") long id);

    @PostMapping("house")
    CommonResult<House> add(@RequestBody House entity);

    @PutMapping("house")
    CommonResult<House> update(@RequestBody House entity);

    @DeleteMapping("house/{id}")
    CommonResult<House> delete(@PathVariable("id")long id);

    @PostMapping("house/list")
    CommonResult<List<House>> queryList();

    @PostMapping("house/condition")
    CommonResult<List<House>> queryListByCondition(@RequestBody House house);

    @PutMapping("house/{id}")
    CommonResult updateStatusToJoined(@PathVariable("id") Long id);
}
