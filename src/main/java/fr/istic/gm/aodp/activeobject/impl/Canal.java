package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class Canal implements GeneratorAsync, ObserverGeneratorAsync {

    private final ObserverGenerator observerGenerator;

    private final ScheduledExecutorService scheduledExecutorService;

    private final Long customRetard;

    private Generator generator;

    @Override
    public Future<Integer> update(Generator generator) {

        this.generator = generator;
        UpdateCallable mi = new UpdateCallableImpl(this, observerGenerator);
        return scheduledExecutorService.schedule(mi, customRetard, TimeUnit.SECONDS);
    }


    @Override
    public Future<Integer> getValue() {
        GetValueCallable mi = new GetValueCallableImpl(this, generator);
        return scheduledExecutorService.schedule(mi, customRetard, TimeUnit.SECONDS);
    }
}
