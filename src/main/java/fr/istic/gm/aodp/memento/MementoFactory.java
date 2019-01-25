package fr.istic.gm.aodp.memento;

/**
 * The memento factory
 *
 * @param <T> the type of memento
 */
public interface MementoFactory<T> {

    /**
     * Create a new memento
     *
     * @param value the value of the memento
     * @return the new memento
     */
    Memento<T> create(T value);
}
