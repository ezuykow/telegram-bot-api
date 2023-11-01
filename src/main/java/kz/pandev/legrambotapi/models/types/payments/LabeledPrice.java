package kz.pandev.legrambotapi.models.types.payments;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a portion of the price for goods or services.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode
@ToString
public class LabeledPrice implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Portion label
     */
    @SerializedName("label")
    private String label;

    /**
     * Price of the product in the smallest units of the
     * <a href="https://core.telegram.org/bots/payments#supported-currencies">currency</a> (integer, not float/double).
     * For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in
     * <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number
     * of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    @SerializedName("amount")
    private Integer amount;

    public LabeledPrice(@NotNull String label, @NotNull Integer amount) {
        this.label = label;
        this.amount = amount;
    }
}