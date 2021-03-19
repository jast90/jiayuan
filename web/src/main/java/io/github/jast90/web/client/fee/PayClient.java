package io.github.jast90.web.client.fee;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jast90 on 2021/3/18
 */
@FeignClient("fee")
public interface PayClient {

    @GetMapping("house/fee/pay/{id}")
    String alipay(@PathVariable("id") long id);

    @GetMapping("house/fee/pay/alipay/callback")
    String alipaySuccess(@RequestParam("trade_status") String tradeStatus, @RequestParam("out_trade_no") String outTradeNo);
}
