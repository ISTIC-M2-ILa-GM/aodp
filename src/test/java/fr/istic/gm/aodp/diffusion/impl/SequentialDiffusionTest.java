package fr.istic.gm.aodp.diffusion.impl;

import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.activeobject.impl.Canal;
import fr.istic.gm.aodp.diffusion.GeneratorDiffusion;
import fr.istic.gm.aodp.memento.MementoFactory;
import fr.istic.gm.aodp.memento.impl.IntMemento;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SequentialDiffusionTest {

    private SequentialDiffusion sequentialDiffusion;

    @Mock
    private Canal mockCanal;

    @Mock
    private GeneratorDiffusion mockGenerator;

    @Mock
    private Future<Integer> mockFuture;

    @Mock
    private GeneratorAsync mockGeneratorAsync;

    @Mock
    private MementoFactory<Integer> mockMementoFactory;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        sequentialDiffusion = new SequentialDiffusion(mockMementoFactory);
    }

    @Test
    public void shouldExecuteDiffusion() {

        when(mockGenerator.getObservers()).thenReturn(Collections.singletonList(mockCanal));
        when(mockCanal.update(any())).thenReturn(mockFuture);
        when(mockGenerator.getValue()).thenReturn(10);
        when(mockMementoFactory.create(any())).thenReturn(new IntMemento(10));

        List<Future<Integer>> result = sequentialDiffusion.execute(mockGenerator);

        verify(mockMementoFactory).create(10);
        verify(mockCanal).update(mockGenerator);

        assertThat(result, notNullValue());
        assertThat(result, hasSize(1));
        assertThat(result.get(0), equalTo(mockFuture));
    }

    @Test
    public void shouldAddGeneratorAsyncWhenGetValue() {

        when(mockMementoFactory.create(any())).thenReturn(new IntMemento(10));
        sequentialDiffusion.execute(mockGenerator);

        sequentialDiffusion.getValue(mockGeneratorAsync);

        assertThat(sequentialDiffusion.getGeneratorAsyncValuePosition().get(mockGeneratorAsync), equalTo(0));
    }

    @Test
    public void shouldIncGeneratorAsyncWhenGetValue() {

        when(mockMementoFactory.create(any())).thenReturn(new IntMemento(10));
        sequentialDiffusion.execute(mockGenerator);
        sequentialDiffusion.execute(mockGenerator);
        sequentialDiffusion.execute(mockGenerator);
        sequentialDiffusion.execute(mockGenerator);

        sequentialDiffusion.getGeneratorAsyncValuePosition().put(mockGeneratorAsync, 2);

        sequentialDiffusion.getValue(mockGeneratorAsync);

        assertThat(sequentialDiffusion.getGeneratorAsyncValuePosition().get(mockGeneratorAsync), equalTo(3));
    }

    @Test
    public void shouldNotIncGeneratorAsyncWhenGetLastValue() {

        when(mockMementoFactory.create(any())).thenReturn(new IntMemento(10), new IntMemento(11), new IntMemento(12), new IntMemento(13), new IntMemento(14));
        sequentialDiffusion.execute(mockGenerator);
        sequentialDiffusion.execute(mockGenerator);
        sequentialDiffusion.execute(mockGenerator);
        sequentialDiffusion.execute(mockGenerator);

        sequentialDiffusion.getGeneratorAsyncValuePosition().put(mockGeneratorAsync, 3);

        Integer value = sequentialDiffusion.getValue(mockGeneratorAsync);

        assertThat(sequentialDiffusion.getGeneratorAsyncValuePosition().get(mockGeneratorAsync), equalTo(3));
        assertThat(value, equalTo(13));
    }

    @Test
    public void shouldGetValueFromMemento() {

        when(mockMementoFactory.create(any())).thenReturn(new IntMemento(10));
        sequentialDiffusion.execute(mockGenerator);

        Integer value = sequentialDiffusion.getValue(mockGeneratorAsync);

        assertThat(value, equalTo(10));
    }
}
