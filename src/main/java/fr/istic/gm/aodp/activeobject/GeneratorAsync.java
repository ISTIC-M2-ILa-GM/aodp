package fr.istic.gm.aodp.activeobject;

import java.util.concurrent.Future;

/**
 * The generator async
 */
public interface GeneratorAsync {
    Future<Integer> getValue();
}
