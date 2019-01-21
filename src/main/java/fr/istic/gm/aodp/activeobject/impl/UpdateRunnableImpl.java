package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.ObserverGenerator;
import fr.istic.gm.aodp.activeobject.UpdateRunnable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateRunnableImpl implements UpdateRunnable {

    private Canal canal;

    private ObserverGenerator observerGenerator;

    @Override
    public void run() {
        observerGenerator.update(canal);
    }
}
