package cn.bitdancer.dove;

import cn.bitdancer.dove.launcher.Launcher;
import cn.bitdancer.dove.launcher.SingleLauncher;
import cn.bitdancer.dove.verticle.BackendApiVerticle;

/**
 * Main Launcher
 *
 * @author D.Yang
 */
public class MainLauncher {

    public static void main(String[] args) {
        final Launcher launcher = new SingleLauncher();
        launcher.start(vertx -> {
            vertx.deployVerticle(BackendApiVerticle.class.getName());
        });
    }

}
