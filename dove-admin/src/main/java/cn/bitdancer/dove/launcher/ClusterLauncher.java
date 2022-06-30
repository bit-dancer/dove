package cn.bitdancer.dove.launcher;

import io.vertx.core.VertxOptions;
import io.vertx.reactivex.core.Vertx;

import java.util.function.Consumer;

/**
 * Cluster Launcher
 *
 * @author D.Yang
 */
public class ClusterLauncher implements Launcher {
    @Override
    public void start(Consumer<Vertx> consumer) {
        final VertxOptions options = new VertxOptions();
        Vertx.rxClusteredVertx(options)
            .doOnSuccess(consumer::accept)
            .doOnError(error -> {
                if (null != error) {
                    error.printStackTrace();
                }
            }).subscribe();
        ;
    }
}
