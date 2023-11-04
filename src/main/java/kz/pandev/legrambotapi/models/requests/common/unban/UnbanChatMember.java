package kz.pandev.legrambotapi.models.requests.common.unban;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to unban a previously banned user in a supergroup or channel.
 * The user will not return to the group or channel automatically, but will be able to join via link, etc.
 * The bot must be an administrator for this to work. By default, this method guarantees that after the call
 * the user is not a member of the chat, but will be able to join it. So if the user is a member of the chat
 * they will also be removed from the chat. If you don't want this, use the parameter only_if_banned.
 * Returns True on success.
 * @author ezuykow
 */
@Getter
public class UnbanChatMember extends Request<UnbanChatMember, Response> {

    /**
     * Optional. Do nothing if the user is not banned
     */
    @Nullable
    private Boolean onlyIfBanned;

    /**
     * @param chatId Unique identifier for the target group or username of the target supergroup or channel (in the format @channelusername)
     * @param userId Unique identifier of the target user
     */
    public UnbanChatMember(@NotNull Object chatId, long userId) {
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
     * Set parameter {@link UnbanChatMember#onlyIfBanned}
     * @param onlyIfBanned new parameter value
     * @return this request
     */
    public UnbanChatMember onlyIfBanned(boolean onlyIfBanned) {
        this.onlyIfBanned = onlyIfBanned;
        return addParameter("only_if_banned", onlyIfBanned);
    }

    //endregion
}