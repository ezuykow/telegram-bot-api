package kz.pandev.legrambotapi.models.types.inline.mode.input.message.content;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents the content of a contact message to be sent as the result of an inline query.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode
@ToString
public class InputContactMessageContent implements InputMessageContent, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Contact's phone number
     */
    @SerializedName("phone_number")
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
     * Optional. Additional data about the contact in the form of a vCard, 0-2048 bytes
     */
    @SerializedName("vcard")
    @Nullable
    private String vCard;

    public InputContactMessageContent(@NotNull String phoneNumber, @NotNull String firstName) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
    }

    //region API

    /**
     * Set parameter {@link InputContactMessageContent#phoneNumber}
     * @param phoneNumber new parameter value
     * @return this {@link InputContactMessageContent}
     */
    public InputContactMessageContent phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * Set parameter {@link InputContactMessageContent#firstName}
     * @param firstName new parameter value
     * @return this {@link InputContactMessageContent}
     */
    public InputContactMessageContent firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Set parameter {@link InputContactMessageContent#lastName}
     * @param lastName new parameter value
     * @return this {@link InputContactMessageContent}
     */
    public InputContactMessageContent lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Set parameter {@link InputContactMessageContent#vCard}
     * @param vCard new parameter value
     * @return this {@link InputContactMessageContent}
     */
    public InputContactMessageContent vCard(String vCard) {
        this.vCard = vCard;
        return this;
    }

    //endregion
}