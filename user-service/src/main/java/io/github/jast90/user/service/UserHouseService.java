package io.github.jast90.user.service;

import com.google.common.collect.Lists;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.resource.entity.House;
import io.github.jast90.resource.form.HouseConditionForm;
import io.github.jast90.user.client.resource.HouseClient;
import io.github.jast90.user.entity.UserHouse;
import io.github.jast90.user.mapper.UserHouseMapper;
import io.github.jast90.web.common.result.CommonResult;
import io.github.jast90.web.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jast90 on 2021/3/15
 */
@Service
public class UserHouseService extends BaseService<UserHouseMapper, UserHouse> {

    @Autowired
    private HouseClient houseClient;

    @Override
    public CommonResult<Page<UserHouse>> queryPage(PageRequest pageRequest, UserHouse entity) {
        CommonResult<Page<UserHouse>> pageCommonResult = super.queryPage(pageRequest, entity);
        List<Long> houseIds = Lists.newArrayList();
        Map<Long,UserHouse> houseIdUserHouseMap = new HashMap<>();
        if(pageCommonResult.getData()!=null && pageCommonResult.getData().getContent()!=null){
            for (UserHouse userHouse : pageCommonResult.getData().getContent()) {
                houseIds.add(userHouse.getHouseId());
                houseIdUserHouseMap.put(userHouse.getHouseId(),userHouse);
            }
        }
        HouseConditionForm conditionForm = new HouseConditionForm();
        conditionForm.setHouseIds(houseIds);
        CommonResult<List<House>> houseListCommonResult = houseClient.queryListByCondition(conditionForm);
        if(houseListCommonResult.getData() != null){
            for (House house : houseListCommonResult.getData()) {
                houseIdUserHouseMap.get(house.getId())
                        .setHouseName(house.getHouseName());
            }
        }

        return pageCommonResult;
    }

    @Override
    public CommonResult<UserHouse> add(UserHouse entity) {
        CommonResult<UserHouse> result = super.add(entity);
        houseClient.updateStatusToJoined(entity.getHouseId());
        return result;
    }
}
