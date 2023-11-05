package kz.pandev.legrambotapi.models.requests.payments;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.payments.shipping.ShippingOption;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * If you sent an invoice requesting a shipping address and the parameter is_flexible was specified,
 * the Bot API will send an Update with a shipping_query field to the bot. Use this method to reply
 * to shipping queries. On success, True is returned.
 * @author ezuykow
 */
public class AnswerShippingQuery extends Request<AnswerShippingQuery, Response> {

    /**
     * Use if delivery to the specified address is possible
     * @param shippingQueryId Unique identifier for the query to be answered
     * @param shippingOptions Array of available shipping options.
     */
    public AnswerShippingQuery(@NotNull String shippingQueryId, @NotNull ShippingOption... shippingOptions) {
        this(shippingQueryId, Arrays.asList(shippingOptions));
    }

    /**
     * Use if delivery to the specified address is possible
     * @param shippingQueryId Unique identifier for the query to be answered
     * @param shippingOptions List of available shipping options.
     */
    public AnswerShippingQuery(@NotNull String shippingQueryId, @NotNull List<ShippingOption> shippingOptions) {
        super(Response.class);
        addParameter("shipping_query_id", shippingQueryId);
        addParameter("ok", true);
        addParameter("shipping_options", shippingOptions);
    }

    /**
     * Use if there are any problems (for example, if delivery to the specified address is not possible)
     * @param shippingQueryId Unique identifier for the query to be answered
     * @param errorMessage Error message in human-readable form that explains why it is impossible to complete
     *                    the order (e.g. "Sorry, delivery to your desired address is unavailable").
     *                    Telegram will display this message to the user.
     */
    public AnswerShippingQuery(@NotNull String shippingQueryId, @NotNull String errorMessage) {
        super(Response.class);
        addParameter("shipping_query_id", shippingQueryId);
        addParameter("ok", false);
        addParameter("error_message", errorMessage);
    }
}