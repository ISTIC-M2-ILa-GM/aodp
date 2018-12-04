package fr.istic.gm.aodp;

import fr.istic.gm.aodp.domain.Generator;
import fr.istic.gm.aodp.activeobject.impl.GeneratorImpl;
import fr.istic.gm.aodp.diffusion.Diffusion;
import fr.istic.gm.aodp.diffusion.DiffusionException;
import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
public class GeneratorStarter implements Runnable {

    public static final String DIFFUSION_ERROR = "Diffusion can't be initialized";

    private Class<? extends Diffusion> diffusionClass;

    private int generateEachMs;

    public static CompletableFuture<Void> start(Class<? extends Diffusion> diffusionClass, int generateEachMs) {
        return CompletableFuture.runAsync(new GeneratorStarter(diffusionClass, generateEachMs));
    }

    @Override
    public void run() {
        try {
            Generator generator = new GeneratorImpl(diffusionClass.newInstance());
            while (true) {
                Thread.sleep(generateEachMs);
                generator.generate();
            }
        } catch (Exception e) {
            throw new DiffusionException(DIFFUSION_ERROR);
        }
    }
}
