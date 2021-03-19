package io.github.jast90.web.common.service;

import io.github.jast90.common.entity.BaseEntity;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageList;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.web.common.mapper.BaseMapper;
import io.github.jast90.web.common.result.CommonResult;
import io.github.jast90.web.common.result.MyResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseService<M extends BaseMapper,E extends BaseEntity> {
    @Autowired
    protected M mapper;

    /**
     * 添加实体
     * @param entity
     * @return
     */
    public CommonResult<E> add(E entity){
        if(1 == mapper.insert(entity)){
            return new CommonResult<>(MyResult.SUCCESS,entity);
        }
        return new CommonResult<>(MyResult.FAIL);
    }

    /**
     * 更新实体
     * @param entity
     * @return
     */
    public CommonResult<E> updateById(E entity){
        if(1 == mapper.updateByPrimaryKey(entity)){
            return new CommonResult<>(MyResult.SUCCESS,entity);
        }
         return new CommonResult<>(MyResult.FAIL);
    }


    public CommonResult<E> queryById(Long id){
        E entity = (E) mapper.selectByPrimaryKey(id);
        return new CommonResult<>(MyResult.SUCCESS,entity);
    }

    public CommonResult<List<E>> queryList(){
        List<E> list = mapper.selectAll();
        return new CommonResult<>(MyResult.SUCCESS,list);
    }

    /**
     * 分页查询实体
     * @param pageRequest
     * @param entity
     * @return
     */
    public CommonResult<Page<E>> queryPage(PageRequest pageRequest, E entity){
        PageList<E> pageList = mapper.selectPage(pageRequest,entity);
        return new CommonResult(MyResult.SUCCESS,pageList.getPage());
    }

    public CommonResult<E> deleteById(long id) {
        if(mapper.deleteByPrimaryKey(id)==1){
            return new CommonResult<>(MyResult.SUCCESS);
        }
        return new CommonResult<>(MyResult.FAIL);
    }

    public CommonResult<List<E>>queryListByCondition(E e) {
        List<E> list = mapper.selectListByCondition(e);
        return new CommonResult<>(MyResult.SUCCESS,list);
    }
}
