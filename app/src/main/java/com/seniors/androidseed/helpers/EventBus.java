package com.seniors.androidseed.helpers;


import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by shehab-develop on 08/02/17.
 */

@Singleton
public class EventBus {
    private final PublishSubject<Object> busSubject;

    @Inject
    public EventBus() {
        this.busSubject = PublishSubject.create();
    }

    public void post(Object event){
        busSubject.onNext(event);
    }

    public Observable<Object> observable(){
        return busSubject;
    }

    public <T> Observable<T> filteredObservable (final Class<T> eventClass){
        return busSubject.ofType(eventClass);
    }
}
