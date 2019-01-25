package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.ObserverGeneratorAsync;
import fr.istic.gm.aodp.diffusion.Diffusion;
import fr.istic.gm.aodp.diffusion.GeneratorDiffusion;
import fr.istic.gm.aodp.memento.Memento;
import fr.istic.gm.aodp.memento.impl.IntMemento;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The generator implementation
 */
@RequiredArgsConstructor
public class GeneratorImpl implements GeneratorDiffusion {

    @Getter
    private final Diffusion diffusion;

    @Getter
    private Integer value;

    @Getter
    private List<ObserverGeneratorAsync> observers = new ArrayList<>();

    @Setter(AccessLevel.PACKAGE)
    private Random random = new Random();

    @Override
    public void generate() {
        setValue(random.nextInt(100));
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
    public Memento<Integer> saveToMemento() {
        return new IntMemento(value);
    }

    @Override
    public void restoreFromMemento(Memento<Integer> memento) {
        setValue(memento.getValue());
    }

    /**
     * Set the value
     *
     * @param value the value
     */
    private void setValue(Integer value) {
        this.value = value;
        diffusion.execute(this);
    }
}
