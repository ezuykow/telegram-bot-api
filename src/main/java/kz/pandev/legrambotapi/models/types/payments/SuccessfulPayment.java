package kz.pandev.legrambotapi.models.types.payments;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object contains basic information about a successful payment.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SuccessfulPayment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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
     * Telegram payment identifier
     */
    @SerializedName("telegram_payment_charge_id")
    private String telegramPaymentChargeId;

    /**
     * Provider payment identifier
     */
    @SerializedName("provider_payment_charge_id")
    private String providerPaymentChargeId;

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