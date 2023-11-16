package kz.pandev.legrambotapi.models.requests.webhook;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.input.InputFile;
import kz.pandev.legrambotapi.utils.enums.MimeType;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * Request for Telegram bot API method "setWebhook"
 * @author ezuykow
 */
public class SetWebhook extends Request<SetWebhook, Response> {

    private static final String CERTIFICATE_STRING = "certificate";

    private boolean isMultipart = false;

    public SetWebhook() {
        super(Response.class);
    }

    //region API

    /**
     * Set webhook url parameter
     * @param url HTTPS URL to send updates to. Use an empty string to remove webhook integration
     * @return this request
     */
    public SetWebhook url(@NotNull String url) {
        return addParameter("url", url);
    }

    /**
     * Set webhook's certificate parameter
     * @param certificate Upload your public key certificate so that the root certificate in use can be checked
     * @return this request
     */
    public SetWebhook certificate(@NotNull File certificate) {
        this.isMultipart = true;
        InputFile cert = new InputFile(certificate, CERTIFICATE_STRING, MimeType.GENERAL.getTextVal());
        return addParameter(CERTIFICATE_STRING, cert);
    }

    /**
     * Set webhook's certificate parameter
     * @param certificate Upload your public key certificate so that the root certificate in use can be checked
     * @return this request
     */
    public SetWebhook certificate(@NotNull byte[] certificate) {
        this.isMultipart = true;
        InputFile cert = new InputFile(certificate, CERTIFICATE_STRING, MimeType.GENERAL.getTextVal());
        return addParameter(CERTIFICATE_STRING, cert);
    }

    /**
     * Set webhook's ip_address parameter
     * @param ipAddress The fixed IP address which will be used to send webhook requests instead of the IP
     *                  address resolved through DNS
     * @return this request
     */
    public SetWebhook ipAddress(@NotNull String ipAddress) {
        return addParameter("ip_address", ipAddress);
    }

    /**
     * Set webhook's max_connections parameter
     * @param maxConnections The maximum allowed number of simultaneous HTTPS connections to the webhook for update
     *                      delivery, 1-100. Defaults to 40. Use lower values to limit the load on your bot's server,
     *                      and higher values to increase your bot's throughput.
     * @return this request
     */
    public SetWebhook maxConnections(int maxConnections) {
        return addParameter("max_connections", maxConnections);
    }

    /**
     * Set webhook allowed_updates parameter
     * @param allowedUpdates List of the update types you want your bot to receive. Specify an empty list to receive
     *                       all update types except chat_member (default). If not specified, the previous setting
     *                       will be used
     * @return this request
     */
    public SetWebhook allowedUpdates(@NotNull String... allowedUpdates) {
        return addParameter("allowed_updates", allowedUpdates);
    }

    /**
     * Set webhook drop_pending_updates parameter
     * @param dropPendingUpdates Pass True to drop all pending updates
     * @return this request
     */
    public SetWebhook dropPendingUpdates(boolean dropPendingUpdates) {
        return addParameter("drop_pending_updates", dropPendingUpdates);
    }

    /**
     * Set webhook secret_token parameter
     * @param secretToken A secret token to be sent in a header “X-Telegram-Bot-Api-Secret-Token” in every webhook
     *                    request, 1-256 characters. Only characters A-Z, a-z, 0-9, _ and - are allowed. The header
     *                    is useful to ensure that the request comes from a webhook set by you.
     * @return this request
     */
    public SetWebhook secretToken(@NotNull String secretToken) {
        return addParameter("secret_token", secretToken);
    }

    /**
     * @return true if request is multipart
     */
    @Override
    public boolean isMultipart() {
        return isMultipart;
    }

    //endregion

}