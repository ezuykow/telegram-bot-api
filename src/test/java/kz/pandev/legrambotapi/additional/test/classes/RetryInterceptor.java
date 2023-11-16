package kz.pandev.legrambotapi.additional.test.classes;

import com.google.gson.Gson;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.ResponseParameters;
import okhttp3.Interceptor;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * @author ezuykow
 */
public class RetryInterceptor implements Interceptor {

    private final int defaultSleepMillis;
    private final Gson gson = new Gson();

    public RetryInterceptor() {
        this(1000);
    }

    public RetryInterceptor(int defaultSleepMillis) {
        this.defaultSleepMillis = defaultSleepMillis;
    }

    @NotNull
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Exception exception = null;
        int retries = 3;
        while (retries-- > 0) {
            try {
                okhttp3.Response response = chain.proceed(request);
                if (response.isSuccessful()) {
                    return response;
                } else if (response.code() != 429) {
                    return response;
                } else {
                    Response baseResponse = gson.fromJson(response.body().string(), Response.class);
                    ResponseParameters params = baseResponse.getParameters();
                    int sleepTimeMillis;
                    if (params != null && params.getRetryAfter() != null) {
                        sleepTimeMillis = params.getRetryAfter() * 1000;
                    } else {
                        sleepTimeMillis = defaultSleepMillis;
                    }
                    System.err.println("++++ response " + response.code() + " sleep for " + sleepTimeMillis + " ms");
                    Thread.sleep(sleepTimeMillis);
                }
            } catch (Exception e) {
                exception = e;
                System.err.println("++++ exception " + e.getMessage());
                e.printStackTrace(System.err);
                try {
                    Thread.sleep(defaultSleepMillis);
                } catch (InterruptedException ignored) {}
            }
        }
        if (exception instanceof IOException) throw (IOException) exception;
        else if (exception != null) throw new RuntimeException(exception);
        else throw new RuntimeException("empty exception");
    }
}