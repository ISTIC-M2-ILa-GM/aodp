package fr.istic.gm.aodp.memento;

/**
 * The caretaker
 *
 * @param <T> The type of the memento
 */
public interface Caretaker<T> {

    /**
     * Add a new memento
     *
     * @param memento the memento to add
     */
    void addMemento(Memento<T> memento);

    /**
     * Get a memento
     *
     * @param index the index of the memento to get
     * @return the memento
     */
    Memento<T> getMemento(int index);

    /**
     * The number of memento
     *
     * @return memento's size
     */
    int mementoSize();
}
