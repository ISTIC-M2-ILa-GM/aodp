package fr.istic.gm.aodp.strategy.impl;

import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.activeobject.TrueValueGenerator;
import fr.istic.gm.aodp.strategy.Diffusion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * The Atomic Diffusion
 */
public class AtomicDiffusion implements Diffusion {
    private Integer value;

    @Override
    public List<Future<Integer>> execute(TrueValueGenerator generator) {
        this.value = generator.getTrueValue();

        List<Future<Integer>> futures = new ArrayList<>();
        generator.getObservers().forEach(o -> futures.add(o.update(generator)));
        return futures;
    }

    @Override
    public void verify() {

    }

    @Override
    public Integer getValue(GeneratorAsync generator) {
        return this.value;
    }
}
