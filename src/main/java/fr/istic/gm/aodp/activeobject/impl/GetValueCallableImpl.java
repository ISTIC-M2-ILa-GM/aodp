package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.activeobject.GetValueCallable;
import fr.istic.gm.aodp.diffusion.GeneratorDiffusion;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetValueCallableImpl implements GetValueCallable {
    private GeneratorAsync generatorAsync;

    private GeneratorDiffusion generator;

    @Override
    public Integer call() {
        return generator.getDiffusion().getValue(generatorAsync);
    }
}
