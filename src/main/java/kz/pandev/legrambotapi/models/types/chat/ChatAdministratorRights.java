package kz.pandev.legrambotapi.models.types.chat;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents the rights of an administrator in a chat
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ChatAdministratorRights implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * True, if the user's presence in the chat is hidden
     */
    @SerializedName("is_anonymous")
    private Boolean isAnonymous;

    /**
     * True, if the administrator can access the chat event log, boost list in channels, see channel members, report
     * spam messages, see anonymous administrators in supergroups and ignore slow mode. Implied by any other
     * administrator privilege
     */
    @SerializedName("can_manage_chat")
    private Boolean canManageChat;

    /**
     * True, if the administrator can delete messages of other users
     */
    @SerializedName("can_delete_messages")
    private Boolean canDeleteMessage;

    /**
     * True, if the administrator can manage video chats
     */
    @SerializedName("can_manage_video_chats")
    private Boolean canManageVideoChat;

    /**
     * True, if the administrator can restrict, ban or unban chat members, or access supergroup statistics
     */
    @SerializedName("can_restrict_members")
    private Boolean canRestrictMembers;

    /**
     * True, if the administrator can add new administrators with a subset of their own privileges or demote
     * administrators that they have promoted, directly or indirectly (promoted by administrators that were
     * appointed by the user)
     */
    @SerializedName("can_promote_members")
    private Boolean canPromoteMembers;

    /**
     * True, if the user is allowed to change the chat title, photo and other settings
     */
    @SerializedName("can_change_info")
    private Boolean canChangeInfo;

    /**
     * True, if the user is allowed to invite new users to the chat
     */
    @SerializedName("can_invite_users")
    private Boolean canInviteUsers;

    /**
     * Optional. True, if the administrator can post messages in the channel, or access channel statistics;
     * channels only
     */
    @SerializedName("can_post_messages")
    @Nullable
    private Boolean canPostMessages;

    /**
     * Optional. True, if the administrator can edit messages of other users and can pin messages; channels only
     */
    @SerializedName("can_edit_messages")
    @Nullable
    private Boolean canEditMessages;

    /**
     * Optional. True, if the user is allowed to pin messages; groups and supergroups only
     */
    @SerializedName("can_pin_messages")
    @Nullable
    private Boolean canPinMessages;

    /**
     * Optional. True, if the administrator can post stories in the channel; channels only
     */
    @SerializedName("can_post_stories")
    @Nullable
    private Boolean canPostStories;

    /**
     * Optional. True, if the administrator can edit stories posted by other users; channels only
     */
    @SerializedName("can_edit_stories")
    @Nullable
    private Boolean canEditStories;

    /**
     * Optional. True, if the administrator can delete stories posted by other users; channels only
     */
    @SerializedName("can_delete_stories")
    @Nullable
    private Boolean canDeleteStories;

    /**
     * Optional. True, if the user is allowed to create, rename, close, and reopen forum topics; supergroups only
     */
    @SerializedName("can_manage_topics")
    @Nullable
    private Boolean canManageTopics;
}