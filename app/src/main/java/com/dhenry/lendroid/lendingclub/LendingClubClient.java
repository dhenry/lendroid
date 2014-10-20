package com.dhenry.lendroid.lendingclub;

import com.dhenry.lendroid.lendingclub.models.AccountSummary;

import org.jetbrains.annotations.NotNull;

import retrofit.RetrofitError;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

public class LendingClubClient {

    @NotNull LendingClubAPI lendingClubAPI;

    public LendingClubClient(@NotNull LendingClubAPI lendingClubAPI) {
        this.lendingClubAPI = lendingClubAPI;
    }

    public Observable<AccountSummary> getAccountSummary(String investorId) {
        return observableFrom(() -> lendingClubAPI.getAccountSummary(investorId));
    }

    <T> Observable<T> observableFrom(Func0<T> func) {
        return Observable.create((Subscriber<? super T> subscriber) -> {
            try {
                T result = func.call();
                subscriber.onNext(result);
                subscriber.onCompleted();
            } catch (RetrofitError e) {
                subscriber.onError(e);
            }
        });
    }
}
