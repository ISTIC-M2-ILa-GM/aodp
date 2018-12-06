package fr.istic.gm.aodp.diffusion.impl;

import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.diffusion.Diffusion;
import fr.istic.gm.aodp.diffusion.GeneratorDiffusion;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * The Atomic Diffusion
 */
public class AtomicDiffusion implements Diffusion {

    static final String FORBIDDEN = "Set is forbidden, you need to wait all getValue.";

    @Getter(AccessLevel.PACKAGE)
    @Setter(AccessLevel.PACKAGE)
    private List<GeneratorAsync> generatorAsyncs = new ArrayList<>();

    private Integer value;

    @Getter(AccessLevel.PACKAGE)
    @Setter(AccessLevel.PACKAGE)
    private int observerNumber;

    @Override
    public List<Future<Integer>> execute(GeneratorDiffusion generator) {
        this.value = generator.getValue();
        this.generatorAsyncs = new ArrayList<>();
        this.observerNumber = generator.getObservers().size();

        List<Future<Integer>> futures = new ArrayList<>();
        generator.getObservers().forEach(o -> futures.add(o.update(generator)));
        return futures;
    }

    @Override
    public void verify() {
        if (generatorAsyncs != null && generatorAsyncs.size() != observerNumber) {
//            throw new DiffusionException(FORBIDDEN);
        }
    }

    @Override
    public Integer getValue(GeneratorAsync generator) {
        if (!generatorAsyncs.contains(generator)) {
            generatorAsyncs.add(generator);
        }
        return this.value;
    }
}
