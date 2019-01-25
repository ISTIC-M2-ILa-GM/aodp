package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.activeobject.ObserverGeneratorAsync;
import fr.istic.gm.aodp.diffusion.Diffusion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GeneratorImplTest {

    private GeneratorImpl generator;

    @Mock
    private Diffusion mockDiffusion;

    @Mock
    private ObserverGeneratorAsync mockObserverGeneratorAsync;

    @Mock
    private GeneratorAsync mockGeneratorAsync;

    @Mock
    private Random mockRandom;

    @Before
    public void setUp() {
        generator = new GeneratorImpl(mockDiffusion);
        generator.setRandom(mockRandom);
    }

    @Test
    public void shouldGenerateAValue() {

        when(mockRandom.nextInt(anyInt())).thenReturn(10);

        generator.generate();

        verify(mockRandom).nextInt(100);

        assertThat(generator.getValue(), notNullValue());
        assertThat(generator.getValue(), equalTo(10));
    }

    @Test
    public void shouldExecuteTheDiffusion() {

        generator.generate();

        verify(mockDiffusion).execute(generator);
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
}
