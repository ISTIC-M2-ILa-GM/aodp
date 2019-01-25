package fr.istic.gm.aodp.memento.impl;

import fr.istic.gm.aodp.memento.Caretaker;
import fr.istic.gm.aodp.memento.Memento;

import java.util.ArrayList;
import java.util.List;

public abstract class CaretakerImpl<T> implements Caretaker<T> {

    private List<Memento<T>> mementos = new ArrayList<>();

    @Override
    public void addMemento(Memento<T> memento) {
        mementos.add(memento);
    }

    @Override
    public Memento<T> getMemento(int index) {
        return mementos.get(index);
    }

    @Override
    public int mementoSize() {
        return mementos.size();
    }
}
