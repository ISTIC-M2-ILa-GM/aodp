package fr.istic.gm.aodp.diffusion;

import fr.istic.gm.aodp.domain.Generator;
import fr.istic.gm.aodp.memento.Originator;

public interface GeneratorDiffusion extends Generator, Originator<Integer> {

    Diffusion getDiffusion();
}
