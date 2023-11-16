package kz.pandev.legrambotapi.models.requests.chat.invite.link;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.chat.invite.link.ChatInviteLinkResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to revoke an invite link created by the bot. If the primary link is revoked,
 * a new link is automatically generated. The bot must be an administrator in the chat for this
 * to work and must have the appropriate administrator rights. Returns the revoked invite link
 * as ChatInviteLink object.
 * @author ezuykow
 */
public class RevokeChatInviteLink extends Request<RevokeChatInviteLink, ChatInviteLinkResponse> {

    /**
     * @param chatId Unique identifier of the target chat or username of the target channel (in the format @channelusername)
     * @param inviteLink The invite link to revoke
     */
    public RevokeChatInviteLink(@NotNull Object chatId, @NotNull String inviteLink) {
        super(ChatInviteLinkResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("invite_link", inviteLink);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}