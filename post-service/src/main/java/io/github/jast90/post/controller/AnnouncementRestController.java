package io.github.jast90.post.controller;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.post.entity.Announcement;
import io.github.jast90.post.service.AnnouncementService;
import io.github.jast90.web.common.controller.BaseController;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/16
 */
@RestController
@RequestMapping("announcement")
public class AnnouncementRestController extends BaseController<AnnouncementService, Announcement> {
    @PostMapping("page")
    @Override
    public CommonResult<Page<Announcement>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, Announcement> requestBody) {
        return super.queryPage(requestBody);
    }

    @GetMapping("{id}")
    @Override
    public CommonResult<Announcement> queryById(@PathVariable("id") long id) {
        return super.queryById(id);
    }

    @PostMapping("")
    @Override
    public CommonResult<Announcement> add(@RequestBody Announcement entity) {
        return super.add(entity);
    }

    @PutMapping("")
    @Override
    public CommonResult<Announcement> update(@RequestBody Announcement entity) {
        return super.update(entity);
    }

    @DeleteMapping("{id}")
    @Override
    public CommonResult<Announcement> delete(@PathVariable("id")long id) {
        return super.delete(id);
    }

    @PostMapping("list")
    @Override
    public CommonResult<List<Announcement>> queryList() {
        return super.queryList();
    }

    @PostMapping("condition")
    @Override
    public CommonResult<List<Announcement>> queryListByCondition(@RequestBody Announcement Announcement) {
        return super.queryListByCondition(Announcement);
    }
}
