package fr.istic.gm.aodp.activeobject;

/**
 * The Observer Generator (UPDATE Servant)
 */
public interface ObserverGenerator {

    /**
     * Update the observer
     *
     * @param generator the generator observed
     */
    void update(Generator generator);
}
