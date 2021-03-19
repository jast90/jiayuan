package io.github.jast90.fee.controller;

import io.github.jast90.fee.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jast90 on 2021/3/18
 */
@RestController
public class PayController {

    @Autowired
    private PayService payService;

    @GetMapping("house/fee/pay/{id}")
    public String alipay(@PathVariable("id")long id){
        return payService.pay(id);
    }

    //TODO 支付成功回调方法
    @GetMapping("house/fee/pay/alipay/callback")
    public String alipaySuccess(@RequestParam("trade_status") String tradeStatus,@RequestParam("out_trade_no") String outTradeNo){
        if("".equalsIgnoreCase("TRADE_SUCCESS")){
            payService.paySuccess(Long.parseLong(outTradeNo));
        }
        return "success";
    }
}
