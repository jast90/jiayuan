package io.github.jast90.web.client.post;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.post.entity.Announcement;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by jast90 on 2021/3/16
 */
@FeignClient("post")
public interface AnnouncementClient{
    @PostMapping("announcement/page")
    CommonResult<Page<Announcement>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, Announcement> requestBody) ;

    @GetMapping("announcement/{id}")
    CommonResult<Announcement> queryById(@PathVariable("id") long id);

    @PostMapping("announcement")
    CommonResult<Announcement> add(@RequestBody Announcement entity);

    @PutMapping("announcement")
    CommonResult<Announcement> update(@RequestBody Announcement entity);

    @DeleteMapping("announcement/{id}")
    CommonResult<Announcement> delete(@PathVariable("id")long id);

    @PostMapping("announcement/list")
    CommonResult<List<Announcement>> queryList();

    @PostMapping("announcement/condition")
    CommonResult<List<Announcement>> queryListByCondition(@RequestBody Announcement announcement) ;
}
