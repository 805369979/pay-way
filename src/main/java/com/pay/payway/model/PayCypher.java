package com.pay.payway.model;

import com.pay.payway.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PayCypher implements IPayMode {
    public boolean security(UserInfo uId) {
        log.info("密码支付，风控校验环境安全");
        return true;
    }

    @Override
    public boolean support(String payWay) {
        if ("password".equals(payWay)){
            return true;
        }
        return false;
    }
}