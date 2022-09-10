package com.pay.payway.pay;

import com.pay.payway.entity.UserInfo;
import com.pay.payway.model.IPayMode;
import com.pay.payway.model.PayAdapter;
import com.pay.payway.model.Target;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Component
public abstract class PayAbstracted {

    @Autowired
    Target adapter;

    // 支付方式前置工作
    public void template(UserInfo info){
        // 第一步：支付方式（微信、支付宝）方式的选择
        if(!support(info.getPayWay())){
            return;
        }
        // 第二步：找到支付的确认方式
        IPayMode payMode = findPayMode(info);
        // 第三步：支付安全校验
        boolean security = payMode.security(info);
        if (!security){
            throw new RuntimeException("支付方式安全校验失败");
        }

        // 第四步： 进行扣款转账
        Boolean transfer = transfer(info);
        if (!transfer) {
            throw new RuntimeException("交易失败");
        }

    }

    public IPayMode findPayMode(UserInfo info){
        IPayMode payMode = adapter.request(info);
        return payMode;
    }

    // 支付方式（微信、支付宝）方式的选择
    public abstract boolean support(String payWay);

    // 支付过程
    public abstract Boolean transfer(UserInfo info);

}
