package fr.istic.gm.aodp.memento;

import fr.istic.gm.aodp.diffusion.impl.SequentialDiffusion;
import fr.istic.gm.aodp.memento.impl.CaretakerImpl;
import fr.istic.gm.aodp.memento.impl.IntMemento;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CaretakerTest {

    private CaretakerImpl<Integer> caretaker;

    @Before
    public void setUp() {
        caretaker = new SequentialDiffusion(null);
    }

    @Test
    public void shouldAddMementoAndGetMemento() {

        IntMemento memento1 = new IntMemento(10);
        IntMemento memento2 = new IntMemento(5);

        caretaker.addMemento(memento1);
        caretaker.addMemento(memento2);

        assertThat(caretaker.getMemento(0), equalTo(memento1));
        assertThat(caretaker.getMemento(1), equalTo(memento2));
    }
}
