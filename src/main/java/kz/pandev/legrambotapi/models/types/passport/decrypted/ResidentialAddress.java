package kz.pandev.legrambotapi.models.types.passport.decrypted;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a residential address
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ResidentialAddress implements DecryptedData, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * First line for the address
     */
    @SerializedName("street_line1")
    private String streetLine1;

    /**
     * Optional. Second line for the address
     */
    @SerializedName("street_line2")
    @Nullable
    private String streetLine2;

    /**
     * City
     */
    @SerializedName("city")
    private String city;

    /**
     * Optional. State
     */
    @SerializedName("state")
    @Nullable
    private String state;

    /**
     * ISO 3166-1 alpha-2 country code
     */
    @SerializedName("country_code")
    private String countryCode;

    /**
     * Address post code
     */
    @SerializedName("post_code")
    private String postCode;
}