package kz.pandev.legrambotapi.models.requests.extending.webhook;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.input.InputFile;
import kz.pandev.legrambotapi.utils.MimeTypes;
import lombok.Getter;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Request for Telegram bot API method "setWebhook"
 * @author ezuykow
 */
@Getter
public class SetWebhook extends Request<SetWebhook, Response> {

    private static final String CERTIFICATE_STRING = "certificate";

    private boolean isMultipart = false;

    /**
     * HTTPS URL to send updates to. Use an empty string to remove webhook integration
     */
    private String url;
    /**
     * Optional. Upload your public key certificate so that the root certificate in use can be checked
     */
    private InputFile certificate;
    /**
     * Optional. The fixed IP address which will be used to send webhook requests instead of the IP address
     * resolved through DNS
     */
    private String ipAddress;
    /**
     * Optional. The maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery, 1-100.
     * Defaults to 40. Use lower values to limit the load on your bot's server, and higher values to increase your
     * bot's throughput.
     */
    private Integer maxConnections;
    /**
     * Optional. List of the update types you want your bot to receive.
     * Specify an empty list to receive all update types except chat_member (default). If not specified,
     * the previous setting will be used.
     */
    private List<String> allowedUpdates;
    /**
     * Optional. Pass True to drop all pending updates
     */
    private Boolean dropPendingUpdates;
    /**
     * Optional. A secret token to be sent in a header “X-Telegram-Bot-Api-Secret-Token” in every webhook request,
     * 1-256 characters. Only characters A-Z, a-z, 0-9, _ and - are allowed. The header is useful to ensure that the
     * request comes from a webhook set by you.
     */
    private String secretToken;

    public SetWebhook() {
        super(Response.class);
    }

    //region API

    /**
     * Set webhook {@link SetWebhook#url} parameter
     * @param url new webhook url as {@link String}
     * @return this request
     */
    public SetWebhook url(String url) {
        this.url = url;
        return addParameter("url", this.url);
    }

    /**
     * Set webhook {@link SetWebhook#certificate} parameter
     * @param certificate certificate as {@link File}
     * @return this request
     */
    public SetWebhook certificate(File certificate) {
        this.isMultipart = true;
        this.certificate = new InputFile(certificate, CERTIFICATE_STRING, MimeTypes.GENERAL_MIME_TYPE);
        return addParameter(CERTIFICATE_STRING, this.certificate);
    }

    /**
     * Set webhook {@link SetWebhook#certificate} parameter
     * @param certificate certificate as byte array
     * @return this request
     */
    public SetWebhook certificate(byte[] certificate) {
        this.isMultipart = true;
        this.certificate = new InputFile(certificate, CERTIFICATE_STRING, MimeTypes.GENERAL_MIME_TYPE);
        return addParameter(CERTIFICATE_STRING, this.certificate);
    }

    /**
     * Set webhook {@link SetWebhook#ipAddress} parameter
     * @param ipAddress new ip address
     * @return this request
     */
    public SetWebhook ipAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return addParameter("ip_address", this.ipAddress);
    }

    /**
     * Set webhook {@link SetWebhook#maxConnections} parameter
     * @param maxConnections new max connections count
     * @return this request
     */
    public SetWebhook maxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
        return addParameter("max_connections", this.maxConnections);
    }

    /**
     * Set webhook {@link SetWebhook#allowedUpdates} parameter
     * @param allowedUpdates new allowed updates
     * @return this request
     */
    public SetWebhook allowedUpdates(String... allowedUpdates) {
        this.allowedUpdates = Arrays.asList(allowedUpdates);
        return addParameter("allowed_updates", allowedUpdates);
    }

    /**
     * Set webhook {@link SetWebhook#dropPendingUpdates} parameter
     * @param dropPendingUpdates new drop pending updates parameter
     * @return this request
     */
    public SetWebhook dropPendingUpdates(boolean dropPendingUpdates) {
        this.dropPendingUpdates = dropPendingUpdates;
        return addParameter("drop_pending_updates", this.dropPendingUpdates);
    }

    /**
     * Set webhook {@link SetWebhook#secretToken} parameter
     * @param secretToken new secret token
     * @return this request
     */
    public SetWebhook secretToken(String secretToken) {
        this.secretToken = secretToken;
        return addParameter("secret_token", this.secretToken);
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