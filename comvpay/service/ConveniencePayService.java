package com.zerobase.comvpay.service;

import com.zerobase.comvpay.dto.*;
import com.zerobase.comvpay.type.*;

// 편결이 서비스
public class ConveniencePayService {
    // 결제
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();   // 변동 X   final 사용 , 생성자 호출필요 x
    private final CardAdapter cardAdapter = new CardAdapter();
//    private  final DiscountInterface discountInterface = new DiscountByPayMethod();
    private  final DiscountInterface discountInterface = new DiscountByConvenience();     // 인터페이스 다형성 사용
    //인터페이스 다형성 쓰는 이유 ? WorkSpace의 입장에서는 그 중 원하는 것만 뽑아 쓸 수 있다는 것이 장점  즉, 인터페이스 다형성의 장점은 원하는 기능에 집중할 수 있다.


    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface;

        if(payRequest.getPayMethodType() == PayMethodType.CARD){
            paymentInterface = cardAdapter;
        }else{
            paymentInterface = moneyAdapter;
        }

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
        PaymentInterface paymentInterface;

        if(payCancelRequest.getPayMethodType() == PayMethodType.CARD){
            paymentInterface = cardAdapter;
        }else{
            paymentInterface = moneyAdapter;
        }

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        if(cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL){
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}
