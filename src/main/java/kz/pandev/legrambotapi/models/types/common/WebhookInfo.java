package kz.pandev.legrambotapi.models.types.common;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Describes the current status of a webhook
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class WebhookInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Webhook URL, may be empty if webhook is not set up
     */
    @SerializedName("url")
    private String url;

    /**
     * True, if a custom certificate was provided for webhook certificate checks
     */
    @SerializedName("has_custom_certificate")
    private Boolean hasCustomCertificate;

    /**
     * Number of updates awaiting delivery
     */
    @SerializedName("pending_update_count")
    private Integer pendingUpdateCount;

    /**
     * Optional. Currently used webhook IP address
     */
    @SerializedName("ip_address")
    @Nullable
    private String ipAddress;

    /**
     * Optional. Unix time for the most recent error that happened when trying to deliver an update via webhook
     */
    @SerializedName("last_error_date")
    @Nullable
    private Integer lastErrorDate;

    /**
     * Optional. Error message in human-readable format for the most recent error that happened when trying to deliver
     * an update via webhook
     */
    @SerializedName("last_error_message")
    @Nullable
    private String lastErrorMessage;

    /**
     * Optional. Unix time of the most recent error that happened when trying to synchronize available updates with
     * Telegram datacenters
     */
    @SerializedName("last_synchronization_error_date")
    @Nullable
    private Integer lastSynchronizationDate;

    /**
     * Optional. The maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery
     */
    @SerializedName("max_connections")
    @Nullable
    private Integer maxConnections;

    /**
     * Optional. A list of update types the bot is subscribed to. Defaults to all update types except chat_member
     */
    @SerializedName("allowed_updates")
    @Nullable
    private List<String> allowedUpdates;
}