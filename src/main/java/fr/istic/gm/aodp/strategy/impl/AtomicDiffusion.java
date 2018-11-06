package fr.istic.gm.aodp.strategy.impl;

import fr.istic.gm.aodp.activeobject.Generator;
import fr.istic.gm.aodp.strategy.Diffusion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * The Atomic Diffusion
 */
public class AtomicDiffusion implements Diffusion {

    @Override
    public List<Future<Integer>> execute(Generator generator) {
        List<Future<Integer>> futures = new ArrayList<>();
        generator.getObservers().forEach(o -> futures.add(o.update(generator)));
        return futures;
    }

    @Override
    public void verify() {

    }

    @Override
    public Integer getValue(Generator generator) {
        return null;
    }
}
