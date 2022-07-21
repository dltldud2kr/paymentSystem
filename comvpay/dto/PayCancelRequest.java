package com.zerobase.comvpay.dto;

import com.zerobase.comvpay.type.ConvenienceType;

public class PayCancelRequest {
    //편의점 종류
    ConvenienceType convenienceType;

    //결제 취소 금액
    Integer payCancelAmount;

    public PayCancelRequest(ConvenienceType convenienceType, Integer payCancelAmount) {
        this.convenienceType = convenienceType;
        this.payCancelAmount = payCancelAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayCancelAmount() {
        return payCancelAmount;
    }

    public void setPayCancelAmount(Integer payCancelAmount) {
        this.payCancelAmount = payCancelAmount;
    }
}
