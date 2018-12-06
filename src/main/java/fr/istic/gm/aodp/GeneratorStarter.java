package fr.istic.gm.aodp;

import fr.istic.gm.aodp.activeobject.impl.GeneratorImpl;
import fr.istic.gm.aodp.diffusion.Diffusion;
import fr.istic.gm.aodp.diffusion.DiffusionException;
import fr.istic.gm.aodp.domain.Generator;
import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
public class GeneratorStarter implements Runnable {

    public static final String DIFFUSION_ERROR = "Diffusion can't be initialized";

    private Generator generator;

    private int generateEachMs;

    public static Generator start(Class<? extends Diffusion> diffusionClass, int generateEachMs) {

        try {
            Generator generator = new GeneratorImpl(diffusionClass.newInstance());
            CompletableFuture.runAsync(new GeneratorStarter(generator, generateEachMs));
            return generator;
        } catch (Exception e) {
            throw new DiffusionException(DIFFUSION_ERROR);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(generateEachMs);
                generator.generate();
            }
        } catch (Exception e) {
            throw new DiffusionException(DIFFUSION_ERROR);
        }
    }
}
