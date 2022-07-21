package com.zerobase.comvpay.dto;

import com.zerobase.comvpay.type.ConvenienceType;

//결제 요청
public class PayRequest {
    //편의점 종류
    ConvenienceType convenienceType;

    //결제 금액
    Integer payAmount;

    public PayRequest(ConvenienceType convenienceType, Integer payAmount) {
        this.convenienceType = convenienceType;
        this.payAmount = payAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }
}
