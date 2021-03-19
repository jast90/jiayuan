package io.github.jast90.web.common.controller;

import io.github.jast90.common.entity.BaseEntity;
import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.web.common.result.CommonResult;
import io.github.jast90.web.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class BaseController<S extends BaseService,E extends BaseEntity> {
    @Autowired
    protected S service;

    protected String getAppId(){
        return "";
    }

    public CommonResult<Page<E>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, E> requestBody){
        return service.queryPage(requestBody.getPageRequest(),requestBody.getDomain());
    }

    public CommonResult<E> queryById(@PathVariable("id") long id){
        return service.queryById(id);
    }

    public CommonResult<E> add(@RequestBody E entity){
        return service.add(entity);
    }

    public CommonResult<E> update(@RequestBody E entity){
        return service.updateById(entity);
    }

    public CommonResult<E> delete(@PathVariable("id") long id){
        return service.deleteById(id);
    }

    public CommonResult<List<E>> queryList(){
        return service.queryList();
    }

    public CommonResult<List<E>> queryListByCondition(E e){
        return service.queryListByCondition(e);
    }
}
