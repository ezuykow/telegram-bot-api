package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to set a new group sticker set for a supergroup. The bot must be an administrator
 * in the chat for this to work and must have the appropriate administrator rights. Use the field
 * can_set_sticker_set optionally returned in getChat requests to check if the bot can use this method.
 * Returns True on success.
 * @author ezuykow
 */
public class SetChatStickerSet extends Request<SetChatStickerSet, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param stickerSetName Name of the sticker set to be set as the group sticker set
     */
    public SetChatStickerSet(@NotNull Object chatId, @NotNull String stickerSetName) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("sticker_set_name", stickerSetName);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}