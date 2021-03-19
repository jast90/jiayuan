package io.github.jast90.web.client.convenience;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.convenience.entity.Complaint;
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
public interface ComplaintClient {

    @PostMapping("/complaint/page")
    CommonResult<Page<Complaint>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, Complaint> requestBody);

    @GetMapping("/complaint/{id}")
    CommonResult<Complaint> queryById(@PathVariable("id") long id);

    @PostMapping("/complaint")
    CommonResult<Complaint> add(@RequestBody Complaint entity);

    @PutMapping("/complaint")
    CommonResult<Complaint> update(@RequestBody Complaint entity);

    @DeleteMapping("/complaint/{id}")
    CommonResult<Complaint> delete(@PathVariable("id")long id);

    @PostMapping("/complaint/list")
    CommonResult<List<Complaint>> queryList();

    @PostMapping("/complaint/condition")
    CommonResult<List<Complaint>> queryListByCondition(@RequestBody Complaint complaint);
}
