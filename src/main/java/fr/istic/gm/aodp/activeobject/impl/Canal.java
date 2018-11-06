package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.Generator;
import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.activeobject.ObserverGeneratorAsync;

import java.util.concurrent.Future;

public class Canal implements GeneratorAsync, ObserverGeneratorAsync {
    public Future<Integer> update(Generator generator) {
        return null;
    }
}
