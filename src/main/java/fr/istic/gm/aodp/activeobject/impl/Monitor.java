package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.activeobject.ObserverGenerator;

import java.util.concurrent.Future;

public class Monitor implements ObserverGenerator {
    @Override
    public void update(GeneratorAsync generatorAsync) {
        Future<Integer> value = generatorAsync.getValue();

    }
}
