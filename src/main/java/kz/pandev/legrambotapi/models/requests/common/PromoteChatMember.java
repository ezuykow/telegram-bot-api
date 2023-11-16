package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to promote or demote a user in a supergroup or a channel.
 * The bot must be an administrator in the chat for this to work and must have the appropriate
 * administrator rights. Pass False for all boolean parameters to demote a user. Returns True on success.
 * @author ezuykow
 */
public class PromoteChatMember extends Request<PromoteChatMember, Response> {

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
     * Set parameter is_anonymous
     * @param isAnonymous Pass True if the administrator's presence in the chat is hidden
     * @return this request
     */
    public PromoteChatMember isAnonymous(boolean isAnonymous) {
        return addParameter("is_anonymous", isAnonymous);
    }

    /**
     * Set parameter can_manage_chat
     * @param canManageChat Pass True if the administrator can access the chat event log, boost list in channels,
     *                     see channel members, report spam messages, see anonymous administrators in supergroups
     *                     and ignore slow mode. Implied by any other administrator privilege
     * @return this request
     */
    public PromoteChatMember canManageChat(boolean canManageChat) {
        return addParameter("can_manage_chat", canManageChat);
    }

    /**
     * Set parameter can_change_info
     * @param canChangeInfo Pass True if the administrator can change chat title, photo and other settings
     * @return this request
     */
    public PromoteChatMember canChangeInfo(boolean canChangeInfo) {
        return addParameter("can_change_info", canChangeInfo);
    }

    /**
     * Set parameter can_post_messages
     * @param canPostMessages Pass True if the administrator can post messages in the channel, or access channel
     *                       statistics; channels only
     * @return this request
     */
    public PromoteChatMember canPostMessages(boolean canPostMessages) {
        return addParameter("can_post_messages", canPostMessages);
    }

    /**
     * Set parameter can_edit_messages
     * @param canEditMessages Pass True if the administrator can edit messages of other users and can pin messages;
     *                       channels only
     * @return this request
     */
    public PromoteChatMember canEditMessages(boolean canEditMessages) {
        return addParameter("can_edit_messages", canEditMessages);
    }

    /**
     * Set parameter can_delete_messages
     * @param canDeleteMessages Pass True if the administrator can delete messages of other users
     * @return this request
     */
    public PromoteChatMember canDeleteMessages(boolean canDeleteMessages) {
        return addParameter("can_delete_messages", canDeleteMessages);
    }

    /**
     * Set parameter can_post_stories
     * @param canPostStories Pass True if the administrator can post stories in the channel; channels only
     * @return this request
     */
    public PromoteChatMember canPostStories(boolean canPostStories) {
        return addParameter("can_post_stories", canPostStories);
    }

    /**
     * Set parameter can_edit_stories
     * @param canEditStories Pass True if the administrator can edit stories posted by other users; channels only
     * @return this request
     */
    public PromoteChatMember canEditStories(boolean canEditStories) {
        return addParameter("can_edit_stories", canEditStories);
    }

    /**
     * Set parameter can_delete_stories
     * @param canDeleteStories Pass True if the administrator can delete stories posted by other users; channels only
     * @return this request
     */
    public PromoteChatMember canDeleteStories(boolean canDeleteStories) {
        return addParameter("can_delete_stories", canDeleteStories);
    }

    /**
     * Set parameter can_manage_video_chats
     * @param canManageVideoChats Pass True if the administrator can manage video chats
     * @return this request
     */
    public PromoteChatMember canManageVideoChats(boolean canManageVideoChats) {
        return addParameter("can_manage_video_chats", canManageVideoChats);
    }

    /**
     * Set parameter can_invite_users
     * @param canInviteUsers Pass True if the administrator can invite new users to the chat
     * @return this request
     */
    public PromoteChatMember canInviteUsers(boolean canInviteUsers) {
        return addParameter("can_invite_users", canInviteUsers);
    }

    /**
     * Set parameter can_restrict_members
     * @param canRestrictMembers Pass True if the administrator can restrict, ban or unban chat members,
     *                          or access supergroup statistics
     * @return this request
     */
    public PromoteChatMember canRestrictMembers(boolean canRestrictMembers) {
        return addParameter("can_restrict_members", canRestrictMembers);
    }

    /**
     * Set parameter can_pin_messages
     * @param canPinMessages Pass True if the administrator can pin messages, supergroups only
     * @return this request
     */
    public PromoteChatMember canPinMessages(boolean canPinMessages) {
        return addParameter("can_pin_messages", canPinMessages);
    }

    /**
     * Set parameter can_manage_topics
     * @param canManageTopics Pass True if the user is allowed to create, rename, close, and reopen forum topics,
     *                       supergroups only
     * @return this request
     */
    public PromoteChatMember canManageTopics(boolean canManageTopics) {
        return addParameter("can_manage_topics", canManageTopics);
    }

    /**
     * Set parameter can_promote_members
     * @param canPromoteMembers Pass True if the administrator can add new administrators with a subset of their own
     *                         privileges or demote administrators that they have promoted, directly or indirectly
     *                         (promoted by administrators that were appointed by him)
     * @return this request
     */
    public PromoteChatMember canPromoteMembers(boolean canPromoteMembers) {
        return addParameter("can_promote_members", canPromoteMembers);
    }

    //endregion
}