package fr.istic.gm.aodp.diffusion;

import fr.istic.gm.aodp.activeobject.GeneratorAsync;

import java.util.List;
import java.util.concurrent.Future;

/**
 * The diffusion
 */
public interface Diffusion {

    /**
     * Execute the diffusion
     *
     * @param generator the generator to diffuse
     * @return the future
     */
    List<Future<?>> execute(GeneratorDiffusion generator);

    /**
     * Retrieve the generator value
     *
     * @param generator the generator
     * @return the value
     */
    Integer getValue(GeneratorAsync generator);
}
