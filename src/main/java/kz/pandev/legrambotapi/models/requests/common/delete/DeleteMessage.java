package kz.pandev.legrambotapi.models.requests.common.delete;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to delete a message, including service messages, with the following limitations: <br>
 * - A message can only be deleted if it was sent less than 48 hours ago. <br>
 * - Service messages about a supergroup, channel, or forum topic creation can't be deleted. <br>
 * - A dice message in a private chat can only be deleted if it was sent more than 24 hours ago. <br>
 * - Bots can delete outgoing messages in private chats, groups, and supergroups. <br>
 * - Bots can delete incoming messages in private chats. <br>
 * - Bots granted can_post_messages permissions can delete outgoing messages in channels. <br>
 * - If the bot is an administrator of a group, it can delete any message there. <br>
 * - If the bot has can_delete_messages permission in a supergroup or a channel, it can delete any message there. <br>
 * Returns True on success.
 * @author ezuykow
 */
public class DeleteMessage extends Request<DeleteMessage, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Identifier of the message to delete
     */
    public DeleteMessage(@NotNull Object chatId, int messageId) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("message_id", messageId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}