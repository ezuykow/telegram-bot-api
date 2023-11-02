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
 * This object represents personal details.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PersonalDetails implements DecryptedData, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * First Name
     */
    @SerializedName("first_name")
    private String firstName;

    /**
     * Last Name
     */
    @SerializedName("last_name")
    private String lastName;

    /**
     * Optional. Middle Name
     */
    @SerializedName("middle_name")
    @Nullable
    private String middleName;

    /**
     * Date of birth in DD.MM.YYYY format
     */
    @SerializedName("birth_date")
    private String birthDate;

    /**
     * Gender, male or female
     */
    @SerializedName("gender")
    private String gender;

    /**
     * Citizenship (ISO 3166-1 alpha-2 country code)
     */
    @SerializedName("country_code")
    private String countryCode;

    /**
     * Country of residence (ISO 3166-1 alpha-2 country code)
     */
    @SerializedName("residence_country_code")
    private String residenceCountryCode;

    /**
     * First Name in the language of the user's country of residence
     */
    @SerializedName("first_name_native")
    private String firstNameNative;

    /**
     * Last Name in the language of the user's country of residence
     */
    @SerializedName("last_name_native")
    private String lastNameNative;

    /**
     * Optional. Middle Name in the language of the user's country of residence
     */
    @SerializedName("middle_name_native")
    @Nullable
    private String middleNameNative;
}