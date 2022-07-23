package com.zerobase.comvpay.service;

import com.zerobase.comvpay.dto.*;
import com.zerobase.comvpay.type.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 편결이 서비스
public class ConveniencePayService {
    // 결제

    //key , value 를 받는 map 타입의 paymentInterfaceMap 생성
    private final Map<PayMethodType, PaymentInterface> paymentInterfaceMap =
            new HashMap<>();
    private final DiscountInterface discountInterface; // 껍데기만 있는 인터페이스

    public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet,
                                 DiscountInterface discountInterface) {
        paymentInterfaceSet.forEach(
            paymentInterface -> paymentInterfaceMap.put(
                    paymentInterface.getPayMethodType(),
                    paymentInterface
            )
        );
        this.discountInterface = discountInterface;
    }

    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payRequest.getPayMethodType());


        Integer discountedAmount = discountInterface.getDiscountedAmount(payRequest);   // 할인정책을 적용한 금액을 산출하기위해
        PaymentResult payment = paymentInterface.payment(discountedAmount);


        //fail fast

        if (payment == PaymentResult.PAYMENT_FAIL){
            return new PayResponse(PayResult.FAIL, 0);
        }

        //Success Case
            return new PayResponse(PayResult.SUCCESS, discountedAmount);
    }

    //결제 취소
    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payCancelRequest.getPayMethodType());

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        if(cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL){
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}
