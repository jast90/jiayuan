package io.github.jast90.resource.service;

import io.github.jast90.resource.entity.House;
import io.github.jast90.resource.mapper.HouseMapper;
import io.github.jast90.web.common.result.CommonResult;
import io.github.jast90.web.common.result.MyResult;
import io.github.jast90.web.common.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * Created by jast90 on 2021/3/16
 */
@Service
public class HouseService extends BaseService<HouseMapper, House> {

    public CommonResult updateStatusToJoined(Long id){
        if(mapper.updateStatusToJoined(id)>0){
            return new CommonResult<>(MyResult.SUCCESS);
        }
        return new CommonResult(MyResult.FAIL);
    }
}
