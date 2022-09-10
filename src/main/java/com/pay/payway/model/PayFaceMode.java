package com.pay.payway.model;

import com.pay.payway.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PayFaceMode implements IPayMode {
    public boolean security(UserInfo info) {
        log.info("人脸支付，风控校验脸部识别");
        return true;
    }


    @Override
    public boolean support(String payWay) {
        if ("Face".equals(payWay)){
            return true;
        }
        return false;
    }

}
