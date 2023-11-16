package kz.pandev.legrambotapi.models.requests.chat.invite.link;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.chat.invite.link.ChatInviteLinkResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to create an additional invite link for a chat. The bot must be an administrator
 * in the chat for this to work and must have the appropriate administrator rights. The link can be
 * revoked using the method revokeChatInviteLink. Returns the new invite link as ChatInviteLink object.
 * @author ezuykow
 */
public class CreateChatInviteLink extends Request<CreateChatInviteLink, ChatInviteLinkResponse> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     */
    public CreateChatInviteLink(@NotNull Object chatId) {
        super(ChatInviteLinkResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    //region API

    /**
     * Set parameter name
     * @param name Invite link name; 0-32 characters
     * @return this request
     */
    public CreateChatInviteLink name(@NotNull String name) {
        return addParameter("name", name);
    }

    /**
     * Set parameter expire_date
     * @param expireDate Point in time (Unix timestamp) when the link will expire
     * @return this request
     */
    public CreateChatInviteLink expireDate(int expireDate) {
        return addParameter("expire_date", expireDate);
    }

    /**
     * Set parameter member_limit
     * @param memberLimit The maximum number of users that can be members of the chat simultaneously after
     *                   joining the chat via this invite link; 1-99999
     * @return this request
     */
    public CreateChatInviteLink memberLimit(int memberLimit) {
        return addParameter("member_limit", memberLimit);
    }

    /**
     * Set parameter creates_join_request
     * @param createsJoinRequest True, if users joining the chat via the link need to be approved by chat
     *                          administrators. If True, member_limit can't be specified
     * @return this request
     */
    public CreateChatInviteLink createsJoinRequest(Boolean createsJoinRequest) {
        return addParameter("creates_join_request", createsJoinRequest);
    }

    //endregion
}