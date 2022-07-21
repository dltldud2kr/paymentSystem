package com.zerobase.comvpay.service;

import com.zerobase.comvpay.dto.*;
import com.zerobase.comvpay.type.MoneyUseCancelResult;
import com.zerobase.comvpay.type.MoneyUseResult;
import com.zerobase.comvpay.type.PayCancelResult;
import com.zerobase.comvpay.type.PayResult;

// 편결이 서비스
public class ConveniencePayService {
    // 결제
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();   // 변동 X   final
    public PayResponse pay(PayRequest payRequest) {
        MoneyUseResult moneyUseResult =
                moneyAdapter.use(payRequest.getPayAmount());        // moneyAdapter에

        //fail fast

        if (moneyUseResult == MoneyUseResult.USE_FAIL){
            return new PayResponse(PayResult.FAIL, 0);
        }

        //Success Case
            return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());
    }

    //결제 취소
    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        MoneyUseCancelResult moneyUseCancelResult =
                moneyAdapter.useCancel(payCancelRequest.getPayCancelAmount());

        if(moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL){
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
    }
}
