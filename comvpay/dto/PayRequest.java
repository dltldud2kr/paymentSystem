package com.zerobase.comvpay.dto;

import com.zerobase.comvpay.type.ConvenienceType;
import com.zerobase.comvpay.type.PayMethodType;

//결제 요청
public class PayRequest {
    //결제 수단
    PayMethodType payMethodType;

    //편의점 종류
    ConvenienceType convenienceType;

    //결제 금액
    Integer payAmount;

    public PayRequest(PayMethodType payMethodType, ConvenienceType convenienceType, Integer payAmount) {
        this.payMethodType = payMethodType;
        this.convenienceType = convenienceType;
        this.payAmount = payAmount;
    }

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
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
