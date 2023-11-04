package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.chat.ChatPermissions;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to set default chat permissions for all members. The bot must be an administrator
 * in the group or a supergroup for this to work and must have the can_restrict_members administrator
 * rights. Returns True on success.
 * @author ezuykow
 */
@Getter
public class SetChatPermissions extends Request<SetChatPermissions, Response> {

    /**
     * Optional. Pass True if chat permissions are set independently. Otherwise, the can_send_other_messages
     * and can_add_web_page_previews permissions will imply the can_send_messages, can_send_audios,
     * can_send_documents, can_send_photos, can_send_videos, can_send_video_notes,
     * and can_send_voice_notes permissions; the can_send_polls permission will imply the can_send_messages permission.
     */
    @Nullable
    private Boolean useIndependentChatPermissions;

    /**
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     * @param permissions {@link ChatPermissions} - new default chat permissions
     */
    public SetChatPermissions(@NotNull Object chatId, @NotNull ChatPermissions permissions) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("permissions", permissions);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    //region API

    /**
     * Set parameter {@link SetChatPermissions#useIndependentChatPermissions}
     * @param useIndependentChatPermissions new parameter value
     * @return this request
     */
    public SetChatPermissions useIndependentChatPermissions(boolean useIndependentChatPermissions) {
        this.useIndependentChatPermissions = useIndependentChatPermissions;
        return addParameter("use_independent_chat_permissions", useIndependentChatPermissions);
    }

    //endregion
}