package io.github.jast90.web.controller.rest;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.convenience.entity.Complaint;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.web.client.convenience.ComplaintClient;
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
public class ComplaintRestController implements ComplaintClient {
    @Autowired
    private ComplaintClient complaintClient;
    @Autowired
    private SessionUtil sessionUtil;

    @PostMapping("/complaint/page")
    @Override
    public CommonResult<Page<Complaint>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, Complaint> requestBody) {
        if(sessionUtil.user()){
            requestBody.getDomain().setCreateUserId(sessionUtil.getUid());
        }
        return complaintClient.queryPage(requestBody);
    }

    @GetMapping("/complaint/{id}")
    @Override
    public CommonResult<Complaint> queryById(@PathVariable("id") long id) {
        return complaintClient.queryById(id);
    }

    @PostMapping("/complaint")
    @Override
    public CommonResult<Complaint> add(@RequestBody Complaint entity) {
        entity.setCreateUserId(sessionUtil.getUid());
        return complaintClient.add(entity);
    }

    @PutMapping("/complaint")
    @Override
    public CommonResult<Complaint> update(@RequestBody Complaint entity) {
        return complaintClient.update(entity);
    }

    @DeleteMapping("/complaint/{id}")
    @Override
    public CommonResult<Complaint> delete(@PathVariable("id") long id) {
        return complaintClient.delete(id);
    }

    @PostMapping("/complaint/list")
    @Override
    public CommonResult<List<Complaint>> queryList() {
        return complaintClient.queryList();
    }

    @PostMapping("/complaint/condition")
    @Override
    public CommonResult<List<Complaint>> queryListByCondition(@RequestBody Complaint complaint) {
        return complaintClient.queryListByCondition(complaint);
    }
}
