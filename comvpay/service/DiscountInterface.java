package com.zerobase.comvpay.service;

import com.zerobase.comvpay.dto.PayRequest;

public interface DiscountInterface {
    Integer getDiscountedAmount(PayRequest payRequest);

}
