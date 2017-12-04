package com.samples.rx.jsjava.repository;

import com.samples.rx.jsjava.domain.Account;
import io.reactivex.Observable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountRepository {


    /**
     * Mock! getting user accounts as they are found in the data source.
     *
     * @param user user owner of the account
     * @return {@link Observable} instance of {@link Account}
     */
    public Observable<Account> getUserAccounts(String user) {
        // This method mocks calling a database, third party micro service or a search engine, a source of data
        return Observable.range(0, 15)
                .flatMap(id -> Account.create(id, user + " - Account " + id, 500 + (new Random()).nextFloat() * (1500 - 500)))
                .flatMap(account -> {
                    // send error on even numbers
                    if (account.getId() % 2 == 0) {
                        Observable.error(new RuntimeException("Invalid account type"));
                    }
                    // creating a delay to show on the client slow motion of the subscription
                    Thread.sleep(500 + (new Random()).nextInt() * (3000 - 500));
                    return Observable.just(account);
                });
    }


}
