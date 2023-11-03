package kz.pandev.legrambotapi.models.requests.webhook;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.webhook.GetWebhookInfoResponse;

/**
 * Use this method to get current webhook status.
 * Requires no parameters. On success, returns a WebhookInfo object.
 * @author ezuykow
 */
public class GetWebhookInfo extends Request<GetWebhookInfo, GetWebhookInfoResponse> {

    public GetWebhookInfo() {
        super(GetWebhookInfoResponse.class);
    }
}