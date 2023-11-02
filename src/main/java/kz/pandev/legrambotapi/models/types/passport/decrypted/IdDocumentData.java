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
 * This object represents the data of an identity document
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class IdDocumentData implements DecryptedData, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Document number
     */
    @SerializedName("document_no")
    private String documentNo;

    /**
     * Optional. Date of expiry, in DD.MM.YYYY format
     */
    @SerializedName("expiry_date")
    @Nullable
    private String expiryDate;
}