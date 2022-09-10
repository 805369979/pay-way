package com.pay.payway.pay;

import com.pay.payway.entity.UserInfo;
import com.pay.payway.model.IPayMode;
import com.pay.payway.model.Target;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Slf4j
@Component
public class WxPay extends PayAbstracted{

    @Override
    public boolean support(String payWay) {
        return "wx".equals(payWay);
    }

    @Transactional
    public Boolean transfer(UserInfo info) {
        String tradeId = info.getTradeId();
        BigDecimal total = info.getTotal();
        // 调用交易方式付款
        System.out.println("交易单:"+tradeId+" 费用是："+total+" 支付方式是："+info.getPayWay()+" 完成付款");
        return true;
    }
}
