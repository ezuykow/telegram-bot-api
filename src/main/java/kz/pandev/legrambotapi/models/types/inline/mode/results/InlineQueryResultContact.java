package kz.pandev.legrambotapi.models.types.inline.mode.results;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a contact with a phone number. By default, this contact will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the contact.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultContact extends InlineQueryResult<InlineQueryResultContact> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "contact";

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

    /**
     * Optional. Url of the thumbnail for the result
     */
    @SerializedName("thumbnail_url")
    @Nullable
    private String thumbnailUrl;

    /**
     * Optional. Thumbnail width
     */
    @SerializedName("thumbnail_width")
    @Nullable
    private Integer thumbnailWidth;

    /**
     * Optional. Thumbnail height
     */
    @SerializedName("thumbnail_height")
    @Nullable
    private Integer thumbnailHeight;

    public InlineQueryResultContact(@NotNull String id, @NotNull String phoneNumber, @NotNull String firstName) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultContact#phoneNumber}
     * @param phoneNumber new parameter value
     * @return this {@link InlineQueryResultContact}
     */
    public InlineQueryResultContact phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultContact#firstName}
     * @param firstName new parameter value
     * @return this {@link InlineQueryResultContact}
     */
    public InlineQueryResultContact firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultContact#lastName}
     * @param lastName new parameter value
     * @return this {@link InlineQueryResultContact}
     */
    public InlineQueryResultContact lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultContact#vCard}
     * @param vCard new parameter value
     * @return this {@link InlineQueryResultContact}
     */
    public InlineQueryResultContact vCard(String vCard) {
        this.vCard = vCard;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultContact#thumbnailUrl}
     * @param thumbnailUrl new parameter value
     * @return this {@link InlineQueryResultContact}
     */
    public InlineQueryResultContact thumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultContact#thumbnailWidth}
     * @param thumbnailWidth new parameter value
     * @return this {@link InlineQueryResultContact}
     */
    public InlineQueryResultContact thumbnailWidth(Integer thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultContact#thumbnailHeight}
     * @param thumbnailHeight new parameter value
     * @return this {@link InlineQueryResultContact}
     */
    public InlineQueryResultContact thumbnailHeight(Integer thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
        return this;
    }

    //endregion
}