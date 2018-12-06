package fr.istic.gm.aodp.memento;

public interface Memento<T> {

    T getValue();

    void setValue(T value);
}
