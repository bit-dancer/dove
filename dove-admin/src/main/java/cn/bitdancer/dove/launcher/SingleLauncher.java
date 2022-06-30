package cn.bitdancer.dove.launcher;


import io.vertx.core.VertxOptions;
import io.vertx.reactivex.core.Vertx;

import java.util.function.Consumer;

/**
 * Singleton Launcher
 *
 * @author D.Yang
 */
public class SingleLauncher implements Launcher {
    @Override
    public void start(Consumer<Vertx> consumer) {
        final VertxOptions options = new VertxOptions();
        final Vertx vertx = Vertx.vertx(options);
        if (null != vertx) {
            consumer.accept(vertx);
        }
    }
}
