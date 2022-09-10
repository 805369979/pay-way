package com.pay.payway;

import com.pay.payway.entity.UserInfo;
import com.pay.payway.model.IPayMode;
import com.pay.payway.model.PayAdapter;
import com.pay.payway.model.Target;
import com.pay.payway.pay.PayAbstracted;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class PayWayApplicationTests {

    @Autowired
    List<PayAbstracted> payAbstracteds;

    @Test
    void contextLoads() {
        UserInfo userInfo = new UserInfo();
        userInfo.setIdCard("1411xxx");
        userInfo.setIphoneNum("13250967872");
        userInfo.setPassword("123");
        userInfo.setPayWay("zfb");
        userInfo.setTradeId("123456");
        userInfo.setPayMode("Face");
        userInfo.setTotal(new BigDecimal("100"));

        for (PayAbstracted pay:payAbstracteds) {
            if (pay.support(userInfo.getPayWay())){
                pay.template(userInfo);
                break;
            }
        }
    }
}
