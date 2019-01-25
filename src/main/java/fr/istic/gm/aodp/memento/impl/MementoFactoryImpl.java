package fr.istic.gm.aodp.memento.impl;

import fr.istic.gm.aodp.memento.MementoFactory;

public class MementoFactoryImpl implements MementoFactory<Integer> {

    @Override
    public IntMemento create(Integer value) {
        return new IntMemento(value);
    }
}
