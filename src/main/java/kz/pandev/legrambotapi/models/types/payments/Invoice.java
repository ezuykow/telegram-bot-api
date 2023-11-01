package kz.pandev.legrambotapi.models.types.payments;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object contains basic information about an invoice.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Invoice implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Product name
     */
    @SerializedName("title")
    private String title;

    /**
     * Product description
     */
    @SerializedName("description")
    private String description;

    /**
     * Unique bot deep-linking parameter that can be used to generate this invoice
     */
    @SerializedName("start_parameter")
    private String startParameter;

    /**
     * Three-letter ISO 4217 <a href="https://core.telegram.org/bots/payments#supported-currencies">currency</a> code
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Total price in the smallest units of the currency (integer, not float/double). For example, for a price of
     * US$ 1.45 pass amount = 145. See the exp parameter in
     * <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number
     * of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    @SerializedName("total_amount")
    private String totalAmount;
}