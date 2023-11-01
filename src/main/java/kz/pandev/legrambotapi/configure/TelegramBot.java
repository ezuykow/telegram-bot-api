package kz.pandev.legrambotapi.configure;

import com.google.gson.Gson;
import kz.pandev.legrambotapi.configure.api.TelegramBotClient;
import kz.pandev.legrambotapi.configure.api.TelegramFileApi;
import kz.pandev.legrambotapi.exceptions.handler.ExceptionHandler;
import kz.pandev.legrambotapi.models.requests.extending.GetUpdates;
import kz.pandev.legrambotapi.utils.Cancellable;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.File;
import kz.pandev.legrambotapi.configure.updates_handler.UpdatesHandler;
import kz.pandev.legrambotapi.configure.updates_handler.UpdatesListener;
import kz.pandev.legrambotapi.utils.Constant;
import lombok.Getter;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * This object represents Telegram Bot entity
 * @author ezuykow
 */
@SuppressWarnings("unused") /*Unused methods warning*/
public class TelegramBot {

    /**
     * URL to this bot API
     */
    @Getter
    private final String botApiUrl;
    /**
     * This bot token
     */
    @Getter
    private final String botToken;
    /**
     * Telegram bot API server client
     */
    private final TelegramBotClient telegramBotClient;
    /**
     * {@link TelegramFileApi} - methods to interact with files on Telegram bot API server
     */
    private final TelegramFileApi fileApi;
    /**
     * Handler of new updates on Telegram bot API server for long polling bot
     */
    private final UpdatesHandler updatesHandler;

    public TelegramBot(String botToken) {
        this(botToken, Constant.DEFAULT_BOT_API_SERVER_URL);
    }

    public TelegramBot(String botToken, String apiServerUrl) {
        this(new Builder(botToken, apiServerUrl));
    }

    public TelegramBot(Builder builder) {
        this.botToken = builder.botToken;
        this.botApiUrl = builder.botApiUrl;
        this.telegramBotClient = builder.botClient;
        this.fileApi = builder.fileApi;
        this.updatesHandler = builder.updatesHandler;
    }

    //region API

    /**
     * Execute request to telegram bot api server with custom callback
     * @param request request to execute
     * @param callback custom callback
     * @return {@link Call} with request as {@link Cancellable}
     */
    public <T extends Request<T, R>, R extends Response> Cancellable execute(T request, Callback<T, R> callback) {
        return telegramBotClient.send(request, callback);
    }

    /**
     * Execute request to telegram bot api server
     * @param request request to execute
     * @return server response extending {@link Response}
     */
    public <T extends Request<T, R>, R extends Response> R execute(Request<T, R> request) {
        return telegramBotClient.send(request);
    }

    /**
     * @param file target {@link File}
     * @return full path to target file on Telegram bot API server
     */
    public String getFullFilePath(File file) {
        return fileApi.getFullFilePath(file);
    }

    /**
     * @param file target {@link File}
     * @return file content as byte array
     * @throws IOException if an I/O exception occur
     */
    public byte[] getFileContent(File file) throws IOException {
        return fileApi.getFileContent(file);
    }

    /**
     * For long polling bot only <br>
     * Start an updates handler without {@link ExceptionHandler}, with default {@link GetUpdates} request and
     * {@link UpdatesListener}, which came in parameter
     * @param listener updates processor
     */
    public void setUpdatesListener(UpdatesListener listener) {
        setUpdatesListener(listener, null, new GetUpdates());
    }

    /**
     * For long polling bot only <br>
     * Start an updates handler without {@link ExceptionHandler} and with parameters:
     * @param listener updates processor
     * @param getUpdates request for Telegram bot API method "getUpdates"
     */
    public void setUpdatesListener(UpdatesListener listener, GetUpdates getUpdates) {
        setUpdatesListener(listener, null, getUpdates);
    }

    /**
     * For long polling bot only <br>
     * Start an updates handler with default {@link GetUpdates} request and parameters:
     * @param listener updates processor
     * @param exceptionHandler handler of exceptions that occurs in UpdatesListener
     */
    public void setUpdatesListener(UpdatesListener listener, ExceptionHandler exceptionHandler) {
        setUpdatesListener(listener, exceptionHandler, new GetUpdates());
    }

    /**
     * For long polling bot only <br>
     * Start an updates handler with parameters:
     * @param listener updates processor
     * @param exceptionHandler handler of exceptions that occurs in UpdatesListener
     * @param getUpdates request for Telegram bot API method "getUpdates"
     */
    public void setUpdatesListener(UpdatesListener listener, ExceptionHandler exceptionHandler, GetUpdates getUpdates) {
        updatesHandler.stop();
        updatesHandler.start(this, listener, exceptionHandler, getUpdates);
    }

    /**
     * Stop an updates handler
     */
    public void removeGetUpdatesListener() {
        updatesHandler.stop();
    }

    //endregion

    /**
     * Builder for {@link TelegramBot}
     * @author ezuykow
     */
    public static final class Builder {

        /**
         * This bot token
         */
        private final String botToken;
        /**
         * Telegram bot API server client
         */
        private TelegramBotClient botClient;
        /**
         * {@link TelegramFileApi} - methods to interact with files on Telegram bot API server
         */
        private TelegramFileApi fileApi;
        /**
         * URL to Telegram bot API server
         */
        private String apiServerUrl;
        /**
         * URL to this bot API
         */
        private String botApiUrl;
        /**
         * Handler of new updates on Telegram bot API server for long polling bot
         */
        private UpdatesHandler updatesHandler;
        /**
         * Http client
         */
        private OkHttpClient okHttpClient;

        public Builder(String botToken) {
            this.botToken = botToken;
        }

        public Builder(String botToken, String apiServerUrl) {
            this.botToken = botToken;
            this.apiServerUrl = apiServerUrl;
            this.botApiUrl = apiServerUrl + "bot" + botToken + "/";
            this.okHttpClient = okHttpClient((Interceptor) null);
            this.botClient = new TelegramBotClient(okHttpClient, new Gson(), botApiUrl);
            this.updatesHandler = new UpdatesHandler(Constant.DEFAULT_UPDATES_HANDLER_SLEEP_TIME_MILLISECONDS);
        }

        //region API

        /**
         * Set http client
         * @param okHttpClient new http client
         * @return this builder
         */
        public Builder okHttpClient(OkHttpClient okHttpClient) {
            this.okHttpClient = okHttpClient;
            return this;
        }

        /**
         * Set Telegram bot API server URL
         * @param apiServerUrl new server URL
         * @return this Builder
         */
        public Builder apiServerUrl(String apiServerUrl) {
            this.apiServerUrl = apiServerUrl;
            return this;
        }

        /**
         * Set updates handler sleep time
         * @param millis new sleep time
         * @return this builder
         */
        public Builder updatesHandlerSleepTime(long millis) {
            updatesHandler = new UpdatesHandler(millis);
            return this;
        }

        /**
         * Disable http client debug mode
         * @return this builder
         */
        public Builder httpClientDisableDebugMode() {
            okHttpClient = httpClientDebugMode(HttpLoggingInterceptor.Level.NONE);
            return this;
        }

        /**
         * Set level of http debug mode to basic
         * @return this builder
         */
        public Builder httpClientBasicDebugMode() {
            okHttpClient = httpClientDebugMode(HttpLoggingInterceptor.Level.BASIC);
            return this;
        }

        /**
         * Set level of http debug mode to headers
         * @return this builder
         */
        public Builder httpClientHeadersDebugMode() {
            okHttpClient = httpClientDebugMode(HttpLoggingInterceptor.Level.HEADERS);
            return this;
        }

        /**
         * Set level of http debug mode to body
         * @return this builder
         */
        public Builder httpClientBodyDebugMode() {
            okHttpClient = httpClientDebugMode(HttpLoggingInterceptor.Level.BODY);
            return this;
        }

        /**
         * Build {@link TelegramBot} with this builder parameters
         * @return built {@link TelegramBot}
         */
        public TelegramBot build() {
            if (okHttpClient == null) {
                okHttpClient = okHttpClient((Interceptor) null);
            }
            if (apiServerUrl == null) {
                apiServerUrl = Constant.DEFAULT_BOT_API_SERVER_URL;
            }
            botApiUrl = apiServerUrl + "bot" + botToken + "/";
            botClient = new TelegramBotClient(okHttpClient, new Gson(), botApiUrl);

            if (updatesHandler == null) {
                updatesHandler = new UpdatesHandler(Constant.DEFAULT_UPDATES_HANDLER_SLEEP_TIME_MILLISECONDS);
            }

            fileApi = new TelegramFileApi(apiServerUrl, botToken);

            return new TelegramBot(this);
        }

        //endregion
        //region Utils

        private static OkHttpClient httpClientDebugMode(HttpLoggingInterceptor.Level level) {
            return okHttpClient(new HttpLoggingInterceptor().setLevel(level));
        }

        private static OkHttpClient okHttpClient(Interceptor interceptor) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .connectTimeout(Constant.DEFAULT_HTTP_CLIENT_CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    .writeTimeout(Constant.DEFAULT_HTTP_CLIENT_WRITE_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    .readTimeout(Constant.DEFAULT_HTTP_CLIENT_READ_TIMEOUT_SECONDS, TimeUnit.SECONDS);
            if (interceptor != null) {
                builder.addInterceptor(interceptor);
            }
            return builder.build();
        }

        //endregion
    }
}