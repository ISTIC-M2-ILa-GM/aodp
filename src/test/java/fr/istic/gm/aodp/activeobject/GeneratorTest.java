package fr.istic.gm.aodp.activeobject;

import fr.istic.gm.aodp.activeobject.impl.Canal;
import fr.istic.gm.aodp.activeobject.impl.GeneratorImpl;
import fr.istic.gm.aodp.activeobject.impl.Monitor;
import fr.istic.gm.aodp.strategy.Diffusion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GeneratorTest {

    private Generator generator;

    @Mock
    private Diffusion mockDiffusion;

    @Before
    public void setUp() {
        generator = new GeneratorImpl(mockDiffusion);
    }

    @Test
    public void shouldGenerateAValue() {

        TrueValueGenerator trueValueGenerator = (TrueValueGenerator) generator;

        assertThat(trueValueGenerator.getTrueValue(), nullValue());

        generator.generate();

        assertThat(trueValueGenerator.getTrueValue(), notNullValue());
    }

    @Test
    public void shouldExecuteTheDiffusion() {

        generator.generate();

        verify(mockDiffusion).execute(generator);
    }

    @Test
    public void shouldVerifyTheDiffusion() {

        generator.generate();

        verify(mockDiffusion).verify();
    }

    @Test
    public void shouldAddAnObserver() {

        ObserverGenerator observerGenerator = new Monitor();

        generator.attach(observerGenerator);

        assertThat(generator.getObservers(), hasSize(1));
    }

    @Test
    public void shouldRemoveAnObserver() {

        ObserverGenerator observerGenerator = new Monitor();

        generator.attach(observerGenerator);
        generator.detach(observerGenerator);

        assertThat(generator.getObservers(), hasSize(0));
    }

    @Test
    public void shouldGetDiffusionValue() {

        generator.getValue();

        verify(mockDiffusion).getValue(generator);
    }
}
