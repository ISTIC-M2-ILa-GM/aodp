package fr.istic.gm.aodp.memento;

/**
 * The originator of the memento
 *
 * @param <T> the type of the memento
 */
public interface Originator<T> {

    /**
     * Save value to a memento
     *
     * @return the memento value
     */
    Memento<T> saveToMemento();

    /**
     * Restore the value from a memento
     *
     * @param memento the memento to restore
     */
    void restoreFromMemento(Memento<T> memento);
}
