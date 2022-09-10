package com.pay.payway.model;

import com.pay.payway.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PayAdapter implements Target {

    @Autowired
    List<IPayMode> payModes;

    @Override
    public IPayMode request(UserInfo info) {

        log.info("模拟支付验证开始info{}",info);
        Target mode = null;
        for (IPayMode payMode: payModes) {
            if(payMode.support(info.getPayMode())){
                return payMode;
            }
        }
        throw new RuntimeException("未找到支付验证途径");
    }
}
