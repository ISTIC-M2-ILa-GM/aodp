package fr.istic.gm.aodp.activeobject;

import fr.istic.gm.aodp.activeobject.impl.GeneratorImpl;
import fr.istic.gm.aodp.strategy.Diffusion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
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

    @Mock
    private ObserverGeneratorAsync mockObserverGeneratorAsync;

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

        generator.attach(mockObserverGeneratorAsync);

        assertThat(generator.getObservers(), hasSize(1));

        assertThat(generator.getObservers().get(0), equalTo(mockObserverGeneratorAsync));
    }

    @Test
    public void shouldRemoveAnObserver() {

        generator.attach(mockObserverGeneratorAsync);
        generator.detach(mockObserverGeneratorAsync);

        assertThat(generator.getObservers(), hasSize(0));
    }

    @Test
    public void shouldGetDiffusionValue() {

        generator.getValue();

        verify(mockDiffusion).getValue(generator);
    }
}
