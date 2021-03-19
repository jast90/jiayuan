package io.github.jast90.web.client.user;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.user.entity.UserHouse;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/15
 */
@FeignClient("user")
public interface UserHouseClient {
    @PostMapping("/user/house/page")
    CommonResult<Page<UserHouse>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, UserHouse> requestBody) ;

    @GetMapping("/user/house/{id}")
    CommonResult<UserHouse> queryById(@PathVariable("id") long id);

    @PostMapping("user/house")
    CommonResult<UserHouse> add(@RequestBody UserHouse entity);

    @PutMapping("user/house")
    CommonResult<UserHouse> update(@RequestBody UserHouse entity);

    @DeleteMapping("user/house/{id}")
    CommonResult<UserHouse> delete(@PathVariable("id") long id);

    @PostMapping("user/house/list")
    CommonResult<List<UserHouse>> queryList();

    @PostMapping("user/house/list/condition")
    CommonResult<List<UserHouse>> queryListByCondition(@RequestBody UserHouse userHouse) ;
}
