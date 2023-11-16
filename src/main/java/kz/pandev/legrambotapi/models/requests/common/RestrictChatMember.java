package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.chat.ChatPermissions;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup
 * for this to work and must have the appropriate administrator rights. Pass True for all permissions to
 * lift restrictions from a user. Returns True on success.
 * @author ezuykow
 */
public class RestrictChatMember extends Request<RestrictChatMember, Response> {

    /**
     * @param chatId Unique identifier for the target group or username of the target supergroup or channel (in the format @channelusername)
     * @param userId Unique identifier of the target user
     * @param permissions {@link ChatPermissions}
     */
    public RestrictChatMember(@NotNull Object chatId, long userId, @NotNull ChatPermissions permissions) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("user_id", userId);
            addParameter("permissions", permissions);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    //region API

    /**
     * Set parameter until_date
     * @param untilDate Date when restrictions will be lifted for the user; Unix time. If user is restricted for more
     *                  than 366 days or less than 30 seconds from the current time, they are considered to be
     *                  restricted forever
     * @return this request
     */
    public RestrictChatMember untilDate(int untilDate) {
        return addParameter("until_date", untilDate);
    }

    /**
     * Set parameter use_independent_chat_permissions
     * @param useIndependentChatPermissions Pass True if chat permissions are set independently. Otherwise, the
     *                                      can_send_other_messages and can_add_web_page_previews permissions will
     *                                      imply the can_send_messages, can_send_audios, can_send_documents,
     *                                      can_send_photos, can_send_videos, can_send_video_notes,
     *                                      and can_send_voice_notes permissions; the can_send_polls permission will
     *                                      imply the can_send_messages permission.
     * @return this request
     */
    public RestrictChatMember useIndependentChatPermissions(boolean useIndependentChatPermissions) {
        return addParameter("use_independent_chat_permissions", useIndependentChatPermissions);
    }

    //endregion
}