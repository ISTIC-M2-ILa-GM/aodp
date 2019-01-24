package fr.istic.gm.aodp.activeobject;

import fr.istic.gm.aodp.diffusion.GeneratorDiffusion;

import java.util.concurrent.Future;

/**
 * The Observer Generator Async (UPDATE Service)
 */
public interface ObserverGeneratorAsync {

    /**
     * Update the observer async
     *
     * @param generator the generator observed
     * @return the future
     */
    Future<?> update(GeneratorDiffusion generator);
}
