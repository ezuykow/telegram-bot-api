package kz.pandev.legrambotapi.configure.api;

import com.google.gson.Gson;
import kz.pandev.legrambotapi.exceptions.EmptyTelegramResponseException;
import kz.pandev.legrambotapi.exceptions.RequestExecutionException;
import kz.pandev.legrambotapi.configure.Callback;
import kz.pandev.legrambotapi.models.temp.Cancellable;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.types.input.InputFile;
import kz.pandev.legrambotapi.models.responses.Response;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Telegram bot API server client
 * @author ezuykow
 */
@SuppressWarnings("unused") /*Unused methods warning*/
public class TelegramBotClient {

    /**
     * Http client
     */
    private final OkHttpClient okHttpClient;
    /**
     * Converter of objects to json and vice versa
     */
    private final Gson gson;
    /**
     * URL to telegram bot api server with prefix "/bot&lt;token&gt;/"
     */
    private final String botUrl;
    /**
     * Http client with read timeout
     */
    private OkHttpClient okHttpClientWithTimeout;

    public TelegramBotClient(OkHttpClient client, Gson gson, String botUrl) {
        this.okHttpClient = client;
        this.gson = gson;
        this.botUrl = botUrl;
    }

    //region API

    /**
     * Send request to telegram bot api server with custom callback
     * @param request request to send
     * @param callback custom callback
     * @return {@link Call} with request as {@link Cancellable}
     */
    public <T extends Request<T, R>, R extends Response> Cancellable send(final T request, final Callback<T, R> callback) {
        OkHttpClient client = choseOkHttpClient(request);

        Call call = client.newCall(createHttpRequest(request));

        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull okhttp3.Response response) {
                R result = null;
                Exception exception = null;
                try {
                    if (response.body() == null) {
                        throw new EmptyTelegramResponseException();
                    }
                    result = gson.fromJson(response.body().string(), request.getResponseClass());
                } catch (Exception e) {
                    exception = e;
                }
                if (result != null) {
                    callback.onResponse(request, result);
                } else if (exception != null) {
                    callback.onFailure(request, new RequestExecutionException(exception));
                } else {
                    callback.onFailure(request, new EmptyTelegramResponseException());
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callback.onFailure(request, e);
            }
        });

        return call::cancel;
    }

    /**
     * Send request to telegram bot api server
     * @param request request to send
     * @return server response extending {@link Response}
     */
    public <T extends Request<T, R>, R extends Response> R send(final Request<T, R> request) {
        OkHttpClient client = choseOkHttpClient(request);
        try (okhttp3.Response response = client.newCall(createHttpRequest(request)).execute()) {
            if (response.body() == null) {
                throw new EmptyTelegramResponseException();
            }
            return gson.fromJson(response.body().string(), request.getResponseClass());
        } catch (Exception e) {
            throw new RequestExecutionException(e);
        }
    }

    /**
     * Shutdown {@link TelegramBotClient#okHttpClient} and {@link TelegramBotClient#okHttpClientWithTimeout}
     */
    public void shutdown() {
        okHttpClient.dispatcher().executorService().shutdown();
        if (okHttpClientWithTimeout != null) {
            okHttpClientWithTimeout.dispatcher().executorService().shutdown();
        }
    }


    //endregion
    //region Utils

    private OkHttpClient choseOkHttpClient(Request<?, ?> request) {
        int timeout = request.getTimeout() * 1_000;

        if (okHttpClient.readTimeoutMillis() >= timeout) {
            return okHttpClient;
        }
        if (okHttpClientWithTimeout != null && okHttpClientWithTimeout.readTimeoutMillis() >= timeout) {
            return okHttpClientWithTimeout;
        }

        okHttpClientWithTimeout = okHttpClient.newBuilder().readTimeout(timeout, TimeUnit.MILLISECONDS).build();
        return okHttpClientWithTimeout;
    }

    private okhttp3.Request createHttpRequest(Request<?, ?> request) {
        return new okhttp3.Request.Builder()
                .url(botUrl + request.getMethodName())
                .post(createRequestBody(request))
                .build();
    }

    private RequestBody createRequestBody(Request<?, ?> request) {
        if (request.isMultipart()) {
            return createMultiPartRequestBody(request);
        }

        FormBody.Builder bodyBuilder = new FormBody.Builder();
        for (Map.Entry<String, Object> param : request.getParameters().entrySet()) {
            bodyBuilder.add(param.getKey(), mapObjectToParamValue(param.getValue()));
        }
        return bodyBuilder.build();
    }

    private RequestBody createMultiPartRequestBody(Request<?, ?> request) {
        MediaType contentType = MediaType.parse(request.getContentMimeType());

        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (Map.Entry<String, Object> param : request.getParameters().entrySet()) {
            String name = param.getKey();
            Object value = param.getValue();

            if (value instanceof byte[] v) {
                bodyBuilder.addFormDataPart(name, request.getFileName(), RequestBody.create(v, contentType));
            } else if (value instanceof File v) {
                bodyBuilder.addFormDataPart(name, request.getFileName(), RequestBody.create(v, contentType));
            } else if (value instanceof InputFile v) {
                contentType = MediaType.parse(v.getContentType());
                bodyBuilder.addFormDataPart(name, v.getFileName(),
                        (v.getFile() == null)
                                ? RequestBody.create(v.getBytes(), contentType)
                                : RequestBody.create(v.getFile(), contentType));
            } else {
                bodyBuilder.addFormDataPart(name, mapObjectToParamValue(value));
            }
        }
        return bodyBuilder.build();
    }

    private String mapObjectToParamValue(Object value) {
        Class<?> c = value.getClass();
        if (c.isPrimitive() || c.isEnum() || c.getName().startsWith("java.lang")) {
            return String.valueOf(value);
        }
        return gson.toJson(value);
    }

    //endregion
}