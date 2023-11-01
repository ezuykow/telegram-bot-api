package kz.pandev.legrambotapi.models.types.payments;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object contains information about an incoming pre-checkout query.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class PreCheckoutQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Unique query identifier
     */
    @SerializedName("id")
    @EqualsAndHashCode.Include
    private String id;

    /**
     * User who sent the query
     */
    @SerializedName("from")
    private User from;

    /**
     * Three-letter ISO 4217 <a href="https://core.telegram.org/bots/payments#supported-currencies">currency</a> code
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Total price in the smallest units of the currency (integer, not float/double). For example,
     * for a price of US$ 1.45 pass amount = 145. See the exp parameter in
     * <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>,
     * it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    @SerializedName("total_amount")
    private Integer totalAmount;

    /**
     * Bot specified invoice payload
     */
    @SerializedName("invoice_payload")
    private String invoicePayload;

    /**
     * Optional. Identifier of the shipping option chosen by the user
     */
    @SerializedName("shipping_option_id")
    @Nullable
    private String shippingOptionId;

    /**
     * Optional. Order information provided by the user
     */
    @SerializedName("order_info")
    @Nullable
    private OrderInfo orderInfo;
}