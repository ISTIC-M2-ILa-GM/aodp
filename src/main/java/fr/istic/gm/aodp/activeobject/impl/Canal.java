package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.activeobject.GetValueCallable;
import fr.istic.gm.aodp.activeobject.ObserverGenerator;
import fr.istic.gm.aodp.activeobject.ObserverGeneratorAsync;
import fr.istic.gm.aodp.activeobject.UpdateRunnable;
import fr.istic.gm.aodp.diffusion.GeneratorDiffusion;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class Canal implements GeneratorAsync, ObserverGeneratorAsync {

    private final ObserverGenerator observerGenerator;

    private final ScheduledExecutorService scheduledExecutorService;

    private final Long customRetard;

    private GeneratorDiffusion generator;

    @Override
    public Future update(GeneratorDiffusion generator) {

        this.generator = generator;
        UpdateRunnable mi = new UpdateRunnableImpl(this, observerGenerator);
        return scheduledExecutorService.schedule(mi, customRetard, TimeUnit.MILLISECONDS);
    }


    @Override
    public Future<Integer> getValue() {
        GetValueCallable mi = new GetValueCallableImpl(this, generator);
        return scheduledExecutorService.schedule(mi, customRetard, TimeUnit.MILLISECONDS);
    }
}
