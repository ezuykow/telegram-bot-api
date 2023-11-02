package kz.pandev.legrambotapi.models.types.passport.credentials.utils;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents the credentials required to decrypt encrypted values.
 * All fields are optional and depend on the type of fields that were requested.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SecureValue implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Optional. Credentials for encrypted Telegram Passport data. Available for "personal_details",
     * "passport", "driver_license", "identity_card", "internal_passport" and "address" types.
     */
    @SerializedName("data")
    @Nullable
    private DataCredentials data;

    /**
     * Optional. Credentials for an encrypted document's front side. Available for "passport",
     * "driver_license", "identity_card" and "internal_passport".
     */
    @SerializedName("front_side")
    @Nullable
    private FileCredentials frontSide;

    /**
     * Optional. Credentials for an encrypted document's reverse side. Available for
     * "driver_license" and "identity_card".
     */
    @SerializedName("reverse_side")
    @Nullable
    private FileCredentials reverseSide;

    /**
     * Optional. Credentials for an encrypted selfie of the user with a document.
     * Available for "passport", "driver_license", "identity_card" and "internal_passport".
     */
    @SerializedName("selfie")
    @Nullable
    private FileCredentials selfie;

    /**
     * Optional. Credentials for an encrypted translation of the document. Available for "passport",
     * "driver_license", "identity_card", "internal_passport", "utility_bill", "bank_statement", "rental_agreement",
     * "passport_registration" and "temporary_registration".
     */
    @SerializedName("translation")
    @Nullable
    private FileCredentials[] translation;

    /**
     * Optional. Credentials for encrypted files. Available for "utility_bill", "bank_statement",
     * "rental_agreement", "passport_registration" and "temporary_registration" types.
     */
    @SerializedName("files")
    @Nullable
    private FileCredentials[] files;

}