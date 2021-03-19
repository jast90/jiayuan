package io.github.jast90.post.controller;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.post.entity.Message;
import io.github.jast90.post.entity.Message;
import io.github.jast90.post.service.MessageService;
import io.github.jast90.web.common.controller.BaseController;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/16
 */
@RestController
@RequestMapping("message")
public class MessageController extends BaseController<MessageService, Message> {

    @PostMapping("page")
    @Override
    public CommonResult<Page<Message>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, Message> requestBody) {
        return super.queryPage(requestBody);
    }

    @GetMapping("{id}")
    @Override
    public CommonResult<Message> queryById(@PathVariable("id") long id) {
        return super.queryById(id);
    }

    @PostMapping("")
    @Override
    public CommonResult<Message> add(@RequestBody Message entity) {
        return super.add(entity);
    }

    @PutMapping("")
    @Override
    public CommonResult<Message> update(@RequestBody Message entity) {
        return super.update(entity);
    }

    @DeleteMapping("{id}")
    @Override
    public CommonResult<Message> delete(@PathVariable("id")long id) {
        return super.delete(id);
    }

    @PostMapping("list")
    @Override
    public CommonResult<List<Message>> queryList() {
        return super.queryList();
    }

    @PostMapping("condition")
    @Override
    public CommonResult<List<Message>> queryListByCondition(@RequestBody Message Message) {
        return super.queryListByCondition(Message);
    }
}
