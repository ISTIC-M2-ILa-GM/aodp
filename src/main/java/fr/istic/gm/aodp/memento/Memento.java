package fr.istic.gm.aodp.memento;

/**
 * The memento value
 *
 * @param <T> the type of the memento
 */
public interface Memento<T> {

    /**
     * Retrieve the memento value
     *
     * @return the value
     */
    T getValue();

    /**
     * Set the memento value
     *
     * @param value the value
     */
    void setValue(T value);
}
