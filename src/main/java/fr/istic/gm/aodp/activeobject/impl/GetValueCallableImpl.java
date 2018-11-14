package fr.istic.gm.aodp.activeobject.impl;

import fr.istic.gm.aodp.activeobject.Generator;
import fr.istic.gm.aodp.activeobject.GeneratorAsync;
import fr.istic.gm.aodp.activeobject.GetValueCallable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetValueCallableImpl implements GetValueCallable {
    private GeneratorAsync generatorAsync;

    private Generator generator;

    @Override
    public Integer call() {
        return generator.getValue(generatorAsync);
    }
}
