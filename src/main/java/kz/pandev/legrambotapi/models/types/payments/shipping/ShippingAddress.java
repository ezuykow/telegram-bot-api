package kz.pandev.legrambotapi.models.types.payments.shipping;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a shipping address.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ShippingAddress implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Two-letter ISO 3166-1 alpha-2 country code
     */
    @SerializedName("country_code")
    private String countryCode;

    /**
     * State, if applicable
     */
    @SerializedName("state")
    private String state;

    /**
     * City
     */
    @SerializedName("city")
    private String city;

    /**
     * First line for the address
     */
    @SerializedName("street_line1")
    private String streetLine1;

    /**
     * Second line for the address
     */
    @SerializedName("street_line2")
    private String streetLine2;

    /**
     * Address post code
     */
    @SerializedName("post_code")
    private String postCode;
}