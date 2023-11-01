package kz.pandev.legrambotapi.models.types.payments.shipping;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.payments.LabeledPrice;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * This object represents one shipping option.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ShippingOption implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Shipping option identifier
     */
    @SerializedName("id")
    @EqualsAndHashCode.Include
    private String id;

    /**
     * Option title
     */
    @SerializedName("title")
    private String title;

    /**
     * List of price portions
     */
    @SerializedName("prices")
    private List<LabeledPrice> prices;

    public ShippingOption(@NotNull String id, @NotNull String title, @NotNull List<LabeledPrice> prices) {
        this.id = id;
        this.title = title;
        this.prices = prices;
    }
}