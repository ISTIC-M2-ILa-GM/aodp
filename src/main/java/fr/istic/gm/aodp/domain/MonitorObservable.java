package fr.istic.gm.aodp.domain;

/**
 * The monitor observable
 */
public interface MonitorObservable {

    /**
     * Attach a monitor observer
     *
     * @param o the observer
     */
    void attach(MonitorObserver o);

    /**
     * Detach a monitor observer
     *
     * @param o the observer
     */
    void detach(MonitorObserver o);

    /**
     * Notify the observers
     *
     * @param value the value
     */
    void notifyObservers(Integer value);
}
