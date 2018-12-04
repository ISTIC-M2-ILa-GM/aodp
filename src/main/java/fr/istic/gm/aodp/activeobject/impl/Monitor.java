package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.activeobject.Observable;
import fr.istic.gm.aodp.activeobject.Observer;
import fr.istic.gm.aodp.activeobject.ObserverGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class Monitor implements ObserverGenerator, Observable {
    private List<Observer> observerList;

    public Monitor() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void update(GeneratorAsync generatorAsync) {
        Future<Integer> value = generatorAsync.getValue();
    }

    @Override
    public void attach(Observer o) {
        this.observerList.add(o);
    }

    @Override
    public void detach(Observer o) {
        this.observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        this.observerList.forEach(o -> {
//            o.update();
        });
    }
}
