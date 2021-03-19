package io.github.jast90.fee.service;

import com.google.common.collect.Lists;
import io.github.jast90.fee.client.resource.HouseClient;
import io.github.jast90.fee.entity.HouseFee;
import io.github.jast90.fee.mapper.HouseFeeMapper;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.resource.entity.House;
import io.github.jast90.resource.form.HouseConditionForm;
import io.github.jast90.web.common.result.CommonResult;
import io.github.jast90.web.common.result.MyResult;
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
public class HouseFeeService extends BaseService<HouseFeeMapper, HouseFee> {


    @Autowired
    private HouseClient houseClient;

    @Override
    public CommonResult<HouseFee> add(HouseFee entity) {
        entity.setTotalFee(entity.getWaterFee().add(entity.getElectricFee()));
        return super.add(entity);
    }

    @Override
    public CommonResult<Page<HouseFee>> queryPage(PageRequest pageRequest, HouseFee entity) {
        CommonResult<Page<HouseFee>> pageCommonResult = super.queryPage(pageRequest, entity);
        List<Long> houseIds = Lists.newArrayList();
        if(pageCommonResult.getData()!=null && pageCommonResult.getData().getContent()!=null){
            for (HouseFee houseFee : pageCommonResult.getData().getContent()) {
                houseIds.add(houseFee.getId());
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
            for (HouseFee houseFee : pageCommonResult.getData().getContent()) {
                houseFee.setHouseName(houseIdHouseNameMap.get(houseFee.getHouseId()));
            }
        }

        return pageCommonResult;
    }

    @Override
    public CommonResult<HouseFee> queryById(Long id) {
        HouseFee houseFee = mapper.selectByPrimaryKey(id);
        CommonResult<House> houseCommonResult = houseClient.queryById(houseFee.getHouseId());
        if(houseCommonResult.getData()!=null){
            houseFee.setHouseName(houseCommonResult.getData().getHouseName());
        }
        return new CommonResult<>(MyResult.SUCCESS,houseFee);
    }

    public void updateStatusToPaySuccess(Long id) {
        mapper.updateStatusToPaySuccess(id);
    }
}
