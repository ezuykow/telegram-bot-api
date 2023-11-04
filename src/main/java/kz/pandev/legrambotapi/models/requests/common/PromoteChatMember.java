package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to promote or demote a user in a supergroup or a channel.
 * The bot must be an administrator in the chat for this to work and must have the appropriate
 * administrator rights. Pass False for all boolean parameters to demote a user. Returns True on success.
 * @author ezuykow
 */
@Getter
public class PromoteChatMember extends Request<PromoteChatMember, Response> {

    /**
     * Optional. Pass True if the administrator's presence in the chat is hidden
     */
    @Nullable
    private Boolean isAnonymous;
    /**
     * Optional. Pass True if the administrator can access the chat event log, boost list in channels,
     * see channel members, report spam messages, see anonymous administrators in supergroups
     * and ignore slow mode. Implied by any other administrator privilege
     */
    @Nullable
    private Boolean canManageChat;
    /**
     * Optional. Pass True if the administrator can delete messages of other users
     */
    @Nullable
    private Boolean canDeleteMessages;
    /**
     * Optional. Pass True if the administrator can manage video chats
     */
    @Nullable
    private Boolean canManageVideoChats;
    /**
     * Optional. Pass True if the administrator can restrict, ban or unban chat members, or access supergroup statistics
     */
    @Nullable
    private Boolean canRestrictMembers;
    /**
     * Optional. Pass True if the administrator can add new administrators with a subset of their own
     * privileges or demote administrators that they have promoted, directly or indirectly (promoted
     * by administrators that were appointed by him)
     */
    @Nullable
    private Boolean canPromoteMembers;
    /**
     * Optional. Pass True if the administrator can change chat title, photo and other settings
     */
    @Nullable
    private Boolean canChangeInfo;
    /**
     * Optional. Pass True if the administrator can invite new users to the chat
     */
    @Nullable
    private Boolean canInviteUsers;
    /**
     * Optional. Pass True if the administrator can post messages in the channel, or access channel statistics; channels only
     */
    @Nullable
    private Boolean canPostMessages;
    /**
     * Optional. Pass True if the administrator can edit messages of other users and can pin messages; channels only
     */
    @Nullable
    private Boolean canEditMessages;
    /**
     * Optional. Pass True if the administrator can pin messages, supergroups only
     */
    @Nullable
    private Boolean canPinMessages;
    /**
     * Optional. Pass True if the administrator can post stories in the channel; channels only
     */
    @Nullable
    private Boolean canPostStories;
    /**
     * Optional. Pass True if the administrator can edit stories posted by other users; channels only
     */
    @Nullable
    private Boolean canEditStories;
    /**
     * Optional. Pass True if the administrator can delete stories posted by other users; channels only
     */
    @Nullable
    private Boolean canDeleteStories;
    /**
     * Optional. Pass True if the user is allowed to create, rename, close, and reopen forum topics, supergroups only
     */
    @Nullable
    private Boolean canManageTopics;

    /**
     * @param chatId Unique identifier for the target group or username of the target supergroup or channel (in the format @channelusername)
     * @param userId Unique identifier of the target user
     */
    public PromoteChatMember(@NotNull Object chatId, long userId) {
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
     * Set parameter {@link PromoteChatMember#isAnonymous}
     * @param isAnonymous new parameter value
     * @return this request
     */
    public PromoteChatMember isAnonymous(boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
        return addParameter("is_anonymous", isAnonymous);
    }

    /**
     * Set parameter {@link PromoteChatMember#canManageChat}
     * @param canManageChat new parameter value
     * @return this request
     */
    public PromoteChatMember canManageChat(boolean canManageChat) {
        this.canManageChat = canManageChat;
        return addParameter("can_manage_chat", canManageChat);
    }

    /**
     * Set parameter {@link PromoteChatMember#canChangeInfo}
     * @param canChangeInfo new parameter value
     * @return this request
     */
    public PromoteChatMember canChangeInfo(boolean canChangeInfo) {
        this.canChangeInfo = canChangeInfo;
        return addParameter("can_change_info", canChangeInfo);
    }

    /**
     * Set parameter {@link PromoteChatMember#canPostMessages}
     * @param canPostMessages new parameter value
     * @return this request
     */
    public PromoteChatMember canPostMessages(boolean canPostMessages) {
        this.canPostMessages = canPostMessages;
        return addParameter("can_post_messages", canPostMessages);
    }

    /**
     * Set parameter {@link PromoteChatMember#canEditMessages}
     * @param canEditMessages new parameter value
     * @return this request
     */
    public PromoteChatMember canEditMessages(boolean canEditMessages) {
        this.canEditMessages = canEditMessages;
        return addParameter("can_edit_messages", canEditMessages);
    }

    /**
     * Set parameter {@link PromoteChatMember#canDeleteMessages}
     * @param canDeleteMessages new parameter value
     * @return this request
     */
    public PromoteChatMember canDeleteMessages(boolean canDeleteMessages) {
        this.canDeleteMessages = canDeleteMessages;
        return addParameter("can_delete_messages", canDeleteMessages);
    }

    /**
     * Set parameter {@link PromoteChatMember#canPostStories}
     * @param canPostStories new parameter value
     * @return this request
     */
    public PromoteChatMember canPostStories(boolean canPostStories) {
        this.canPostStories = canPostStories;
        return addParameter("can_post_stories", canPostStories);
    }

    /**
     * Set parameter {@link PromoteChatMember#canEditStories}
     * @param canEditStories new parameter value
     * @return this request
     */
    public PromoteChatMember canEditStories(boolean canEditStories) {
        this.canEditStories = canEditStories;
        return addParameter("can_edit_stories", canEditStories);
    }

    /**
     * Set parameter {@link PromoteChatMember#canDeleteStories}
     * @param canDeleteStories new parameter value
     * @return this request
     */
    public PromoteChatMember canDeleteStories(boolean canDeleteStories) {
        this.canDeleteStories = canDeleteStories;
        return addParameter("can_delete_stories", canDeleteStories);
    }

    /**
     * Set parameter {@link PromoteChatMember#canManageVideoChats}
     * @param canManageVideoChats new parameter value
     * @return this request
     */
    public PromoteChatMember canManageVideoChats(boolean canManageVideoChats) {
        this.canManageVideoChats = canManageVideoChats;
        return addParameter("can_manage_video_chats", canManageVideoChats);
    }

    /**
     * Set parameter {@link PromoteChatMember#canInviteUsers}
     * @param canInviteUsers new parameter value
     * @return this request
     */
    public PromoteChatMember canInviteUsers(boolean canInviteUsers) {
        this.canInviteUsers = canInviteUsers;
        return addParameter("can_invite_users", canInviteUsers);
    }

    /**
     * Set parameter {@link PromoteChatMember#canRestrictMembers}
     * @param canRestrictMembers new parameter value
     * @return this request
     */
    public PromoteChatMember canRestrictMembers(boolean canRestrictMembers) {
        this.canRestrictMembers = canRestrictMembers;
        return addParameter("can_restrict_members", canRestrictMembers);
    }

    /**
     * Set parameter {@link PromoteChatMember#canPinMessages}
     * @param canPinMessages new parameter value
     * @return this request
     */
    public PromoteChatMember canPinMessages(boolean canPinMessages) {
        this.canPinMessages = canPinMessages;
        return addParameter("can_pin_messages", canPinMessages);
    }

    /**
     * Set parameter {@link PromoteChatMember#canManageTopics}
     * @param canManageTopics new parameter value
     * @return this request
     */
    public PromoteChatMember canManageTopics(boolean canManageTopics) {
        this.canManageTopics = canManageTopics;
        return addParameter("can_manage_topics", canManageTopics);
    }

    /**
     * Set parameter {@link PromoteChatMember#canPromoteMembers}
     * @param canPromoteMembers new parameter value
     * @return this request
     */
    public PromoteChatMember canPromoteMembers(boolean canPromoteMembers) {
        this.canPromoteMembers = canPromoteMembers;
        return addParameter("can_promote_members", canPromoteMembers);
    }

    //endregion
}