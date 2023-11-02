package kz.pandev.legrambotapi.models.types.passport.credentials.utils;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.passport.encrypted.EncryptedPassportElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents the credentials required to decrypt encrypted data.
 * All fields are optional and depend on fields that were requested.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SecureData implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Optional. Credentials for encrypted personal details
     */
    @SerializedName("personal_details")
    @Nullable
    private SecureValue personalDetails;

    /**
     * Optional. Credentials for encrypted passport
     */
    @SerializedName("passport")
    @Nullable
    private SecureValue passport;

    /**
     * Optional. Credentials for encrypted internal passport
     */
    @SerializedName("internal_passport")
    @Nullable
    private SecureValue internalPassport;

    /**
     * Optional. Credentials for encrypted driver license
     */
    @SerializedName("driver_license")
    @Nullable
    private SecureValue driverLicense;

    /**
     * Optional. Credentials for encrypted ID card
     */
    @SerializedName("identity_card")
    @Nullable
    private SecureValue identityCard;

    /**
     * Optional. Credentials for encrypted residential address
     */
    @SerializedName("address")
    @Nullable
    private SecureValue address;

    /**
     * Optional. Credentials for encrypted utility bill
     */
    @SerializedName("utility_bill")
    @Nullable
    private SecureValue utilityBill;

    /**
     * Optional. Credentials for encrypted bank statement
     */
    @SerializedName("bank_statement")
    @Nullable
    private SecureValue bankStatement;

    /**
     * Optional. Credentials for encrypted rental agreement
     */
    @SerializedName("rental_agreement")
    @Nullable
    private SecureValue rentalAgreement;

    /**
     * Optional. Credentials for encrypted registration from internal passport
     */
    @SerializedName("passport_registration")
    @Nullable
    private SecureValue passportRegistration;

    /**
     * Optional. Credentials for encrypted temporary registration
     */
    @SerializedName("temporary_registration")
    @Nullable
    private SecureValue temporaryRegistration;

    //region API

    /**
     * @param type type of EncryptedPassportElement {@link EncryptedPassportElement.Type}
     * @return {@link SecureValue} of parameter type
     */
    public SecureValue ofType(EncryptedPassportElement.Type type) {
        SecureValue result;
        switch (type) {
            case PERSONAL_DETAILS -> result = personalDetails;
            case PASSPORT -> result = passport;
            case INTERNAL_PASSPORT -> result = internalPassport;
            case DRIVER_LICENSE ->  result = driverLicense;
            case IDENTITY_CARD -> result = identityCard;
            case ADDRESS -> result = address;
            case UTILITY_BILL -> result = utilityBill;
            case BANK_STATEMENT -> result = bankStatement;
            case RENTAL_AGREEMENT -> result = rentalAgreement;
            case PASSPORT_REGISTRATION -> result = passportRegistration;
            case TEMPORARY_REGISTRATION -> result = temporaryRegistration;
            default -> result = null;
        }
        return result;
    }

    //endregion
}