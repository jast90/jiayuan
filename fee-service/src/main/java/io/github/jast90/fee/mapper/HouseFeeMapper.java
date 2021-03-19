package io.github.jast90.fee.mapper;

import io.github.jast90.fee.entity.HouseFee;
import io.github.jast90.web.common.mapper.BaseMapper;

/**
 * Created by jast90 on 2021/3/15
 */
public interface HouseFeeMapper extends BaseMapper<HouseFee> {
    int updateStatusToPaySuccess(Long id);
}
