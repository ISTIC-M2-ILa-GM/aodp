package fr.istic.gm.aodp.diffusion.impl;

import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.activeobject.impl.Canal;
import fr.istic.gm.aodp.diffusion.DiffusionException;
import fr.istic.gm.aodp.diffusion.GeneratorDiffusion;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AtomicDiffusionTest {

    private AtomicDiffusion atomicDiffusion;

    @Mock
    private Canal mockCanal;

    @Mock
    private GeneratorDiffusion mockGenerator;

    @Mock
    private Future<Integer> mockFuture;

    @Mock
    private GeneratorAsync mockGeneratorAsync;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        atomicDiffusion = new AtomicDiffusion();
    }

    @Test
    public void shouldExecuteAtomicDiffusion() {

        when(mockGenerator.getObservers()).thenReturn(Collections.singletonList(mockCanal));
        when(mockCanal.update(any())).thenReturn(mockFuture);
        when(mockGenerator.getValue()).thenReturn(10);

        List<Future<Integer>> result = atomicDiffusion.execute(mockGenerator);

        verify(mockCanal).update(mockGenerator);

        assertThat(result, notNullValue());
        assertThat(result, hasSize(1));
        assertThat(result.get(0), equalTo(mockFuture));
        assertThat(atomicDiffusion.getGeneratorAsyncs(), notNullValue());
        assertThat(atomicDiffusion.getGeneratorAsyncs(), empty());
        assertThat(atomicDiffusion.getObserverNumber(), equalTo(1));
        assertThat(atomicDiffusion.getValue(null), equalTo(10));
    }

    @Test
    public void shouldThrowExceptionWhenVerifyWithoutAllGeneratorAsyncsGetValue() {

        atomicDiffusion.setGeneratorAsyncs(new ArrayList<>());
        atomicDiffusion.setObserverNumber(3);

        thrown.expect(DiffusionException.class);
        thrown.expectMessage(AtomicDiffusion.FORBIDDEN);

        atomicDiffusion.verify();
    }

    @Test
    public void shouldNotThrowExceptionWhenVerifyWithNullGeneratorAsyncs() {

        atomicDiffusion.setGeneratorAsyncs(null);

        atomicDiffusion.verify();
    }

    @Test
    public void shouldNotThrowExceptionWhenVerifyWithAFullGeneratorAsyncs() {

        atomicDiffusion.setGeneratorAsyncs(Arrays.asList(mockGeneratorAsync, mockGeneratorAsync, mockGeneratorAsync));
        atomicDiffusion.setObserverNumber(3);

        atomicDiffusion.verify();
    }

    @Test
    public void shouldAddGeneratorAsyncWhenGetValue() {

        atomicDiffusion.setGeneratorAsyncs(new ArrayList<>());

        atomicDiffusion.getValue(mockGeneratorAsync);

        assertThat(atomicDiffusion.getGeneratorAsyncs(), hasSize(1));
        assertThat(atomicDiffusion.getGeneratorAsyncs().get(0), equalTo(mockGeneratorAsync));
    }

    @Test
    public void shouldNotAddGeneratorAsyncWhenGetValueWithAlreadyGeneratorAsyncAdd() {

        atomicDiffusion.setGeneratorAsyncs(new ArrayList<>());
        atomicDiffusion.getGeneratorAsyncs().add(mockGeneratorAsync);

        atomicDiffusion.getValue(mockGeneratorAsync);

        assertThat(atomicDiffusion.getGeneratorAsyncs(), hasSize(1));
        assertThat(atomicDiffusion.getGeneratorAsyncs().get(0), equalTo(mockGeneratorAsync));
    }
}
