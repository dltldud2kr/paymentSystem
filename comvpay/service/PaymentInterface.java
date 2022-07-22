package com.zerobase.comvpay.service;

import com.zerobase.comvpay.type.CancelPaymentResult;
import com.zerobase.comvpay.type.PaymentResult;

//인터페이스는 public 하게 만들려면 만드는 것임
public interface PaymentInterface {
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelPayment(Integer cancelAmount);

}
