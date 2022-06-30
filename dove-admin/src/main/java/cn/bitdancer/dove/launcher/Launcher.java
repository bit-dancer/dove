package cn.bitdancer.dove.launcher;


import io.vertx.reactivex.core.Vertx;

import java.util.function.Consumer;

/**
 * Launcher Interface
 *
 * @author D.Yang
 */
public interface Launcher {
    /**
     * Launcher Start Function
     *
     * @param consumer option
     */
    void start(Consumer<Vertx> consumer);
}
