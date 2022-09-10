package com.pay.payway.model;

import com.pay.payway.entity.UserInfo;

public interface Target {
    IPayMode request(UserInfo info);
}
