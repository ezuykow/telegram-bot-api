package kz.pandev.legrambotapi.models.requests.chat.invite.link;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.chat.invite.link.ChatInviteLinkResponse;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to create an additional invite link for a chat. The bot must be an administrator
 * in the chat for this to work and must have the appropriate administrator rights. The link can be
 * revoked using the method revokeChatInviteLink. Returns the new invite link as ChatInviteLink object.
 * @author ezuykow
 */
@Getter
public class CreateChatInviteLink extends Request<CreateChatInviteLink, ChatInviteLinkResponse> {

    /**
     * Optional. Invite link name; 0-32 characters
     */
    @Nullable
    private String name;
    /**
     * Optional. Point in time (Unix timestamp) when the link will expire
     */
    @Nullable
    private Integer expireDate;
    /**
     * Optional. The maximum number of users that can be members of the chat simultaneously after
     * joining the chat via this invite link; 1-99999
     */
    @Nullable
    private Integer memberLimit;
    /**
     * Optional. True, if users joining the chat via the link need to be approved by chat administrators.
     * If True, member_limit can't be specified
     */
    @Nullable
    private Boolean createsJoinRequest;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     */
    public CreateChatInviteLink(Object chatId) {
        super(ChatInviteLinkResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    //region API

    /**
     * Set parameter {@link CreateChatInviteLink#name}
     * @param name new parameter value
     * @return this request
     */
    public CreateChatInviteLink name(@NotNull String name) {
        this.name = name;
        return addParameter("name", name);
    }

    /**
     * Set parameter {@link CreateChatInviteLink#expireDate}
     * @param expireDate new parameter value
     * @return this request
     */
    public CreateChatInviteLink expireDate(int expireDate) {
        this.expireDate = expireDate;
        return addParameter("expire_date", expireDate);
    }

    /**
     * Set parameter {@link CreateChatInviteLink#memberLimit}
     * @param memberLimit new parameter value
     * @return this request
     */
    public CreateChatInviteLink memberLimit(int memberLimit) {
        this.memberLimit = memberLimit;
        return addParameter("member_limit", memberLimit);
    }

    /**
     * Set parameter {@link CreateChatInviteLink#createsJoinRequest}
     * @param createsJoinRequest new parameter value
     * @return this request
     */
    public CreateChatInviteLink createsJoinRequest(Boolean createsJoinRequest) {
        this.createsJoinRequest = createsJoinRequest;
        return addParameter("creates_join_request", createsJoinRequest);
    }

    //endregion
}