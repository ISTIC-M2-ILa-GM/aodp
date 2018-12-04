package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.domain.Monitor;
import fr.istic.gm.aodp.domain.MonitorObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class MonitorImpl implements Monitor {
    private List<MonitorObserver> monitorObserverList;

    public MonitorImpl() {
        this.monitorObserverList = new ArrayList<>();
    }

    @Override
    public void update(GeneratorAsync generatorAsync) {
        Future<Integer> value = generatorAsync.getValue();
    }

    @Override
    public void attach(MonitorObserver o) {
        this.monitorObserverList.add(o);
    }

    @Override
    public void detach(MonitorObserver o) {
        this.monitorObserverList.remove(o);
    }

    @Override
    public void notifyObservers() {
        this.monitorObserverList.forEach(o -> {
//            o.update();
        });
    }
}
