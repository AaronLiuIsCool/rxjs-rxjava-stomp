package com.samples.rx.jsjava.controller;

import com.samples.rx.jsjava.domain.Account;
import com.samples.rx.jsjava.service.AccountService;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @SubscribeMapping(value = "/queue/accounts")
    public Observable<Account> getObservablesSample(String user) throws InterruptedException {

        return accountService.getUserAccounts(user);
    }

}
