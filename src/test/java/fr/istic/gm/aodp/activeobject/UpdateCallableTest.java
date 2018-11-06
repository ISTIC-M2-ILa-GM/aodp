package fr.istic.gm.aodp.activeobject;

import fr.istic.gm.aodp.activeobject.impl.UpdateCallableImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UpdateCallableTest {

    private UpdateCallable updateCallable;

    @Mock
    private Generator mockGenerator;

    @Mock
    private ObserverGenerator mockObserverGenerator;

    @Before
    public void setUp() {
        updateCallable = new UpdateCallableImpl(mockGenerator, mockObserverGenerator);
    }

    @Test
    public void shouldUpdateAMonitor() throws Exception {

        updateCallable.call();

        verify(mockObserverGenerator).update(mockGenerator);
    }
}
