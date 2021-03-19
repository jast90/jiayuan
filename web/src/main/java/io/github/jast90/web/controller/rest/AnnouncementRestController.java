package io.github.jast90.web.controller.rest;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.post.entity.Announcement;
import io.github.jast90.web.client.post.AnnouncementClient;
import io.github.jast90.web.common.result.CommonResult;
import io.github.jast90.web.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/16
 */
@RestController
public class AnnouncementRestController implements AnnouncementClient {

    @Autowired
    private AnnouncementClient announcementClient;

    @Autowired
    private SessionUtil sessionUtil;

    @PostMapping("announcement/page")
    @Override
    public CommonResult<Page<Announcement>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, Announcement> requestBody) {
        return announcementClient.queryPage(requestBody);
    }

    @GetMapping("announcement/{id}")
    @Override
    public CommonResult<Announcement> queryById(@PathVariable("id") long id) {
        return announcementClient.queryById(id);
    }

    @PostMapping("announcement")
    @Override
    public CommonResult<Announcement> add(@RequestBody Announcement entity) {
        entity.setCreateUserId(sessionUtil.getUid());
        return announcementClient.add(entity);
    }

    @PutMapping("announcement")
    @Override
    public CommonResult<Announcement> update(@RequestBody Announcement entity) {
        return announcementClient.update(entity);
    }

    @DeleteMapping("announcement/{id}")
    @Override
    public CommonResult<Announcement> delete(@PathVariable("id") long id) {
        return announcementClient.delete(id);
    }

    @PostMapping("announcement/list")
    @Override
    public CommonResult<List<Announcement>> queryList() {
        return announcementClient.queryList();
    }

    @PostMapping("announcement/condition")
    @Override
    public CommonResult<List<Announcement>> queryListByCondition(@RequestBody Announcement announcement) {
        return announcementClient.queryListByCondition(announcement);
    }
}
