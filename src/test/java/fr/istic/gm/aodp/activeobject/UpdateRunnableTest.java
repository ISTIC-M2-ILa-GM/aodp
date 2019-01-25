package fr.istic.gm.aodp.activeobject;

import fr.istic.gm.aodp.activeobject.impl.Canal;
import fr.istic.gm.aodp.activeobject.impl.UpdateRunnableImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UpdateRunnableTest {

    private UpdateRunnable updateRunnable;

    @Mock
    private Canal mockCanal;

    @Mock
    private ObserverGenerator mockObserverGenerator;

    @Before
    public void setUp() {
        updateRunnable = new UpdateRunnableImpl(mockCanal, mockObserverGenerator);
    }

    @Test
    public void shouldUpdateAMonitor() throws Exception {

        updateRunnable.run();

        verify(mockObserverGenerator).update(mockCanal);
    }
}
