package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method for your bot to leave a group, supergroup or channel. Returns True on success.
 * @author ezuykow
 */
public class LeaveChat extends Request<LeaveChat, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     */
    public LeaveChat(@NotNull Object chatId) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}