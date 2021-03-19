package io.github.jast90.convenience.service;

import com.google.common.collect.Lists;
import io.github.jast90.convenience.client.resource.HouseClient;
import io.github.jast90.convenience.client.user.UserClient;
import io.github.jast90.convenience.entity.Complaint;
import io.github.jast90.convenience.entity.Repair;
import io.github.jast90.convenience.mapper.RepairMapper;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.resource.entity.House;
import io.github.jast90.resource.form.HouseConditionForm;
import io.github.jast90.user.entity.User;
import io.github.jast90.user.entity.UserHouse;
import io.github.jast90.user.form.UserConditionForm;
import io.github.jast90.web.common.result.CommonResult;
import io.github.jast90.web.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jast90 on 2021/3/16
 */
@Service
public class RepairService extends BaseService<RepairMapper, Repair> {

    @Autowired
    private HouseClient houseClient;
    @Autowired
    private UserClient userClient;

    @Override
    public CommonResult<Page<Repair>> queryPage(PageRequest pageRequest, Repair entity) {
        CommonResult<Page<Repair>> pageCommonResult = super.queryPage(pageRequest, entity);
        if(pageCommonResult.getData() != null && pageCommonResult.getData().getContent() != null){
            List<Long> houseIds = Lists.newArrayList();
            List<Long> userIds = Lists.newArrayList();

            for (Repair repair : pageCommonResult.getData().getContent()) {
                houseIds.add(repair.getHouseId());
                userIds.add(repair.getCreateUserId());
            }
            HouseConditionForm conditionForm = new HouseConditionForm();
            conditionForm.setHouseIds(houseIds);
            CommonResult<List<House>> houseListCommonResult = houseClient.queryListByCondition(conditionForm);
            Map<Long,String> houseIdHouseNameMap = new HashMap<>();
            if(houseListCommonResult.getData() != null){
                for (House house : houseListCommonResult.getData()) {
                    houseIdHouseNameMap.put(house.getId(),house.getHouseName());
                }
            }
            for (Repair repair : pageCommonResult.getData().getContent()) {
                repair.setHouseName(houseIdHouseNameMap.get(repair.getHouseId()));
            }

            UserConditionForm userConditionForm = new UserConditionForm();
            userConditionForm.setUserIds(userIds);
            CommonResult<List<User>> listCommonResult = userClient.queryListByCondition(userConditionForm);
            Map<Long,String> userIdUserNameMap = new HashMap<>();
            if(listCommonResult.getData()!=null){
                for (User user : listCommonResult.getData()) {
                    userIdUserNameMap.put(user.getId(),user.getRealName());
                }
            }
            for (Repair repair : pageCommonResult.getData().getContent()) {
                repair.setUserName(userIdUserNameMap.get(repair.getCreateUserId()));
            }
        }
        return pageCommonResult;
    }
}
