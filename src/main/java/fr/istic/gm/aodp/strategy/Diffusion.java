package fr.istic.gm.aodp.strategy;

import fr.istic.gm.aodp.activeobject.Generator;

public interface Diffusion {
    void execute(Generator generator);
    void verify();
    Integer getValue(Generator generator);
}
