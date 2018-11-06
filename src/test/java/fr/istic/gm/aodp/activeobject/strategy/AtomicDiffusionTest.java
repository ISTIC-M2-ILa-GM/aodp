package fr.istic.gm.aodp.activeobject.strategy;

import fr.istic.gm.aodp.activeobject.Generator;
import fr.istic.gm.aodp.activeobject.impl.Canal;
import fr.istic.gm.aodp.strategy.impl.AtomicDiffusion;
import org.junit.Before;
import org.junit.Test;
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
public class AtomicDiffusionTest {

    private AtomicDiffusion atomicDiffusion;

    @Mock
    private Canal mockCanal;

    @Mock
    private Generator mockGenerator;

    @Mock
    private Future<Integer> mockFuture;

    @Before
    public void setUp() {
        atomicDiffusion = new AtomicDiffusion();
    }

    @Test
    public void shouldExecuteAtomicDiffusion() {

        when(mockGenerator.getObservers()).thenReturn(Collections.singletonList(mockCanal));
        when(mockCanal.update(any())).thenReturn(mockFuture);

        List<Future<Integer>> result = atomicDiffusion.execute(mockGenerator);

        verify(mockCanal).update(mockGenerator);

        assertThat(result, notNullValue());
        assertThat(result, hasSize(1));
        assertThat(result.get(0), equalTo(mockFuture));
    }
}
