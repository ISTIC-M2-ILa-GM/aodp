package fr.istic.gm.aodp.domain;

public interface MonitorObservable {
    void attach(MonitorObserver o);
    void detach(MonitorObserver o);
    void notifyObservers();
}
