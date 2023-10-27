package kz.pandev.legrambotapi.models.responses.extending;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.WebhookInfo;
import lombok.Getter;
import lombok.ToString;

/**
 * Telegram bot API server response to GetWebhookInfo request
 * @author ezuykow
 */
@Getter
@ToString
public class GetWebhookInfoResponse extends Response {

    /**
     * Result as {@link WebhookInfo}
     */
    @SerializedName("result")
    private WebhookInfo webhookInfo;
}