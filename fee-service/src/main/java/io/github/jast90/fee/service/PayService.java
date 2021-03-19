package io.github.jast90.fee.service;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.app.models.AlipayTradeAppPayResponse;
import com.alipay.easysdk.payment.common.models.AlipayTradeCreateResponse;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePayResponse;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import io.github.jast90.fee.entity.HouseFee;
import io.github.jast90.fee.mapper.HouseFeeMapper;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jast90 on 2021/3/18
 */
@Service
public class PayService {

    @Autowired
    private HouseFeeService houseFeeService;

    public String pay(Long houseFeeId){
        try {
            CommonResult<HouseFee> houseFeeCommonResult = houseFeeService.queryById(houseFeeId);
            HouseFee houseFee = houseFeeCommonResult.getData();
            String subject = String.format("%s的%s到%s费用",houseFee.getHouseName(),houseFee.getStartDatetime(),houseFee.getEndDatetime());
            Factory.setOptions(getOptions());
            AlipayTradePrecreateResponse response = Factory.Payment.FaceToFace().preCreate(subject, String.valueOf(houseFeeId), String.valueOf(houseFee.getTotalFee()));
            if (ResponseChecker.success(response)) {
                System.out.println("调用成功");
            } else {
                System.err.println("调用失败，原因：" + response.msg + "，" + response.subMsg);
            }
            String qrCode =response.qrCode;
            return qrCode;
        } catch (Exception e) {
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private Config getOptions() {
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipaydev.com";
        config.signType = "RSA2";

        config.appId = "2021000118662619";

        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCvXZNLc1Tq22S8LYrLmjwkpLISdkRLu92zh/U9bDxQ20S+Q4h1pzp9w8sBlrR1Nnz0SA8cOjA5GjoIqL/QLL9pdCHojWAjbO6e+uJvRMO7qH1SxbKc45an26Y5kHyOo6T6Ts9JgpRjDE7qyUB4MKRTi5ayaqPD1rmj+tfvxMu6M2P5U1G8cB9swb1s2iSj7YlYd7+2/m2FUgbj/sIQveIq/M14Bzxk5AM3P9inBwFZYC/7dsVCYfqDJ0uUv78L7Ri0Cj6LQdjW5Zjsmqh0aQCSLIjo32Vzw+Cux5l5Cxth87xIkHv0v/hb7XlSOm5hKZEh5AEpul6B4v9M20eeJTONAgMBAAECggEAG/hr5uvlTnRh09Xbvm/CSgHu2Rz99apoSRtVVU+vKyJeC47P9BwRK0AQYBd+fveK5JeduV3alTEGspzfwz9v5Ez+n431GJFmWfsgJKkuIv9TxeD8hSOTwwA4uhO+mi2lwbrSOyJVspqi97XTz5fKjfzEs35o0nKsN2hqCrcz22XUkenyhmNJoBmpjsFxKD3I2wGBDA73UWvKUDYFtnwK51y+yFfDaJktvDnZlicTHmF4s/6dFQ/Oy8fFm+1kgrCjTPhYBjTU/34dw6DFHuJh92zDn98LWlGO28fWi8CimcoE3p8//7Uwp5lA3kicWerSUGd3Nc558efSpIdgGBNrIQKBgQD3l+I0/qvBJ6VlPdCwmqJfGpf7en+8iCOy4XaGE39llgaWhYlcL8CaJ3hba1MDLa5y/xiFQd9Qogt36YCTO7svOeBetPQ5IQNj7gC030M7nMj6j8HhF4GwW9WQef3b1kf4GvDYyTg3+4ChsvzignuqcD8mNw+FEvuzksxp6nm8KQKBgQC1UeCuO0kuKTV67PYbm8w0F4/ggld5BL7zlyhB89h/lZUnqbeCGx1tMM1+dSqR0C7byJZbJT+7/OqEjBg+sYd1NJ55YSsWT3YTJ6Jub5EQ9SBHezbb+pFcymS3bZ9NJubMBiRP5zJq3FmIQmjOQDiV6yD1XdiHxbQrqPaUoqkoxQKBgQCxnHX8ODizjiI61zYuii8ydBxUnVKmxy58svpYQgJguFevgMnBpMvQicHwKrRZElsTSWWoqlFtQWFiutGuTOoBfc4zgjG0Dbel5uUA2ywaxmTyQU/+jeNNxQMV6j0uh7AHDiR6DxbSKgvjc0evoZTe9jiGzHbIqo5/Ci6zSC3dyQKBgBUieRT19h66UPCGJF2teEzuHigmKToC8psEGH4vhSHB9sPLxYcV0AVFNf6ye4bJhFy78cKoAdjQrylKBx1vpgFkY8B0MgiEtJeg/A7xVDBs0hli5E8Z0s3FDZ5P2cytZyOK57qkkTzheFIoo3y/AZl/8bSH/tA8nDammC9VEnCdAoGAKZPiGy5wMWOTn/rgv1a1keA4K9jqfLgIIQLF1jMPHE/KgSekOF8iF09F/yI55x8Pj4kf9lHOdBfekhRmv4hBFZFNOXer/7jETNO3SzQOGuvge9yqEukfm6mkDAViZIa0WeYtrH9698GVYhBXdosm7jtl0DXtspaOBu0E1hSLaB4=";

        //注：证书文件路径支持设置为文件系统中的路径或CLASS_PATH中的路径，优先从文件系统中加载，加载失败后会继续尝试从CLASS_PATH中加载
//        config.merchantCertPath = "<-- 请填写您的应用公钥证书文件路径，例如：/foo/appCertPublicKey_2019051064521003.crt -->";
//        config.alipayCertPath = "<-- 请填写您的支付宝公钥证书文件路径，例如：/foo/alipayCertPublicKey_RSA2.crt -->";
//        config.alipayRootCertPath = "<-- 请填写您的支付宝根证书文件路径，例如：/foo/alipayRootCert.crt -->";

        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
         config.alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAg21x/Nnrp6W3KAUMmsliZPd3hlQZYY1y5D32O7tjp5i5wV3OWgzm8eWTV/GzH3qDWd47tuYrJs1irptsR1OaLP6Wb08l/2AM5Yprk1UOynjdNOjLDJyhH1BWVu5rAgm2jYwwvQBPvPFtXtFtLOuzPESDjOlbff6lwGuWY01CXPlE28UQurRL6D4Sfqff7SzfKq7gJl8nI2HrK4cTy/18se6UL6s4R/CErm140rE2BrlbV4JgrYQVhrH3sbw4VGN4EPhmivSdM90Qh+a4gbcVX/zExnETF0CnWP+9DU2Sy9Lrl6L2WX+SJOIe8AoOk9gJw7Cd8xpxG3xWPttQXu0chwIDAQAB";

        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = "https://www.test.com/callback";

        //可设置AES密钥，调用AES加解密相关接口时需要（可选）
//        config.encryptKey = "<-- 请填写您的AES密钥，例如：aa4BtZ4tspm2wnXLb1ThQA== -->";

        return config;
    }

    public void paySuccess(Long id){
        houseFeeService.updateStatusToPaySuccess(id);
    }
}
