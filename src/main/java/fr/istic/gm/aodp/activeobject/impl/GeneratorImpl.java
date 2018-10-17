package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.Generator;
import fr.istic.gm.aodp.activeobject.ObserverGenerator;
import fr.istic.gm.aodp.activeobject.TrueValueGenerator;
import fr.istic.gm.aodp.strategy.Diffusion;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * The generator implementation
 */
@RequiredArgsConstructor
public class GeneratorImpl implements Generator, TrueValueGenerator {

    private final Diffusion diffusion;

    private Integer value;

    @Getter
    private List<ObserverGenerator> observers = new ArrayList<>();

    @Override
    public void generate() {
        setValue((int) (Math.random() * 100));
    }

    @Override
    public void attach(ObserverGenerator observerGenerator) {
        observers.add(observerGenerator);
    }

    @Override
    public void detach(ObserverGenerator observerGenerator) {
        observers.remove(observerGenerator);
    }

    @Override
    public Integer getValue() {
        return diffusion.getValue(this);
    }

    @Override
    public Integer getTrueValue() {
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
