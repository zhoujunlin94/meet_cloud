package io.github.zhoujunlin94.cloud.consumer.feign.fallback;

import io.github.zhoujunlin94.cloud.consumer.feign.client.ProviderDemo01Client;
import io.github.zhoujunlin94.meet.common.pojo.JsonResponse;

/**
 * @author zhoujunlin
 * @date 2023年02月25日 12:41
 * @desc
 */
public class ProviderDemo01ClientFallback implements ProviderDemo01Client {

    private Throwable throwable;
    private JsonResponse fallbackResp;

    public ProviderDemo01ClientFallback(Throwable throwable) {
        this.throwable = throwable;
        this.fallbackResp = JsonResponse.fail("fallback:" + throwable.getClass().getSimpleName());
    }

    @Override
    public JsonResponse echo(String msg) {
        return this.fallbackResp;
    }

    @Override
    public JsonResponse test() {
        return this.fallbackResp;
    }

    @Override
    public String echoName(String name) {
        return this.fallbackResp.getMsg();
    }
}
