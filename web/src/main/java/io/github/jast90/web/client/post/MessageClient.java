package io.github.jast90.web.client.post;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.post.entity.Message;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/16
 */
@FeignClient("post")
public interface MessageClient {

    @PostMapping("message/page")
    CommonResult<Page<Message>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, Message> requestBody);

    @GetMapping("message/{id}")
    CommonResult<Message> queryById(@PathVariable("id") long id);

    @PostMapping("message")
    CommonResult<Message> add(@RequestBody Message entity);

    @PutMapping("message")
    CommonResult<Message> update(@RequestBody Message entity);

    @DeleteMapping("message/{id}")
    CommonResult<Message> delete(@PathVariable("id")long id);

    @PostMapping("message/list")
    CommonResult<List<Message>> queryList();

    @PostMapping("message/condition")
    CommonResult<List<Message>> queryListByCondition(@RequestBody Message Message);
}
