package kz.pandev.legrambotapi.models.requests.payments;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;

/**
 * Once the user has confirmed their payment and shipping details,
 * the Bot API sends the final confirmation in the form of an Update with the field pre_checkout_query.
 * Use this method to respond to such pre-checkout queries. On success, True is returned.
 * @apiNote The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.
 * @author ezuykow
 */
public class AnswerPreCheckoutQuery extends Request<AnswerPreCheckoutQuery, Response> {

    /**
     * Use if everything is alright (goods are available, etc.) and the bot is ready to proceed with the order
     * @param preCheckoutQueryId Unique identifier for the query to be answered
     */
    public AnswerPreCheckoutQuery(String preCheckoutQueryId) {
        super(Response.class);
        addParameter("pre_checkout_query_id", preCheckoutQueryId);
        addParameter("ok", true);
    }

    /**
     * Use if there are any problems
     * @param preCheckoutQueryId Unique identifier for the query to be answered
     * @param errorMessage Error message in human-readable form that explains the reason for failure to proceed
     *                    with the checkout (e.g. "Sorry, somebody just bought the last of our amazing black
     *                     T-shirts while you were busy filling out your payment details. Please choose a different
     *                     color or garment!"). Telegram will display this message to the user.
     */
    public AnswerPreCheckoutQuery(String preCheckoutQueryId, String errorMessage) {
        super(Response.class);
        addParameter("pre_checkout_query_id", preCheckoutQueryId);
        addParameter("ok", false);
        addParameter("error_message", errorMessage);
    }
}