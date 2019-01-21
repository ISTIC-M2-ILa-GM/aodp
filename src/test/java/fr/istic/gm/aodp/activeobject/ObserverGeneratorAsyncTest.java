package fr.istic.gm.aodp.activeobject;

import fr.istic.gm.aodp.activeobject.impl.Canal;
import fr.istic.gm.aodp.diffusion.GeneratorDiffusion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ObserverGeneratorAsyncTest {

    private ObserverGeneratorAsync observerGeneratorAsync;

    @Mock
    private ObserverGenerator mockObserverGenerator;

    @Mock
    private GeneratorDiffusion mockGenerator;

    @Mock
    private ScheduledExecutorService mockScheduledExecutorService;

    @Mock
    private ScheduledFuture<Integer> mockFuture;

    @Before
    public void setUp() {
        observerGeneratorAsync = new Canal(mockObserverGenerator, mockScheduledExecutorService, 10L);
    }

    @Test
    public void shouldUpdateTheCanal() {

        when(mockScheduledExecutorService.schedule(any(UpdateCallable.class), anyLong(), any(TimeUnit.class))).thenReturn(mockFuture);

        Future<Integer> result = observerGeneratorAsync.update(mockGenerator);

        verify(mockScheduledExecutorService).schedule(any(UpdateCallable.class), eq(10L), eq(TimeUnit.MILLISECONDS));

        assertThat(result, equalTo(mockFuture));
    }
}
