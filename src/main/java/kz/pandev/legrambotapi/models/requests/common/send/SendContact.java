package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.AbstractSendRequest;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to send phone contacts. On success, the sent Message is returned.
 * @author ezuykow
 */
public class SendContact extends AbstractSendRequest<SendContact> {

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
     * Set parameter last_name
     * @param lastName Contact's last name
     * @return this request
     */
    public SendContact lastName(@NotNull String lastName) {
        return addParameter("last_name", lastName);
    }

    /**
     * Set parameter vcard
     * @param vCard Additional data about the contact in the form of a vCard, 0-2048 bytes
     * @return this request
     */
    public SendContact vCard(@NotNull String vCard) {
        return addParameter("vcard", vCard);
    }

    //endregion
}