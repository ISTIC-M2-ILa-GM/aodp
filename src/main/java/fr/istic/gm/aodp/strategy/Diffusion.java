package fr.istic.gm.aodp.strategy;

import fr.istic.gm.aodp.activeobject.Generator;
import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.activeobject.TrueValueGenerator;

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
    List<Future<Integer>> execute(TrueValueGenerator generator);

    /**
     * Verify the diffusion
     */
    void verify();

    /**
     * Retrieve the generator value
     *
     * @param generator the generator
     * @return the value
     */
    Integer getValue(GeneratorAsync generator);
}
