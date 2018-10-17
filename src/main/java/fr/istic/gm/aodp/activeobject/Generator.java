package fr.istic.gm.aodp.activeobject;

import java.util.List;

/**
 * The generator
 */
public interface Generator {

    /**
     * Generate a Value
     */
    void generate();

    /**
     * Get value
     *
     * @return the value
     */
    Integer getValue();

    /**
     * Get the list of observers
     *
     * @return the observers
     */
    List<ObserverGenerator> getObservers();

    /**
     * Attach an observer
     *
     * @param observerGenerator the observer
     */
    void attach(ObserverGenerator observerGenerator);

    /**
     * Attach an observer
     *
     * @param observerGenerator the observer
     */
    void detach(ObserverGenerator observerGenerator);
}
