package kz.pandev.legrambotapi.models.types.common.chat;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents the rights of an administrator in a chat
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode
@ToString
public class ChatAdministratorRights implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * True, if the user's presence in the chat is hidden
     */
    @SerializedName("is_anonymous")
    private boolean isAnonymous;

    /**
     * True, if the administrator can access the chat event log, boost list in channels, see channel members, report
     * spam messages, see anonymous administrators in supergroups and ignore slow mode. Implied by any other
     * administrator privilege
     */
    @SerializedName("can_manage_chat")
    private boolean canManageChat;

    /**
     * True, if the administrator can delete messages of other users
     */
    @SerializedName("can_delete_messages")
    private boolean canDeleteMessages;

    /**
     * True, if the administrator can manage video chats
     */
    @SerializedName("can_manage_video_chats")
    private boolean canManageVideoChats;

    /**
     * True, if the administrator can restrict, ban or unban chat members, or access supergroup statistics
     */
    @SerializedName("can_restrict_members")
    private boolean canRestrictMembers;

    /**
     * True, if the administrator can add new administrators with a subset of their own privileges or demote
     * administrators that they have promoted, directly or indirectly (promoted by administrators that were
     * appointed by the user)
     */
    @SerializedName("can_promote_members")
    private boolean canPromoteMembers;

    /**
     * True, if the user is allowed to change the chat title, photo and other settings
     */
    @SerializedName("can_change_info")
    private boolean canChangeInfo;

    /**
     * True, if the user is allowed to invite new users to the chat
     */
    @SerializedName("can_invite_users")
    private boolean canInviteUsers;

    /**
     * Optional. True, if the administrator can post messages in the channel, or access channel statistics;
     * channels only
     */
    @SerializedName("can_post_messages")
    private boolean canPostMessages;

    /**
     * Optional. True, if the administrator can edit messages of other users and can pin messages; channels only
     */
    @SerializedName("can_edit_messages")
    private boolean canEditMessages;

    /**
     * Optional. True, if the user is allowed to pin messages; groups and supergroups only
     */
    @SerializedName("can_pin_messages")
    private boolean canPinMessages;

    /**
     * Optional. True, if the administrator can post stories in the channel; channels only
     */
    @SerializedName("can_post_stories")
    private boolean canPostStories;

    /**
     * Optional. True, if the administrator can edit stories posted by other users; channels only
     */
    @SerializedName("can_edit_stories")
    private boolean canEditStories;

    /**
     * Optional. True, if the administrator can delete stories posted by other users; channels only
     */
    @SerializedName("can_delete_stories")
    private boolean canDeleteStories;

    /**
     * Optional. True, if the user is allowed to create, rename, close, and reopen forum topics; supergroups only
     */
    @SerializedName("can_manage_topics")
    private boolean canManageTopics;

    //region API

    /**
     * Set parameter {@link ChatAdministratorRights#canManageChat}
     * @param canManageChat new parameter value
     * @return this
     */
    public ChatAdministratorRights canManageChat(boolean canManageChat) {
        this.canManageChat = canManageChat;
        return this;
    }

    /**
     * Set parameter {@link ChatAdministratorRights#canDeleteMessages}
     * @param canDeleteMessages new parameter value
     * @return this
     */
    public ChatAdministratorRights canDeleteMessages(boolean canDeleteMessages) {
        this.canDeleteMessages = canDeleteMessages;
        return this;
    }

    /**
     * Set parameter {@link ChatAdministratorRights#canManageVideoChats}
     * @param canManageVideoChats new parameter value
     * @return this
     */
    public ChatAdministratorRights canManageVideoChats(boolean canManageVideoChats) {
        this.canManageVideoChats = canManageVideoChats;
        return this;
    }

    /**
     * Set parameter {@link ChatAdministratorRights#canRestrictMembers}
     * @param canRestrictMembers new parameter value
     * @return this
     */
    public ChatAdministratorRights canRestrictMembers(boolean canRestrictMembers) {
        this.canRestrictMembers = canRestrictMembers;
        return this;
    }

    /**
     * Set parameter {@link ChatAdministratorRights#canPromoteMembers}
     * @param canPromoteMembers new parameter value
     * @return this
     */
    public ChatAdministratorRights canPromoteMembers(boolean canPromoteMembers) {
        this.canPromoteMembers = canPromoteMembers;
        return this;
    }

    /**
     * Set parameter {@link ChatAdministratorRights#canChangeInfo}
     * @param canChangeInfo new parameter value
     * @return this
     */
    public ChatAdministratorRights canChangeInfo(boolean canChangeInfo) {
        this.canChangeInfo = canChangeInfo;
        return this;
    }

    /**
     * Set parameter {@link ChatAdministratorRights#canInviteUsers}
     * @param canInviteUsers new parameter value
     * @return this
     */
    public ChatAdministratorRights canInviteUsers(boolean canInviteUsers) {
        this.canInviteUsers = canInviteUsers;
        return this;
    }

    /**
     * Set parameter {@link ChatAdministratorRights#canPostMessages}
     * @param canPostMessages new parameter value
     * @return this
     */
    public ChatAdministratorRights canPostMessages(boolean canPostMessages) {
        this.canPostMessages = canPostMessages;
        return this;
    }

    /**
     * Set parameter {@link ChatAdministratorRights#canEditMessages}
     * @param canEditMessages new parameter value
     * @return this
     */
    public ChatAdministratorRights canEditMessages(boolean canEditMessages) {
        this.canEditMessages = canEditMessages;
        return this;
    }

    /**
     * Set parameter {@link ChatAdministratorRights#canPinMessages}
     * @param canPinMessages new parameter value
     * @return this
     */
    public ChatAdministratorRights canPinMessages(boolean canPinMessages) {
        this.canPinMessages = canPinMessages;
        return this;
    }

    /**
     * Set parameter {@link ChatAdministratorRights#canPostStories}
     * @param canPostStories new parameter value
     * @return this
     */
    public ChatAdministratorRights canPostStories(boolean canPostStories) {
        this.canPostStories = canPostStories;
        return this;
    }

    /**
     * Set parameter {@link ChatAdministratorRights#canEditStories}
     * @param canEditStories new parameter value
     * @return this
     */
    public ChatAdministratorRights canEditStories(boolean canEditStories) {
        this.canEditStories = canEditStories;
        return this;
    }

    /**
     * Set parameter {@link ChatAdministratorRights#canDeleteStories}
     * @param canDeleteStories new parameter value
     * @return this
     */
    public ChatAdministratorRights canDeleteStories(boolean canDeleteStories) {
        this.canDeleteStories = canDeleteStories;
        return this;
    }

    /**
     * Set parameter {@link ChatAdministratorRights#canManageTopics}
     * @param canManageTopics new parameter value
     * @return this
     */
    public ChatAdministratorRights canManageTopics(boolean canManageTopics) {
        this.canManageTopics = canManageTopics;
        return this;
    }

    //endregion
}