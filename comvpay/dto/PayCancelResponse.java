package com.zerobase.comvpay.dto;

import com.zerobase.comvpay.type.PayCancelResult;

public class PayCancelResponse {
    PayCancelResult payCancelResult;
    Integer payCancelAmount;

    public PayCancelResponse(PayCancelResult payCancelResult, Integer payCancelAmount) {
        this.payCancelResult = payCancelResult;
        this.payCancelAmount = payCancelAmount;
    }

    public PayCancelResult getPayCancelResult() {
        return payCancelResult;
    }

    public void setPayCancelResult(PayCancelResult payCancelResult) {
        this.payCancelResult = payCancelResult;
    }

    public Integer getPayCancelAmount() {
        return payCancelAmount;
    }

    public void setPayCancelAmount(Integer payCancelAmount) {
        this.payCancelAmount = payCancelAmount;
    }

    @Override
    public String toString() {
        return "PayCancelResponse{" +
                "payCancelResult=" + payCancelResult +
                ", payCancelAmount=" + payCancelAmount +
                '}';
    }
}
