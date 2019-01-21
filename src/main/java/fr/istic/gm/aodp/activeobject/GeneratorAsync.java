package fr.istic.gm.aodp.activeobject;

import java.util.concurrent.Future;

/**
 * The generator async (GET VALUE Service)
 */
public interface GeneratorAsync {

    /**
     * Get the value async
     *
     * @return the future
     */
    Future<Integer> getValue();
}
