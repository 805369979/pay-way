package com.pay.payway.model;

import com.pay.payway.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PayFingerprintMode implements IPayMode{
    public boolean security(UserInfo info) {
        log.info("指纹支付，风控校验指纹信息");
        return true;
    }


    @Override
    public boolean support(String payWay) {
        if ("Fingerprint".equals(payWay)){
            return true;
        }
        return false;
    }


}
