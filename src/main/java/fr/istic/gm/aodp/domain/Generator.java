package fr.istic.gm.aodp.domain;

import fr.istic.gm.aodp.activeobject.ObserverGeneratorAsync;

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
    List<ObserverGeneratorAsync> getObservers();

    /**
     * Attach an observer
     *
     * @param observerGenerator the observer
     */
    void attach(ObserverGeneratorAsync observerGenerator);

    /**
     * Attach an observer
     *
     * @param observerGenerator the observer
     */
    void detach(ObserverGeneratorAsync observerGenerator);
}
