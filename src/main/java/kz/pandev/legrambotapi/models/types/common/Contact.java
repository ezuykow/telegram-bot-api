package kz.pandev.legrambotapi.models.types.common;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a phone contact
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Contact implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Contact's phone number
     */
    @SerializedName("phone_number")
    @EqualsAndHashCode.Include
    private String phoneNumber;

    /**
     * Contact's first name
     */
    @SerializedName("first_name")
    private String firstName;

    /**
     * Optional. Contact's last name
     */
    @SerializedName("last_name")
    @Nullable
    private String lastName;

    /**
     * Optional. Contact's user identifier in Telegram
     */
    @SerializedName("user_id")
    @Nullable
    private Long userId;

    /**
     * Optional. Additional data about the contact in the form of a vCard
     */
    @SerializedName("vcard")
    @Nullable
    private String vcard;
}