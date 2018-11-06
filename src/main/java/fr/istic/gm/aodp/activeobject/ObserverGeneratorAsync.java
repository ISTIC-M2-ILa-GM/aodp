package fr.istic.gm.aodp.activeobject;

import java.util.concurrent.Future;

public interface ObserverGeneratorAsync {
    Future<Integer> update(Generator generator);
}
