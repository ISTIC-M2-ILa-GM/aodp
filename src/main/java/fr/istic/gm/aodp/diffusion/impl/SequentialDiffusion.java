package fr.istic.gm.aodp.diffusion.impl;

import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.diffusion.Diffusion;
import fr.istic.gm.aodp.diffusion.GeneratorDiffusion;
import fr.istic.gm.aodp.memento.Memento;
import fr.istic.gm.aodp.memento.MementoFactory;
import fr.istic.gm.aodp.memento.impl.CaretakerImpl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@RequiredArgsConstructor
public class SequentialDiffusion extends CaretakerImpl<Integer> implements Diffusion {

    // Limit number of value ... recheck how work sequential ..

    @Getter(AccessLevel.PACKAGE)
    private Map<GeneratorAsync, Integer> generatorAsyncValuePosition = new HashMap<>();

    private final MementoFactory<Integer> mementoFactory;

    @Override
    public List<Future<Integer>> execute(GeneratorDiffusion generator) {
        addMemento(mementoFactory.create(generator.getValue()));
        List<Future<Integer>> futures = new ArrayList<>();
        generator.getObservers().forEach(o -> futures.add(o.update(generator)));
        return futures;
    }

    @Override
    public void verify() {

    }

    @Override
    public Integer getValue(GeneratorAsync generator) {
        if (!generatorAsyncValuePosition.containsKey(generator)) {
            generatorAsyncValuePosition.put(generator, 0);
        } else if (generatorAsyncValuePosition.get(generator) < mementoSize() - 1) {
            generatorAsyncValuePosition.put(generator, generatorAsyncValuePosition.get(generator) + 1);
        }
        Memento<Integer> memento = getMemento(generatorAsyncValuePosition.get(generator));
        return memento.getValue();
    }
}
