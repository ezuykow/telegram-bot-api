package kz.pandev.legrambotapi.models.requests.common.ban;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to ban a user in a group, a supergroup or a channel.
 * In the case of supergroups and channels, the user will not be able to return to the chat on their
 * own using invite links, etc., unless unbanned first. The bot must be an administrator in the chat
 * for this to work and must have the appropriate administrator rights. Returns True on success.
 * @author ezuykow
 */
public class BanChatMember extends Request<BanChatMember, Response> {

    /**
     * @param chatId Unique identifier for the target group or username of the target supergroup or channel (in the format @channelusername)
     * @param userId Unique identifier of the target user
     */
    public BanChatMember(@NotNull Object chatId, long userId) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("user_id", userId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    //region API

    /**
     * Set parameter until_date
     * @param untilDate Date when the user will be unbanned; Unix time. If user is banned for more than 366 days
     *                  or less than 30 seconds from the current time they are considered to be banned forever.
     *                  Applied for supergroups and channels only.
     * @return this request
     */
    public BanChatMember untilDate(int untilDate) {
        return addParameter("until_date", untilDate);
    }

    /**
     * Set parameter revoke_messages
     * @param revokeMessages Pass True to delete all messages from the chat for the user that is being removed.
     *                      If False, the user will be able to see messages in the group that were sent before
     *                       the user was removed. Always True for supergroups and channels.
     * @return this request
     */
    public BanChatMember revokeMessages(boolean revokeMessages) {
        return addParameter("revoke_messages", revokeMessages);
    }

    //endregion
}