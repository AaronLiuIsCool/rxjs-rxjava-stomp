package com.samples.rx.jsjava.repository;

import com.samples.rx.jsjava.domain.Account;
import com.samples.rx.jsjava.domain.Promotion;
import io.reactivex.Observable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PromotionRepository {


    public Observable<Account> attachAccountPromotion(Account account) {

        return Observable.just(account)
                .map(accountToHavePromotionAttachedTo ->
                        accountToHavePromotionAttachedTo.attachPromotion(
                                new Promotion("Promotion for " + account.getName(),
                                        LocalDateTime.of(2017, 12, 15, 12, 0),
                                        LocalDateTime.of(2017, 12, 17, 14, 0)))
                );

    }
}
