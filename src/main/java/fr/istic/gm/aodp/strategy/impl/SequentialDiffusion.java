package fr.istic.gm.aodp.strategy.impl;

import fr.istic.gm.aodp.activeobject.Generator;
import fr.istic.gm.aodp.strategy.Diffusion;

import java.util.List;
import java.util.concurrent.Future;

public class SequentialDiffusion implements Diffusion {
    public List<Future<Integer>> execute(Generator generator) {
        return null;
    }

    public void verify() {

    }

    @Override
    public Integer getValue(Generator generator) {
        return null;
    }
}
