package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.AbstractSendRequest;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to send phone contacts. On success, the sent Message is returned.
 * @author ezuykow
 */
@Getter
public class SendContact extends AbstractSendRequest<SendContact> {

    /**
     * Optional. Contact's last name
     */
    @Nullable
    private String lastName;
    /**
     * Optional. Additional data about the contact in the form of a vCard, 0-2048 bytes
     */
    @Nullable
    private String vCard;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param phoneNumber Contact's phone number
     * @param firstName Contact's first name
     */
    public SendContact(@NotNull Object chatId, @NotNull String phoneNumber, @NotNull String firstName) {
        super(chatId);
        addParameter("phone_number", phoneNumber);
        addParameter("first_name", firstName);
    }

    //region API

    /**
     * Set parameter {@link SendContact#lastName}
     * @param lastName new parameter value
     * @return this request
     */
    public SendContact lastName(String lastName) {
        this.lastName = lastName;
        return addParameter("last_name", lastName);
    }

    /**
     * Set parameter {@link SendContact#vCard}
     * @param vCard new parameter value
     * @return this request
     */
    public SendContact vCard(String vCard) {
        this.vCard = vCard;
        return addParameter("vcard", vCard);
    }

    //endregion
}