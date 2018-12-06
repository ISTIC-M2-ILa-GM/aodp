package fr.istic.gm.aodp.memento.impl;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class IntMementoTest {

    @Test
    public void shouldGetValue() {

        IntMemento intMemento = new IntMemento(5);

        assertThat(intMemento.getValue(), equalTo(5));
    }

    @Test
    public void shouldSetValue() {

        IntMemento intMemento = new IntMemento(5);

        intMemento.setValue(10);

        assertThat(intMemento.getValue(), equalTo(10));
    }
}
