package io.github.jast90.web.controller.rest;

import io.github.jast90.common.form.CommonPageRequestBody;
import io.github.jast90.fee.entity.HouseFee;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.user.entity.UserHouse;
import io.github.jast90.web.client.fee.HouseFeeClient;
import io.github.jast90.web.client.fee.PayClient;
import io.github.jast90.web.client.user.UserClient;
import io.github.jast90.web.client.user.UserHouseClient;
import io.github.jast90.web.common.result.CommonResult;
import io.github.jast90.web.common.result.MyResult;
import io.github.jast90.web.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jast90 on 2021/3/16
 */
@RestController
public class HouseFeeRestController implements HouseFeeClient {
    @Autowired
    private HouseFeeClient houseFeeClient;

    @Autowired
    private PayClient payClient;

    @Autowired
    private SessionUtil sessionUtil;


    @PostMapping("/house/fee/page")
    @Override
    public CommonResult<Page<HouseFee>> queryPage(@RequestBody CommonPageRequestBody<PageRequest, HouseFee> requestBody) {
        if(sessionUtil.user()){
            requestBody.getDomain().setHouseId(sessionUtil.getUserHouseId());
        }
        return houseFeeClient.queryPage(requestBody);
    }

    @GetMapping("/house/fee/{id}")
    @Override
    public CommonResult<HouseFee> queryById(@PathVariable("id") long id) {
        return  houseFeeClient.queryById(id);
    }

    @PostMapping("/house/fee")
    @Override
    public CommonResult<HouseFee> add(@RequestBody HouseFee entity) {
        return houseFeeClient.add(entity);
    }

    @PutMapping("/house/fee")
    @Override
    public CommonResult<HouseFee> update(@RequestBody HouseFee entity) {
        return houseFeeClient.update(entity);
    }

    @DeleteMapping("/house/fee/{id}")
    @Override
    public CommonResult<HouseFee> delete(@PathVariable("id") long id) {
        return houseFeeClient.delete(id);
    }

    @PostMapping("/house/fee/list")
    @Override
    public CommonResult<List<HouseFee>> queryList() {
        return houseFeeClient.queryList();
    }

    @PostMapping("/house/fee/list/condition")
    @Override
    public CommonResult<List<HouseFee>> queryListByCondition(@RequestBody HouseFee houseFee) {
        return houseFeeClient.queryListByCondition(houseFee);
    }

    @PostMapping("/house/fee/pay/{id}")
    public CommonResult<String> payById(@PathVariable("id") long id) {
        String alipayQRUrl = payClient.alipay(id);
        if(alipayQRUrl!=null){
            return new CommonResult<>(MyResult.SUCCESS,alipayQRUrl);
        }
        return new CommonResult<>(MyResult.FAIL);
    }

    @GetMapping("alipay/callback")
    public String alipayCallback(@RequestParam("trade_status") String tradeStatus, @RequestParam("out_trade_no") String outTradeNo){
        return payClient.alipaySuccess(tradeStatus,outTradeNo);
    }

}
