package fr.istic.gm.aodp.strategy.impl;

import fr.istic.gm.aodp.activeobject.Generator;
import fr.istic.gm.aodp.strategy.Diffusion;
import fr.istic.gm.aodp.strategy.DiffusionException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * The Atomic Diffusion
 */
public class AtomicDiffusion implements Diffusion {

    static final String FORBIDDEN = "Set is forbidden, you need to wait all getValue.";

    @Override
    public List<Future<Integer>> execute(Generator generator) {
        List<Future<Integer>> futures = new ArrayList<>();
        generator.getObservers().forEach(o -> futures.add(o.update(generator)));
        return futures;
    }

    @Override
    public void verify() {
        throw new DiffusionException(FORBIDDEN);
    }

    @Override
    public Integer getValue(Generator generator) {
        return null;
    }
}
