package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.Generator;
import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.activeobject.ObserverGenerator;
import fr.istic.gm.aodp.activeobject.ObserverGeneratorAsync;
import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Canal implements GeneratorAsync, ObserverGeneratorAsync {

    private ObserverGenerator observerGenerator;

    private ScheduledExecutorService scheduledExecutorService;

    private Long customRetard;

    @Override
    public Future<Integer> update(Generator generator) {
        UpdateCallableImpl mi = new UpdateCallableImpl(this, observerGenerator);
        return scheduledExecutorService.schedule(mi, customRetard, TimeUnit.SECONDS);
    }
}
