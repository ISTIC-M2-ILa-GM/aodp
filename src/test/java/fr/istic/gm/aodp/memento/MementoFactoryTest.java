package fr.istic.gm.aodp.memento;

import fr.istic.gm.aodp.memento.impl.MementoFactoryImpl;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class MementoFactoryTest {

    private MementoFactory<Integer> mementoFactory;

    @Before
    public void setUp() {
        mementoFactory = new MementoFactoryImpl();
    }

    @Test
    public void shouldCreateANewMemento() {

        Memento<Integer> memento = mementoFactory.create(10);

        assertThat(memento, notNullValue());
        assertThat(memento.getValue(), equalTo(10));
    }
}
