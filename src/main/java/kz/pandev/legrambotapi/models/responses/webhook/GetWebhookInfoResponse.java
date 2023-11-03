package kz.pandev.legrambotapi.models.responses.webhook;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.WebhookInfo;
import lombok.Getter;
import lombok.ToString;

/**
 * Telegram bot API server response to GetWebhookInfo request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetWebhookInfoResponse extends Response {

    /**
     * Result as {@link WebhookInfo}
     */
    @SerializedName("result")
    private WebhookInfo webhookInfo;
}