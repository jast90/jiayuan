package io.github.jast90.resource.mapper;

import io.github.jast90.resource.entity.House;
import io.github.jast90.web.common.mapper.BaseMapper;

/**
 * Created by jast90 on 2021/3/16
 */
public interface HouseMapper extends BaseMapper<House> {

    int updateStatusToJoined(Long id);
}
