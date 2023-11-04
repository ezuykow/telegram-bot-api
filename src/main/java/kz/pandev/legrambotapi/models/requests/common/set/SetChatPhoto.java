package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * Use this method to set a new profile photo for the chat. Photos can't be changed for private chats.
 * The bot must be an administrator in the chat for this to work and must have the appropriate administrator
 * rights. Returns True on success.
 * @author ezuykow
 */
public class SetChatPhoto extends Request<SetChatPhoto, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param photo New chat photo, java.io.File or byte[]
     */
    public SetChatPhoto(@NotNull Object chatId, @NotNull Object photo) {
        super(Response.class);
        if ((chatId instanceof Number || chatId instanceof String)
                && (photo instanceof File || photo instanceof byte[])) {
            addParameter("chat_id", chatId);
            addParameter("photo", photo);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String " +
                    "(if it's chat username). Type of parameter photo must be java.io.File or byte[]");
        }
    }

    //region API

    @Override
    public boolean isMultipart() {
        return true;
    }

    //endregion
}