package kz.pandev.legrambotapi.models.types.payments;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.payments.shipping.ShippingAddress;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents information about an order.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class OrderInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Optional. User name
     */
    @SerializedName("name")
    @Nullable
    private String name;

    /**
     * Optional. User's phone number
     */
    @SerializedName("phone_number")
    @Nullable
    private String phoneNumber;

    /**
     * Optional. User email
     */
    @SerializedName("email")
    @Nullable
    private String email;

    /**
     * Optional. User shipping address
     */
    @SerializedName("shipping_address")
    @Nullable
    private ShippingAddress shippingAddress;
}