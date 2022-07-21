package com.zerobase.comvpay;

import com.zerobase.comvpay.dto.PayCancelRequest;
import com.zerobase.comvpay.dto.PayCancelResponse;
import com.zerobase.comvpay.dto.PayRequest;
import com.zerobase.comvpay.dto.PayResponse;
import com.zerobase.comvpay.service.ConveniencePayService;
import com.zerobase.comvpay.type.ConvenienceType;

public class UserClient {
    public static void main(String[] args) {
        // '사용자' -> 편결이 -> 머니

        ConveniencePayService conveniencePayService = new ConveniencePayService();

        // G25, 결제 1000원
        PayRequest payRequest = new PayRequest(ConvenienceType.G25,1000);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse);

        // G25, 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse);
    }
}
