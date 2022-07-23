package com.zerobase.comvpay.config;

import com.zerobase.comvpay.service.*;
import com.zerobase.comvpay.type.ConvenienceType;

import java.util.Arrays;
import java.util.HashSet;

public class ApplicationConfig {

    public ConveniencePayService conveniencePayServiceDiscountConvenience(){
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(new MoneyAdapter(), new CardAdapter())
                ),
                new DiscountByConvenience()
        );
    }

    public ConveniencePayService conveniencePayServiceDiscountPayMethod(){
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(new MoneyAdapter(), new CardAdapter())
                ),
                new DiscountByPayMethod()
        );
    }
}

