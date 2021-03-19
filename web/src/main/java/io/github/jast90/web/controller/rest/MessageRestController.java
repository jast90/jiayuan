package io.github.jast90.web.controller.rest;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.post.entity.Message;
import io.github.jast90.web.client.post.MessageClient;
import io.github.jast90.web.common.result.CommonResult;
import io.github.jast90.web.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.Session;
import java.util.List;

/**
 * Created by jast90 on 2021/3/16
 */
@RestController
public class MessageRestController implements MessageClient {
    @Autowired
    private MessageClient messageClient;
    @Autowired
    private SessionUtil sessionUtil;

    @PostMapping("message/page")
    @Override
    public CommonResult<Page<Message>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, Message> requestBody) {
        return messageClient.queryPage(requestBody);
    }

    @GetMapping("message/{id}")
    @Override
    public CommonResult<Message> queryById(@PathVariable("id")long id) {
        return messageClient.queryById(id);
    }

    @PostMapping("message")
    @Override
    public CommonResult<Message> add(@RequestBody Message entity) {
        entity.setCreateUserId(sessionUtil.getUid());
        return messageClient.add(entity);
    }

    @PutMapping("message")
    @Override
    public CommonResult<Message> update(@RequestBody Message entity) {
        return messageClient.update(entity);
    }

    @DeleteMapping("message/{id}")
    @Override
    public CommonResult<Message> delete(@PathVariable("id") long id) {
        return messageClient.delete(id);
    }

    @PostMapping("message/list")
    @Override
    public CommonResult<List<Message>> queryList() {
        return messageClient.queryList();
    }

    @PostMapping("message/condition")
    @Override
    public CommonResult<List<Message>> queryListByCondition(@RequestBody Message message) {
        return messageClient.queryListByCondition(message);
    }
}
