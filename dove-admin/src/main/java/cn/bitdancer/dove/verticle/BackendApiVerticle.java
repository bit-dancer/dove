package cn.bitdancer.dove.verticle;

import cn.bitdancer.dove.common.constants.ApplicationConstant;
import cn.bitdancer.dove.common.constants.ConfigConstant;
import io.reactivex.Completable;
import io.vertx.core.Promise;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.ext.web.handler.BodyHandler;

/**
 * Description
 *
 * @author D.Yang
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public class BackendApiVerticle extends ApiVerticle {

    @Override
    public void start(Promise<Void> startFuture) throws Exception {
        Router router = Router.router(vertx);
        // Enable HTTP Body parse.
        router.route().handler(BodyHandler.create());
        // Enable CORS.
        enableCorsSupport(router);

//        router.get("").handler(this::handleGetTodo);
//        router.get("").handler(this::handleGetAll);
//        router.post("").handler(this::handleCreateTodo);
//        router.patch("").handler(this::handleUpdateTodo);
//        router.delete("").handler(this::handleDeleteOne);
//        router.delete("").handler(this::handleDeleteAll);

        String host = config().getString(ConfigConstant.HTTP_ADDRESS, ApplicationConstant.DEFAULT_HOST);
        int port = config().getInteger(ConfigConstant.HTTP_PORT, ApplicationConstant.DEFAULT_PORT);

        initService()
            .andThen(createHttpServer(router, host, port))
            .subscribe(startFuture::complete, startFuture::fail);
    }

    /**
     * 初始化服务
     *
     * @return Completable
     */
    private Completable initService() {
        return Completable.complete();
    }
}
