package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.AbstractSendRequest;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to send phone contacts. On success, the sent Message is returned.
 * @author ezuykow
 */
@Getter
public class SendContact extends AbstractSendRequest<SendContact> {

    /**
     * Contact's phone number
     */
    private final String phoneNumber;
    /**
     * Contact's first name
     */
    private final String firstName;
    /**
     * Optional. Contact's last name
     */
    private String lastName;
    /**
     * Optional. Additional data about the contact in the form of a vCard, 0-2048 bytes
     */
    private String vCard;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param phoneNumber {@link SendContact#phoneNumber}
     * @param firstName {@link SendContact#firstName}
     */
    public SendContact(@NotNull Object chatId, @NotNull String phoneNumber, @NotNull String firstName) {
        super(chatId);
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
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