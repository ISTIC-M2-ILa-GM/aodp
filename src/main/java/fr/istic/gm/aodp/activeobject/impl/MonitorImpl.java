package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.domain.Monitor;
import fr.istic.gm.aodp.domain.MonitorObserver;
import fr.istic.gm.aodp.enums.ChartIdentifier;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@RequiredArgsConstructor
public class MonitorImpl implements Monitor {
    private List<MonitorObserver> monitorObserverList = new ArrayList<>();

    private final ChartIdentifier chartIdentifier;

    @Override
    public void update(GeneratorAsync generatorAsync) {
        Future<Integer> value = generatorAsync.getValue();
        try {
            this.notifyObservers(value.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public void notifyObservers(Integer i) {
        this.monitorObserverList.forEach(o -> o.update(this.chartIdentifier, i));
    }
}
