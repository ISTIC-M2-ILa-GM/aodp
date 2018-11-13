package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.Generator;
import fr.istic.gm.aodp.activeobject.ObserverGenerator;
import fr.istic.gm.aodp.activeobject.UpdateCallable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateCallableImpl implements UpdateCallable {

    private Canal canal;

    private ObserverGenerator observerGenerator;

    @Override
    public Integer call() {
        observerGenerator.update(canal);
        return null;
    }
}
