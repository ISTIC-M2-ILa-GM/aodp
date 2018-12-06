package fr.istic.gm.aodp.memento;

public interface MementoFactory<T> {

    Memento<T> create(T value);
}
