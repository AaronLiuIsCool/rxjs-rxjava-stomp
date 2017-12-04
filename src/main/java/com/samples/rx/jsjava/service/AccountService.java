package com.samples.rx.jsjava.service;

import com.samples.rx.jsjava.domain.Account;
import com.samples.rx.jsjava.repository.AccountRepository;
import com.samples.rx.jsjava.repository.PromotionRepository;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PromotionRepository promotionRepository;

    /**
     * Collect user accounts including the promotions for each account
     *
     * @param user account for user
     * @return {@link Observable} instances of {@link Account}
     */
    public Observable<Account> getUserAccounts(String user) {
        return Observable.just(user)
                .flatMap(accountRepository::getUserAccounts)
                .flatMap(promotionRepository::attachAccountPromotion);
    }

}
