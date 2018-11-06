package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.Generator;
import fr.istic.gm.aodp.activeobject.ObserverGenerator;
import fr.istic.gm.aodp.activeobject.UpdateCallable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateCallableImpl implements UpdateCallable {

    private Generator generator;

    private ObserverGenerator observerGenerator;

    @Override
    public Integer call() {
        observerGenerator.update(generator);
        return null;
    }
}
