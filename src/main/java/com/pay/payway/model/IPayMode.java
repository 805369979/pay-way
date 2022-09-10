package com.pay.payway.model;

import com.pay.payway.entity.UserInfo;

// 支付方式
public interface IPayMode {
    // 校验是否通过
    boolean security(UserInfo info);
    // 检查是否支持当前支付方式
    boolean support(String payWay);
}
