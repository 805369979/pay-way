package com.pay.payway.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserInfo {
    private String idCard;
    private String password;
    private String iphoneNum;
    private String payWay;
    private String payMode;
    private String tradeId;
    private BigDecimal total;
}
