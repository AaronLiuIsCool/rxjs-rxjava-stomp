package com.samples.rx.jsjava.domain;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

public class Account {

    private Integer id;
    private String name;
    private float amount;

    private transient Promotion promotion;

    public Account() {
    }

    public Account(Integer id, String name, float amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getAmount() {
        return amount;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public static ObservableSource<Account> create(Integer id, String name, float amount) {
        return Observable.just(new Account(id, name, amount));
    }


    public Account attachPromotion(Promotion promotion) {
        this.promotion = promotion;
        return this;
    }
}
