package fr.istic.gm.aodp.memento;

public interface Originator<T> {
    Memento<T> saveToMemento();

    void restoreFromMemento(Memento<T> memento);
}
