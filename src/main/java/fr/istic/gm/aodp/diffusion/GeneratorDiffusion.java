package fr.istic.gm.aodp.diffusion;

import fr.istic.gm.aodp.domain.Generator;
import fr.istic.gm.aodp.memento.Originator;

/**
 * The generator diffusion need to call get value from the diffusion
 */
public interface GeneratorDiffusion extends Generator, Originator<Integer> {

    /**
     * Retrieve the diffusion
     *
     * @return the diffusion
     */
    Diffusion getDiffusion();
}
