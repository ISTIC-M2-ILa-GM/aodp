package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.ObserverGeneratorAsync;
import fr.istic.gm.aodp.diffusion.Diffusion;
import fr.istic.gm.aodp.diffusion.GeneratorDiffusion;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * The generator implementation
 */
@RequiredArgsConstructor
public class GeneratorImpl implements GeneratorDiffusion {

    @Getter
    private final Diffusion diffusion;

    private Integer value;

    @Getter
    private List<ObserverGeneratorAsync> observers = new ArrayList<>();

    @Override
    public void generate() {
        setValue((int) (Math.random() * 100));
    }

    @Override
    public void attach(ObserverGeneratorAsync observerGenerator) {
        observers.add(observerGenerator);
    }

    @Override
    public void detach(ObserverGeneratorAsync observerGenerator) {
        observers.remove(observerGenerator);
    }

    @Override
    public Integer getValue() {
        return value;
    }

    /**
     * Set the value
     *
     * @param value the value
     */
    private void setValue(Integer value) {
        diffusion.verify();
        this.value = value;
        diffusion.execute(this);
    }
}
