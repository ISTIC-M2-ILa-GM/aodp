package fr.istic.gm.aodp.diffusion.impl;

import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.diffusion.Diffusion;
import fr.istic.gm.aodp.diffusion.GeneratorDiffusion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class CausalDiffusion implements Diffusion {

    private Integer value;

    @Override
    public List<Future<?>> execute(GeneratorDiffusion generator) {
        this.value = generator.getValue();
        List<Future<?>> futures = new ArrayList<>();
        generator.getObservers().forEach(o -> futures.add(o.update(generator)));
        return futures;
    }

    @Override
    public Integer getValue(GeneratorAsync generator) {
        return this.value;
    }
}
