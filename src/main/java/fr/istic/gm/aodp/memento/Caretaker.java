package fr.istic.gm.aodp.memento;

public interface Caretaker<T> {

    void addMemento(Memento<T> memento);

    Memento<T> getMemento(int index);

    int mementoSize();
}
