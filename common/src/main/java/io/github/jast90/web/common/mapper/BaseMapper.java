package io.github.jast90.web.common.mapper;

import io.github.jast90.common.entity.BaseEntity;
import io.github.jast90.mybatis.pagination.domain.PageList;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<E extends BaseEntity> {

    int insert(E e);

    E selectByPrimaryKey(Long id);

    int updateByPrimaryKey(E e);

    int deleteByPrimaryKey(Long id);


    List<E> selectAll();

    List<E> selectListByCondition(E e);

    PageList<E> selectPage(@Param("pageRequest") PageRequest pageRequest,
                           @Param("condition") E condition);
}
